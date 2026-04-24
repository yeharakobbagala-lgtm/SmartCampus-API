/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.westminster.api;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/rooms")
public class RoomResource {

    // You now have TWO storekeepers to talk to
    private GenericDAO<Room> roomDAO = new GenericDAO<>(MockDatabase.ROOMS);
    private GenericDAO<Sensor> sensorDAO = new GenericDAO<>(MockDatabase.SENSORS);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Room> getAllRooms() {
        return roomDAO.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createRoom(Room newRoom) {
        roomDAO.add(newRoom);
        return Response.status(Response.Status.CREATED).entity(newRoom).build();
    }
     @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Room getRoomById(@PathParam("id") int id) {
        Room room = roomDAO.getById(id);
        if (room == null) {
            throw new DataNotFoundException("Room with ID " + id + " not found.");
        }
        return room;
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateRoom(@PathParam("id") int id, Room updatedRoom) {
        // 1. Find the existing room
        Room existingRoom = roomDAO.getById(id);
        
        if (existingRoom == null) {
            throw new DataNotFoundException("Room " + id + " not found.");
        }

        // 2. Update the details
        existingRoom.setname(updatedRoom.getname());
        existingRoom.setCapacity(updatedRoom.getCapacity());

        // 3. Return the updated room
        return Response.status(Response.Status.OK).entity(existingRoom).build();
    }
    @DELETE
    @Path("/{id}")
    public Response deleteRoom(@PathParam("id") int id) {
        Room room = roomDAO.getById(id);
        
        // 404 Check
        if (room == null) {
            return Response.status(Response.Status.NOT_FOUND)
                .entity("{\"errorMessage\": \"Room " + id + " not found.\"}")
                .build();
        }

        // 409 Conflict Check: Look through all sensors to see if any are in this room
        boolean hasSensors = sensorDAO.getAll().stream()
                .anyMatch(s -> s.getRoomId() == id);

        if (hasSensors) {
            return Response.status(Response.Status.CONFLICT)
                .entity("{\"errorMessage\": \"Conflict: Room has sensors assigned to it.\"}")
                .build();
        }

        roomDAO.delete(id);
        return Response.noContent().build(); // This returns 204 No Content
    }
}