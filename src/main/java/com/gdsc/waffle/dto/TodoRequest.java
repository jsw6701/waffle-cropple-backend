package com.gdsc.waffle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoRequest {
    private Integer id;
    private String content;
    private Boolean status;
}
