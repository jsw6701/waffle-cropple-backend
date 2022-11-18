package com.gdsc.waffle.service;

import com.gdsc.waffle.domain.TodoEntity;
import com.gdsc.waffle.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void addTodoList(TodoEntity todoEntity) {
        todoRepository.save(todoEntity);
    }

    @Override
    public TodoEntity updateTodoList(TodoEntity todoDTO) {
        return null;
    }

    public List<TodoEntity> findTodoList(Sort sort){
        return todoRepository.findAll(sort);
    }

    @Override
    public TodoEntity findById(Integer id) {
        return todoRepository.findById(id).orElse(new TodoEntity());
    }

    @Override
    public void deleteTodoList(Integer id) {
        todoRepository.deleteById(id);
    }
}
