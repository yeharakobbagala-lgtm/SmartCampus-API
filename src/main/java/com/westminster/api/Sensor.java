/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.westminster.api;

import java.util.ArrayList;
import java.util.List;

public class Sensor implements BaseModel {
    private int id;
    private int roomId; // This is the "Bridge" to the Room
    private String sensorType; // e.g., "CO2", "Temperature"
    private double lastReading;
  
    // NEW: The list of readings for THIS specific sensor
    private List<Reading> readings = new ArrayList<>();
    
    public Sensor() {}

    public Sensor(int id, int roomId, String sensorType, double lastReading) {
        this.id = id;
        this.roomId = roomId;
        this.sensorType = sensorType;
        this.lastReading = lastReading;
    }

    @Override public int getId() { return id; }
    @Override public void setId(int id) { this.id = id; }

    public int getRoomId() { return roomId; }
    public void setRoomId(int roomId) { this.roomId = roomId; }
    
    public List<Reading> getReadings() { return readings; }
    public void setReadings(List<Reading> readings) { this.readings = readings; }

    public String getSensorType() { return sensorType; }
    public void setSensorType(String sensorType) { this.sensorType = sensorType; }

    public double getLastReading() { return lastReading; }
    public void setLastReading(double lastReading) { this.lastReading = lastReading; }
}
