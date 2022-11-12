package com.gdsc.waffle.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CategoryRequest {
    private Long categoryId ;
    private String categoryTitle ;
}
