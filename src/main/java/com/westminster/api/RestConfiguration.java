/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.westminster.api;

//It ensures your API address starts with /api/v1/. This is an industry standard for "versioning" an API so you can update it later without breaking old versions.
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("api/v1") // This creates your versioned entry point
public class RestConfiguration extends Application {
    // Its presence tells JAX-RS to activate the API at this path.
}
