/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.westminster.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/sensors")
public class SensorResource {

    private final GenericDAO<Sensor> sensorDAO = new GenericDAO<>(MockDatabase.SENSORS);
    private final GenericDAO<Room> roomDAO = new GenericDAO<>(MockDatabase.ROOMS);

    // 1. GET ALL SENSORS (With Filter Logic for ?type=CO2)
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Sensor> getAllSensors(@QueryParam("type") String type) {
        List<Sensor> allSensors = sensorDAO.getAll();
        
        if (allSensors == null) return new ArrayList<>();

        if (type != null && !type.isEmpty()) {
            return allSensors.stream()
                .filter(s -> s.getSensorType() != null && s.getSensorType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
        }
        return allSensors;
    }

    // 2. GET SINGLE SENSOR BY ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSensor(@PathParam("id") int id) {
        Sensor s = sensorDAO.getById(id);
        if (s == null) {
            return Response.status(Response.Status.NOT_FOUND)
                .entity("{\"errorMessage\": \"Sensor " + id + " not found.\"}")
                .build();
        }
        return Response.ok(s).build();
    }

    // 3. CREATE SENSOR (With 422 Integrity Check)
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSensor(Sensor sensor) {
        Room room = roomDAO.getById(sensor.getRoomId());
        
        if (room == null) {
            return Response.status(422) 
                .entity("{\"errorMessage\": \"Integrity Error: Room " + sensor.getRoomId() + " does not exist.\"}")
                .build();
        }

        sensorDAO.add(sensor);
        return Response.status(Response.Status.CREATED).entity(sensor).build();
    }

    // 4. ADD READING (Part 4 Sub-resource)
    @POST
    @Path("/{id}/readings")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addReading(@PathParam("id") int sensorId, Reading newReading) {
        Sensor parentSensor = sensorDAO.getById(sensorId);

        if (parentSensor == null) {
            return Response.status(Response.Status.NOT_FOUND)
                .entity("{\"errorMessage\": \"Sensor " + sensorId + " not found.\"}")
                .build();
        }

        // Business Logic: Update the sensor's last value
        newReading.setId(parentSensor.getReadings().size() + 1);
        parentSensor.setLastReading(newReading.getValue());
        parentSensor.getReadings().add(newReading);

        return Response.status(Response.Status.CREATED).entity(newReading).build();
    }
}