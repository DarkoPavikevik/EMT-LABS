package com.example.labemt.model.exceptions;

public class NoBookIdFoundException extends RuntimeException{
    public NoBookIdFoundException() {
        super("No book with this id is found");
    }
}