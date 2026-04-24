/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.westminster.api;

import java.io.IOException;
import java.util.logging.Logger;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider // This tells JAX-RS to use this filter automatically
public class LoggingFilter implements ContainerResponseFilter {

    private static final Logger LOG = Logger.getLogger(LoggingFilter.class.getName());

    @Override
    public void filter(ContainerRequestContext requestContext, 
                       ContainerResponseContext responseContext) throws IOException {
        
        String method = requestContext.getMethod();
        String path = requestContext.getUriInfo().getPath();
        int status = responseContext.getStatus();

        // This prints a professional log line in your NetBeans Output window
        LOG.info("--- API LOG --- Method: " + method + " | Path: /" + path + " | Status: " + status);
    }
}
