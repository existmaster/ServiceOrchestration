package com.pineone.icbms.so.adp.model;

import com.pineone.icbms.so.core.model.Command;
import com.pineone.icbms.so.core.model.VirtualObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by existmaster on 2015. 9. 16..
 */
public class Occurrence extends Command {

    private String id;
    private String contextId;
    private String time;

    private List<VirtualObject> domains;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContextId() {
        return contextId;
    }

    public void setContextId(String contextId) {
        this.contextId = contextId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<VirtualObject> getDomains() {
        return domains;
    }

    public void setDomains(List<VirtualObject> domains) {
        this.domains = domains;
    }

    public void addDomain(VirtualObject domain){
        if(this.domains==null){
            this.domains = new ArrayList<>();
        }
        this.domains.add(domain);
    }
}
