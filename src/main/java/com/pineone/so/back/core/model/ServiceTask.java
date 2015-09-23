package com.pineone.so.back.core.model;

import javax.persistence.*;

/**
 * Created by existmaster on 2015. 9. 10..
 */
@Entity
@IdClass(ServiceTaskPK.class)
public class ServiceTask {

    @Id
    @ManyToOne
    @JoinColumn(name = "SERVICE_ID")
    private Service service;

    @Id
    @ManyToOne
    @JoinColumn(name = "TASK_ID")
    private Task task;

    private int order;

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
