package com.grouplease.sample.sample.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * Copyright (c) Group Lease Public Company Limited. All rights reserved. (http://www.grouplease.co.th/)
 * Author:Terk on 1/16/2019.
 */

//https://www.baeldung.com/spring-data-annotations
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String task;

    private Date createDate;

    private Boolean completed;

    public Todo() {} //Is required empty construct

    public Todo(String task, Date createDate, Boolean completed) {
        this.task = task;
        this.createDate = createDate;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return String.format(
                "Todo (id=%s, task=%s, createDate=%s, completed=%s)", this.id, this.task, this.createDate, this.completed);
    }
}
