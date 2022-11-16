package com.gdsc.waffle.controller;

import com.gdsc.waffle.domain.TodoEntity;
import com.gdsc.waffle.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private final TodoService todoService;

    /*
     *     목록 조회
     */
    @GetMapping(value = "/todo", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTodos() {
        List<TodoEntity> todos = todoService.findTodoList(Sort.by(Sort.Direction.ASC, "id"));
        return ResponseEntity.ok(todos);
    }

    /*
     * 	등록
     */
    @PostMapping("/todo")
    public ResponseEntity<String> postTodo(@RequestBody TodoEntity todoEntity) {
        todoEntity.setCreatedDateTime(LocalDateTime.now());
        todoEntity.setStatus(false);
        todoService.addTodoList(todoEntity);
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    /*
     * 	상태 표시 변경
     */
    @PutMapping("/todo/{id}")
    public ResponseEntity<String> putTodo(@PathVariable("id") Integer id) {
        TodoEntity todoEntity = todoService.findById(id);

        Boolean isComplete = !todoEntity.getStatus();
        todoEntity.setStatus(isComplete);
        todoService.addTodoList(todoEntity);

        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    /*
     * 	내용 수정
     */
    @PutMapping("/todo/modify/{id}")
    public ResponseEntity<String> updateTodo(@PathVariable("id") Integer id, @RequestBody TodoEntity todoEntity) {
        TodoEntity todoEntity1 = todoService.findById(id);

        todoEntity1.setContent(todoEntity.getContent());
        todoService.addTodoList(todoEntity1);

        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    /*
     * 	삭제
     */
    @DeleteMapping("/todo/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Integer id) {
        todoService.deleteTodoList(id);
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

}
