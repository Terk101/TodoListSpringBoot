package com.grouplease.sample.sample.service;

import com.grouplease.sample.sample.entity.Todo;

import java.util.List;
import java.util.Optional;

/**
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author:Terk on 1/16/2019.
 */
public interface TodoService {
    Optional<Todo> getTodoById(Long id);
    Optional<Todo> createTodo(Todo todo);
    List<Todo> getAllTodo();
}
