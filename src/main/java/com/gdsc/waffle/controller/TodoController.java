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
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTodos() {
        List<TodoEntity> todos = todoService.findTodoList(Sort.by(Sort.Direction.ASC, "id"));
        return ResponseEntity.ok(todos);
    }

    /*
     * 	등록
     */
    @PostMapping
    public ResponseEntity<String> postTodo(@RequestBody TodoEntity todoEntity) {
        todoEntity.setCreatedDateTime(LocalDateTime.now());
        todoEntity.setStatus(false);
        todoService.addTodoList(todoEntity);
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    /*
     * 	상태 표시 변경
     */
    @PutMapping("/{id}")
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
    @PutMapping("/{id}")
    public ResponseEntity<String> updateTodo(@PathVariable("id") Integer id, @RequestBody TodoEntity todoEntity) {
        todoEntity.setId(id);

        todoService.addTodoList(todoEntity);

        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    /*
     * 	삭제
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Integer id) {
        todoService.deleteTodoList(id);

        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

}
