/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.westminster.api;

import java.util.HashMap;
import java.util.Map;

public class ApiInfo {
    private String name = "Yeharak Kobbagala";
    private String version = "1.0.0";
    private String description = "Smart Campus Management System API";
    
    // Use a Map here to satisfy the "HATEOAS Links" requirement
    private Map<String, String> links = new HashMap<>();

    public ApiInfo() {}
    
    // Getters
    public String getVersion() { return version; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public Map<String, String> getLinks() { return links; }

    // Setters
    public void setVersion(String version) { this.version = version; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setLinks(Map<String, String> links) { this.links = links; }
}