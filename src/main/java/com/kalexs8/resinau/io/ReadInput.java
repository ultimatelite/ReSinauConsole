package com.kalexs8.resinau.io;
import com.kalexs8.resinau.exceptions.EmptyInputFieldException;
import com.kalexs8.resinau.exceptions.InvalidInputException;
import com.kalexs8.resinau.processors.RSStringUtils;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ReadInput{
    private final Scanner stdin;
    public ReadInput(){
        stdin = new Scanner(System.in);
    }
    public char getChar() throws EmptyInputFieldException{
        String getInput = stdin.next();
        if(RSStringUtils.isBlank(getInput))
            throw new EmptyInputFieldException();
        return getInput.charAt(0);
    }
    public char getChar(boolean lowercase) throws EmptyInputFieldException{
        String getInput = stdin.next();
        if(RSStringUtils.isBlank(getInput))
            throw new EmptyInputFieldException();
        if(lowercase)
            return getInput.toLowerCase().charAt(0);
        return getInput.charAt(0);
    }
    public String getInput() throws EmptyInputFieldException{
        String getInput = stdin.next();
        if(RSStringUtils.isBlank(getInput))
            throw new EmptyInputFieldException();
        return getInput;
    }
    public boolean getChoice() throws InvalidInputException{
        try{
            char firstChar = this.getChar(true);
            String toStr = new StringBuilder(firstChar).toString();
            if(firstChar != 'y' && firstChar != 'n')
                throw new InvalidInputException(toStr);
            return firstChar == 'y';
        }catch(EmptyInputFieldException e){
            throw new InvalidInputException("[Sys.in.NONE]");
        }
    }
    public int getInt() throws InputMismatchException{
        return stdin.nextInt();
    }
}