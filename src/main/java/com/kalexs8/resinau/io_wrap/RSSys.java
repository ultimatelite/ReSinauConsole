package com.kalexs8.resinau.io_wrap;
import java.io.File;

public class RSSys {
    public static void exit(int code){
        System.exit(code);
    }
    public static void stackAndErrExit(String message, Exception e){
        RSWriter.stderrln(message);
        e.printStackTrace();
        exit(1);
    }
    public static void errExit(String message){
        RSWriter.stderrln(message);
        exit(1);
    }
    public static String cwd(){
        File getCurrentFile = new File(".");
        String getCurrentString = getCurrentFile.toString();
        String current = getCurrentString.substring(0, getCurrentString.length() - 1);
        return current;
    }
}
