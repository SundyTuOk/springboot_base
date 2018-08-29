package com.tt.provider.entity;

import javax.persistence.*;

@Table(name = "plugin")
public class Plugin {
    @Id
    private String name;

    private String dl;

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return dl
     */
    public String getDl() {
        return dl;
    }

    /**
     * @param dl
     */
    public void setDl(String dl) {
        this.dl = dl;
    }
}