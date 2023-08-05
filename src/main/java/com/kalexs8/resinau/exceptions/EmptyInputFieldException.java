package com.kalexs8.resinau.exceptions;

public class EmptyInputFieldException extends Exception{
    public EmptyInputFieldException(){
        super("Stdin Input field is empty.");
    }
}
