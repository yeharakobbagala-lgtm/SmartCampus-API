/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.westminster.api;

public class Room implements BaseModel {
    private int id; 
    private String name;
    private int capacity;
    private boolean hasSensors; 

    public Room() {}

    public Room(int id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.hasSensors = false;
    }

    @Override
    public int getId() { return id; }

    @Override
    public void setId(int id) { this.id = id; }

    public String getname() { return name; }
    public void setname(String name) { this.name = name; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public boolean isHasSensors() { return hasSensors; }
    public void setHasSensors(boolean hasSensors) { this.hasSensors = hasSensors; }
}