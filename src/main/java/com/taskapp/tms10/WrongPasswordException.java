package com.taskapp.tms10;

public class WrongPasswordException extends Exception {

    public WrongPasswordException(String message) {
        super(message);
    }

}