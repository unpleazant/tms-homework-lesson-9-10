package com.taskapp.tms10;

public class WrongLoginException extends Exception {

    public WrongLoginException() {
        super("Incorrect login or password");
    }

}
