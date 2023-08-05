package com.kalexs8.resinau.io_wrap;

import java.util.ArrayList;
import java.util.InputMismatchException;
import com.kalexs8.resinau.exceptions.EmptyInputFieldException;
import com.kalexs8.resinau.exceptions.InvalidInputException;
import com.kalexs8.resinau.io.RSFileReader;
import com.kalexs8.resinau.io.ReadInput;

public class RSReader {
    private final ReadInput input;
    public RSReader(){
        input = new ReadInput();
    }
    public boolean getChoice(String message){
        boolean result = false;
        while(true){
            try {
                RSWriter.stdout(message + " (y/n): ");
                result = input.getChoice();
                break;
            } catch (InvalidInputException e) {
                System.err.println("Input salah, harusnya Y atau N, dapat: " + e.getInput());
            }
        }
        return result;
    }
    public String getInput(String message){
        String result = "";
        while(true){
            try{
                RSWriter.stdout(message);
                result = input.getInput();
                break;
            }catch(EmptyInputFieldException _e){
                System.err.println("Masukkan tidak boleh kosong.");
            }
        }
        return result;
    }
    public int getInt(){
        try{
            int result = input.getInt();
            return result;
        }catch(InputMismatchException e){
            RSWriter.stderrln("Masukkan tidak valid.");
        }
        return 0;
    }
    // public Properties readProperties(String fileProperty) throws java.io.IOException{
    //     String getRootPath = RSSys.cwd();
    //     Properties prop = new Properties();
    //     prop.load(new java.io.FileInputStream(getRootPath + fileProperty));
    //     return prop;
    // }

    public static ArrayList<String> readFileAsList(String filename){
        ArrayList<String> lines = null;
        try{
            RSFileReader reader = new RSFileReader(filename);
            lines = new ArrayList<String>();
            String line;
            while((line = reader.readLine()) != null){
                if(line.trim().length() == 0)
                    continue;
                lines.add(line);
            }
            reader.close();
        }catch(Exception e){
            lines = null;
        }
        return lines;
    }
    public static ArrayList<String> readFileAsList(String filename, Exception exceptionOut){
        ArrayList<String> lines = null;
        try{
            lines = readFileAsList(filename);
        }catch(Exception e){
            exceptionOut = e;
            lines = null;
        }
        return lines;
    }
}
