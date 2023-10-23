package com.pmoro.employeelist.domain.model;

import jakarta.persistence.*;

@Entity(name = "tb_tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;


    private Boolean done = false;

    public Boolean getChecked() {
        return done;
    }

    public void setChecked(Boolean checked) {
        this.done = checked;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}