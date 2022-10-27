package com.gdsc.waffle.dto;

import com.gdsc.waffle.domain.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponse {
    private Integer id;
    private String context;
    private Boolean status;
    private String url;

    public TodoResponse(TodoEntity todoEntity) {
        this.id = todoEntity.getId();
        this.context = todoEntity.getContent();
        this.status = todoEntity.getStatus();
        this.url = "http://localhost:8080/" + this.id;
    }

}
