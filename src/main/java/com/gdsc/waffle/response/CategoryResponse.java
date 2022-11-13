package com.gdsc.waffle.response;

import com.gdsc.waffle.domain.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CategoryResponse {
    private String url;
    private Long categoryId;
    private String categoryTitle;

    public CategoryResponse(CategoryEntity categoryEntity){
        this.categoryId = categoryEntity.getCategoryId();
        this.categoryTitle = categoryEntity.getCategoryTitle();

        this.url = "http://localhost:9092/" + this.categoryId;
    }
}
