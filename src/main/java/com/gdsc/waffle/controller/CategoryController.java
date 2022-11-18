package com.gdsc.waffle.controller;

import com.gdsc.waffle.domain.CategoryEntity;
import com.gdsc.waffle.domain.TodoEntity;
import com.gdsc.waffle.request.CategoryRequest;
import com.gdsc.waffle.response.CategoryResponse;
import com.gdsc.waffle.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/")
@RestController
public class CategoryController {
    private final CategoryService service;

    @PostMapping
    public ResponseEntity<CategoryResponse> create(@RequestBody CategoryRequest request){
        System.out.println("create");
        if(ObjectUtils.isEmpty(request.getCategoryTitle()))
            return ResponseEntity.badRequest().build();
        CategoryEntity result = this.service.add(request);
            return ResponseEntity.ok(new CategoryResponse(result));
    }
    //생성

    @GetMapping("{categoryId}")
    public ResponseEntity<CategoryResponse> readOne(@PathVariable Long categoryId){
        System.out.println("read one");
        CategoryEntity result = this.service.searchById(categoryId);
        return ResponseEntity.ok(new CategoryResponse(result));
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> readAll(){
        System.out.println("read all");
        List<CategoryEntity> list = this.service.searchAll();
        List<CategoryResponse> response = list.stream().map(CategoryResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PatchMapping("{categoryId}")
    public ResponseEntity<CategoryResponse> update(@PathVariable Long categoryId, @RequestBody CategoryRequest request){
        System.out.println("update");
        CategoryEntity result = this.service.updateById(categoryId, request);
        return ResponseEntity.ok(new CategoryResponse(result));
    }
    //수정

    @DeleteMapping("{categoryId}")
    public ResponseEntity<?> deleteOne(@PathVariable Long categoryId){
        System.out.println("delete");
        this.service.deleteById(categoryId);
        return ResponseEntity.ok().build();
    }
    //삭제
}
