package com.kalexs8.resinau.io;

import java.io.BufferedReader;
import java.io.FileReader;
public class  RSFileReader extends BufferedReader{
    public RSFileReader(String filename) throws java.io.IOException{
        super(new FileReader(filename));
    }
    public RSFileReader(java.io.Reader reader) throws java.io.IOException{
        super(reader);
    }
}