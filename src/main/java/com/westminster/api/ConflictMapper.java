/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.westminster.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ConflictMapper implements ExceptionMapper<ResourceConflictException> {
    @Override
    public Response toResponse(ResourceConflictException ex) {
        // We use your existing ErrorMessage class
        ErrorMessage error = new ErrorMessage(ex.getMessage(), 409, "http://campus-docs.com/conflict");
        return Response.status(Response.Status.CONFLICT).entity(error).build();
    }
}