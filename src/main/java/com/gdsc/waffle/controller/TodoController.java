package com.gdsc.waffle.controller;

import com.gdsc.waffle.domain.TodoEntity;
import com.gdsc.waffle.dto.TodoRequest;
import com.gdsc.waffle.dto.TodoResponse;
import com.gdsc.waffle.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/")
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest request) {
        System.out.println("CREATE");

        if (ObjectUtils.isEmpty(request.getContent())) {
            return ResponseEntity.badRequest().build();
        }

        if (ObjectUtils.isEmpty(request.getStatus())) {
            request.setStatus(false);
        }

        TodoEntity result = this.todoService.add(request);

        return ResponseEntity.ok(new TodoResponse(result));
    }

    @GetMapping("{id}")
    public ResponseEntity<TodoResponse> readOne(@PathVariable Integer id) {
        TodoEntity result = this.todoService.searchById(id);

        return ResponseEntity.ok(new TodoResponse(result));
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> readAll() {
        List<TodoEntity> resultList = this.todoService.searchAll();
        List<TodoResponse> response = resultList.stream().map(TodoResponse::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PatchMapping("{id}")
    public ResponseEntity<TodoResponse> update(@PathVariable Integer id, @RequestBody TodoRequest todoDTO) {
        TodoEntity result = this.todoService.updateById(id, todoDTO);

        return ResponseEntity.ok(new TodoResponse(result));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> removeOne(@PathVariable Integer id) {
        this.todoService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> removeAll() {
        this.todoService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
