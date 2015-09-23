package com.pineone.icbms.so.adp.model;

/**
 * Created by existmaster on 2015. 9. 22..
 */
public class Property {

    private String id;
    private String name;
    private String value;
    private PropertyType propertyType;

    public PropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(PropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
