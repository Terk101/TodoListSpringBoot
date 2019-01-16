package com.grouplease.sample.sample.resource;

import com.grouplease.sample.sample.entity.Todo;
import com.grouplease.sample.sample.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author:Terk on 1/16/2019.
 */
@RestController
@RequestMapping("/todos")
public class TodoResource {
    private final TodoService todoService;

    @Autowired
    public TodoResource(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getTodos() {
        return todoService.getAllTodo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTodoById(@PathVariable Long id) {
        Optional<Todo> todoOption = todoService.getTodoById(id);
        if (!todoOption.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(todoOption);
    }

    @PostMapping()
    public ResponseEntity<?> postCustomer(@Valid @RequestBody Todo body) {
        Optional<Todo> todo = todoService.createTodo(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }
}
