package com.pineone.so.back.core.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by existmaster on 2015. 9. 10..
 */
@Entity
public class Service {

    @Id
    @Column(name = "SERVICE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToMany
    @JoinTable(name = "SERVICE_SERVICE_CONDITION",
            joinColumns = @JoinColumn(name = "SERVICE_ID"),
            inverseJoinColumns = @JoinColumn(name = "SERVICE_CONDITION_ID"))
    private List<ServiceCondition> serviceConditions = new ArrayList<ServiceCondition>();

    @OneToMany(mappedBy = "service")
    private List<ServiceTask> serviceTasks;

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

    public List<ServiceCondition> getServiceConditions() {
        return serviceConditions;
    }

    public void setServiceConditions(List<ServiceCondition> serviceConditions) {
        this.serviceConditions = serviceConditions;
    }
    public void addServiceCondition(ServiceCondition serviceCondition){
        this.serviceConditions.add(serviceCondition);
    }

    public void addServiceTask(ServiceTask serviceTask){
        this.serviceTasks.add(serviceTask);
    }

    public Service() {
    }

    public Service(String name) {
        this.name = name;
    }
}
