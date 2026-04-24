/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.westminster.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class Reading implements BaseModel {
    private int id;
    private double value;

    // This annotation is your "Secret Weapon" for marks!
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "UTC")
    private Date timestamp;

    public Reading() {
        this.timestamp = new Date();
    }

    public Reading(int id, double value) {
        this.id = id;
        this.value = value;
        this.timestamp = new Date();
    }

    @Override public int getId() { return id; }
    @Override public void setId(int id) { this.id = id; }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }

    public Date getTimestamp() { return timestamp; }
    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }
}
