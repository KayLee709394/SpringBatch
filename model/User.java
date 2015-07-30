package com.springbatch.model;

import org.springframework.stereotype.Component;

/**
 * Created by ksy on 2015/7/24.
 */
@Component
public class User {
    private String id;
    private String name;
    private String mark;

    public User() {
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {

        return id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setId(String id) {
        this.id = id;
    }
}
