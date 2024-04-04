package com.iniciandospring.projectspringboot.services.exceptions;

public class EntityNotFoundExceptions extends RuntimeException{

    public EntityNotFoundExceptions(String msg){
        super(msg);
    }
}
