package com.pineone.icbms.so.adp.model;

import com.pineone.icbms.so.core.model.Device;

import java.util.List;

/**
 * Created by existmaster on 2015. 9. 21..
 */
public class Information {
    String virtualObjectId;
    List<Device> devices;
    List<Property> properties;

    public String getVirtualObjectId() {
        return virtualObjectId;
    }

    public void setVirtualObjectId(String virtualObjectId) {
        this.virtualObjectId = virtualObjectId;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
