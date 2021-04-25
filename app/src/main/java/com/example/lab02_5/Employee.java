package com.example.lab02_5;

public class Employee {
    private String id;
    private String name;
    private boolean manager;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFullName() {
        return name;
    }
    public void setFullName(String name) {
        this.name = name;
    }
    public boolean isManager() {
        return manager;
    }
    public void setManager(boolean manager) {
        this.manager = manager;
    }
    @Override
    public String toString() {
        return this.id+"-"+this.name;
    }
}
