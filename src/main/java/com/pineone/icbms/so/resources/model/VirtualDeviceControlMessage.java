package com.pineone.icbms.so.resources.model;

/**
 * Created by existmaster on 2015. 10. 14..
 */
public class VirtualDeviceControlMessage {
    String id;
    String ontologyref;
    String devicename;
    String devicemodel;
    String operator;
    String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOntologyref() {
        return ontologyref;
    }

    public void setOntologyref(String ontologyref) {
        this.ontologyref = ontologyref;
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }

    public String getDevicemodel() {
        return devicemodel;
    }

    public void setDevicemodel(String devicemodel) {
        this.devicemodel = devicemodel;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
