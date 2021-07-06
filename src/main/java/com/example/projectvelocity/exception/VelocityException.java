package com.example.projectvelocity.exception;

public class VelocityException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public VelocityException() {
        super();
    }
    public VelocityException(String mensaje) {
        super(mensaje);
    }
}
