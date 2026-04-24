/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.westminster.api;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

// MAPPER FOR 500 (The Global Safety Net)
@Provider
public class GlobalMapper implements ExceptionMapper<Throwable> {
    @Override
    public Response toResponse(Throwable ex) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ErrorMessage("A critical server error occurred.", 500)).build();
    }
}