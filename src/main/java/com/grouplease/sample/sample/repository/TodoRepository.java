package com.grouplease.sample.sample.repository;

import com.grouplease.sample.sample.entity.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author:Terk on 1/16/2019.
 */
@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
}
