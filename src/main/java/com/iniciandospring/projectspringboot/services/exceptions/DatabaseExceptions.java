package com.iniciandospring.projectspringboot.services.exceptions;

public class DatabaseExceptions extends RuntimeException{

    public DatabaseExceptions(String message){
        super(message);
    }
}
