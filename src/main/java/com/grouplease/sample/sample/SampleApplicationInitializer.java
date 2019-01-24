package com.grouplease.sample.sample;

import com.grouplease.sample.sample.entity.Todo;
import com.grouplease.sample.sample.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class SampleApplicationInitializer implements ApplicationRunner {

    @Autowired
    TodoService service;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        List<Todo> todos = Arrays.asList(new Todo("Watching Netfix.", new Date(), Boolean.FALSE),
                new Todo("Reading boox", new Date(), Boolean.FALSE),
                new Todo("Workout", new Date(), Boolean.FALSE),
                new Todo("Party time..", new Date(), Boolean.FALSE));

        todos.forEach(todo -> service.createTodo(todo));
    }
}
