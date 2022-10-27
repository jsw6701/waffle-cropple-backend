package com.gdsc.waffle.service;

import com.gdsc.waffle.domain.TodoEntity;
import com.gdsc.waffle.dto.TodoRequest;
import com.gdsc.waffle.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoEntity add(TodoRequest request) {
        TodoEntity todoEntity = new TodoEntity();

        todoEntity.setContent(request.getContent());
        todoEntity.setStatus(request.getStatus());

        TodoEntity result = this.todoRepository.save(todoEntity);

        return result;
    }

    public TodoEntity searchById(Integer id) {
        return this.todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<TodoEntity> searchAll() {
        return this.todoRepository.findAll();
    }

    public TodoEntity updateById(Integer id, TodoRequest todoDTO) {
        TodoEntity todoEntity = this.searchById(id);

        if (todoDTO.getContent() != null) {
            todoEntity.setContent(todoDTO.getContent());
        }

        if (todoDTO.getStatus() != null) {
            todoEntity.setStatus(todoDTO.getStatus());
        }

        return this.todoRepository.save(todoEntity);
    }

    public void deleteById(Integer id) {
        this.todoRepository.deleteById(id);
    }

    public void deleteAll() {
        this.todoRepository.deleteAll();
    }
}
