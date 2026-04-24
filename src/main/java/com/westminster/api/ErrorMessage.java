/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.westminster.api;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
    private String errorMessage;
    private int errorCode;
    private String documentation;

    public ErrorMessage() {}
    public ErrorMessage(String errorMessage, int errorCode, String documentation) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.documentation = documentation;
    }

    ErrorMessage(String message, int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public String getErrorMessage() { return errorMessage; }
    public void setErrorMessage(String errorMessage) { this.errorMessage = errorMessage; }
    public int getErrorCode() { return errorCode; }
    public void setErrorCode(int errorCode) { this.errorCode = errorCode; }
    public String getDocumentation() { return documentation; }
    public void setDocumentation(String documentation) { this.documentation = documentation; }
}