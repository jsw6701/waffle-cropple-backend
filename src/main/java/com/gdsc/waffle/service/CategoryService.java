package com.gdsc.waffle.service;

import com.gdsc.waffle.domain.CategoryEntity;
import com.gdsc.waffle.repository.CategoryRepository;
import com.gdsc.waffle.request.CategoryRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor

public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryEntity add(CategoryRequest request){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryId(request.getCategoryId());
        categoryEntity.setCategoryTitle(request.getCategoryTitle());
        return this.categoryRepository.save(categoryEntity);
    }

    public CategoryEntity searchById(Long categoryId){
        return this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    public List<CategoryEntity> searchAll(){
        return this.categoryRepository.findAll();
    }

    public CategoryEntity updateById(Long categoryId, CategoryRequest request){
        CategoryEntity categoryEntity = this.searchById(categoryId);
        if(request.getCategoryTitle() != null){
            categoryEntity.setCategoryTitle(request.getCategoryTitle());
        }
        return this.categoryRepository.save(categoryEntity);
    }

    public void deleteById(Long categoryId){
        this.categoryRepository.deleteById(categoryId);
    }
}
