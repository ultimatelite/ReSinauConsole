package com.kalexs8.resinau.exceptions;

public class InvalidInputException extends Exception{
    private String input;
    public InvalidInputException(){
        super("Invalid input provided.");
    }
    public InvalidInputException(String input){
        super("Invalid input provided.");
        this.input = input;
    }
    public String getInput(){
        return this.input;
    }
}
