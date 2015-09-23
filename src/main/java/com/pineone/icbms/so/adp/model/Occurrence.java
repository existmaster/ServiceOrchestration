package com.pineone.icbms.so.adp.model;

import com.pineone.icbms.so.core.model.Command;

import java.util.List;

/**
 * Created by existmaster on 2015. 9. 16..
 */
public class Occurrence extends Command {

    private String id;
    private List<Information> informations;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Information> getInformations() {
        return informations;
    }

    public void setInformations(List<Information> informations) {
        this.informations = informations;
    }

}
