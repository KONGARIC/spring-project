package com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.exception;

public class VendorException extends RuntimeException{


    public VendorException(String message) {
        super(message);
    }

    public VendorException(String message, Throwable cause) {
        super(message, cause);
    }

    public VendorException(Throwable cause) {
        super(cause);
    }


}
