package com.grouplease.sample.sample.repository;

import com.grouplease.sample.sample.entity.Todo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TodoRepositoryTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void findById() {
        // given
        String task = "Hello test one two..";
        Todo todo = new Todo(task, new Date(), Boolean.FALSE);
        em.persistAndFlush(todo);

        // when
        Optional<Todo> found = todoRepository.findById(todo.getId());

        // then
        assertThat(found.isPresent()).isTrue();
        found.ifPresent(
                foundTodo -> assertThat(foundTodo.getId())
                        .isEqualTo(todo.getId())
        );
    }
}
