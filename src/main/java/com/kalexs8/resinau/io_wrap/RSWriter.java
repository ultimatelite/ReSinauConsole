package com.kalexs8.resinau.io_wrap;
public class RSWriter {
    public static void stdout(String message){
        System.out.print(message);
    }
    public static void stdoutln(String message){
        System.out.println(message);
    }
    public static void stderr(String message){
        System.err.print(message);
    }
    public static void stderrln(String message){
        System.err.println(message);
    }
    public static void print(String format, Object... args){
        System.out.printf(format, args);
    }
}
