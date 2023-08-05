package com.kalexs8.resinau.processors;

import com.kalexs8.resinau.RSConstants;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class RSSoal {
    private final Pattern jawabanPattern = Pattern.compile(RSConstants.JAWABAN);
    private ArrayList<String> lines;
    public RSSoal(){}
    
    public ArrayList<String> listSoal(){
        ArrayList<String> soalSoal = new ArrayList<String>();
        StringBuilder soalBuilder = new StringBuilder();
        for(String soal : this.lines){
            if(RSStringUtils.isBlank(soal))
                continue;
            soal = RSStringUtils.removeComment(soal);
            
            if(soal.toLowerCase().replace(" ", "").startsWith("jawabanbenar:"))
                continue;
                
            if(jawabanPattern.matcher(soal).find()){
                if(soalBuilder.length() == 0)
                    continue;
                soalSoal.add(soalBuilder.toString());
                soalBuilder.setLength(0);
            } else{
               if(soalBuilder.length() != 0)soalBuilder.append("\n");
               soalBuilder.append(soal);
            }
        }
        return soalSoal;
    }
    
    public void setLines(ArrayList<String> newFileLines){
        this.lines = newFileLines;
    }
}
