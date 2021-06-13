package com.example.demo.models;

import java.time.ZonedDateTime;

/**
 * Class representing Customer entities as per the examples in customers.json
 */
public class Customer {
    private Long id;
    private String name;
    private ZonedDateTime duetime;
    private ZonedDateTime jointime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getDuetime() {
        return duetime;
    }

    public void setDuetime(ZonedDateTime duetime) {
        this.duetime = duetime;
    }

    public ZonedDateTime getJointime() {
        return jointime;
    }

    public void setJointime(ZonedDateTime jointime) {
        this.jointime = jointime;
    }
}
