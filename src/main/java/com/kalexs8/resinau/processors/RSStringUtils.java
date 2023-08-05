package com.kalexs8.resinau.processors;
import com.kalexs8.resinau.RSConstants;

public class RSStringUtils {
    public static boolean isBlank(String seq){
        return seq == null || seq.trim().isEmpty();
    }
    
    public static String removeComment(String line){
        if(line.contains(RSConstants.PROCESSOR_COMMENT))
            return line.split(RSConstants.PROCESSOR_COMMENT)[0];
        return line;
    }
}
