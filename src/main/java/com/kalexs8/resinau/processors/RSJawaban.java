package com.kalexs8.resinau.processors;

import com.kalexs8.resinau.RSConstants;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class RSJawaban{
    private final Pattern jawabanPattern = Pattern.compile(RSConstants.JAWABAN);
    private ArrayList<String> lines;
    public RSJawaban(){}
    
    public ArrayList<String> listJawaban(){
        ArrayList<String> soalSoal = new ArrayList<String>();
        for(String jawaban : this.lines){
            if(RSStringUtils.isBlank(jawaban))
                continue;

            jawaban = RSStringUtils.removeComment(jawaban);
            if(jawabanPattern.matcher(jawaban).find())
                soalSoal.add(jawaban.toString());
        }
        return soalSoal;
    }
    
    public ArrayList<Character> listJawabanBenar(){
        ArrayList<Character> jawaban = new ArrayList<Character>();
        boolean isKunciSwitch = false;
        for(String line: this.lines){
            if(RSStringUtils.isBlank(line))
                continue;

            line = RSStringUtils.removeComment(line);
            
            if(isKunciSwitch){
                jawaban.add(line.charAt(0));
                continue;
            }

            if(line.equalsIgnoreCase("--kunci")){
                jawaban.clear();
                isKunciSwitch = true;
            }
            
            String tolower = line.toLowerCase();
            if(tolower.replace(" ", "").startsWith("jawabanbenar:")){
                jawaban.add(tolower.charAt(15));
            }
        }
        return jawaban;
    }

    public void setLines(ArrayList<String> newFileLines){
        this.lines = newFileLines;
    }
}
