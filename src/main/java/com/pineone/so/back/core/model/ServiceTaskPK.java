package com.pineone.so.back.core.model;

import java.io.Serializable;

/**
 * Created by existmaster on 2015. 9. 10..
 */

//@Embeddable
public class ServiceTaskPK implements Serializable{

    //@Column(name = "SERVICE_ID")
    private String service;

    //@Column(name = "TASK_ID")
    private String task;

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public ServiceTaskPK() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceTaskPK that = (ServiceTaskPK) o;

        if (service != null ? !service.equals(that.service) : that.service != null) return false;
        return !(task != null ? !task.equals(that.task) : that.task != null);

    }

    @Override
    public int hashCode() {
        int result = service != null ? service.hashCode() : 0;
        result = 31 * result + (task != null ? task.hashCode() : 0);
        return result;
    }
}
