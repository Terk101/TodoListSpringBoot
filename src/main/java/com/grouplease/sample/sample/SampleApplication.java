package com.grouplease.sample.sample;

import com.grouplease.sample.sample.entity.Todo;
import com.grouplease.sample.sample.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SampleApplication implements CommandLineRunner {
	@Autowired
	TodoService service;

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Todo> todos = Arrays.asList(new Todo("Watching Netfix.", new Date(), Boolean.FALSE),
				new Todo("Reading boox", new Date(), Boolean.FALSE),
				new Todo("Workout", new Date(), Boolean.FALSE),
				new Todo("Party time..", new Date(), Boolean.FALSE));

		todos.stream().forEach(todo -> {
			service.createTodo(todo);
		});
		}
}

