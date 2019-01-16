package com.grouplease.sample.sample.service;

import com.grouplease.sample.sample.entity.Todo;
import com.grouplease.sample.sample.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author:Terk on 1/16/2019.
 */
@Service
public class TodoServiceImpl implements TodoService { //https://stackoverflow.com/questions/23561939/why-use-interface-in-dao-design-pattern-or-other-design-patterns
    private final TodoRepository repository;

    @Autowired
    /*Inject bean for more detail please check link
    https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring */

    public TodoServiceImpl(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Todo> getTodoById(Long id) {

        return repository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Todo> createTodo(Todo todo) {
        todo.setId(null);
        Optional<Todo> newTodo = Optional.of(repository.save(todo));

        return newTodo;
    }

    @Override
    public List<Todo> getAllTodo() {
        return (List<Todo>)repository.findAll();
    }
}
