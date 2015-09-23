package com.pineone.so.back.core.model;

import javax.persistence.*;

/**
 * Created by existmaster on 2015. 9. 10..
 */
@Entity
public class Task {
    @Id
    @Column(name = "TASK_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    public Task() {
    }

    public Task(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
