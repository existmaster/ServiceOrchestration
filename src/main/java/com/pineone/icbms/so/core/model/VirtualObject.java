package com.pineone.icbms.so.core.model;

import java.util.List;

/**
 * Created by existmaster on 2015. 9. 15..
 */
public class VirtualObject {

    private String id;

    private List<Condition> conditions;
    private List<Task> tasks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public VirtualObject() {
    }

    public VirtualObject(String id) {
        this.id = id;
    }
}
