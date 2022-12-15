package com.gdsc.waffle.service;

import com.gdsc.waffle.domain.TodoEntity;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface TodoService {


    TodoEntity findById(Integer id);

    void addTodoList(TodoEntity todoEntity);

    void deleteTodoList(Integer id);

    List<TodoEntity> findTodoList(Sort sort);

}
