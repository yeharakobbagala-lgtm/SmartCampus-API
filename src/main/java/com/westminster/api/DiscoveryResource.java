/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.westminster.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class DiscoveryResource {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ApiInfo getApiDetails() {
        ApiInfo info = new ApiInfo();
        
        info.setVersion("1.0.0");
        info.setDescription("Smart Campus Management System API");
        info.setName("Yeharak Kobbagala");
        
        // This is the correct way to add links to the Map
        info.getLinks().put("rooms", "/api/v1/rooms");
        info.getLinks().put("sensors", "/api/v1/sensors");
        
        return info;
    }
}