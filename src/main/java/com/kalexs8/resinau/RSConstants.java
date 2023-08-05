package com.kalexs8.resinau;

public final class RSConstants {
    // Used in com.kalexs8.resinau.processors classes.
    // public static final String SOAL = "^\\d+\\..*(\\.{3}( +)?|=( +)?|\\?( +)?|\\!( +)?)$";
    // public static final String QUESTION_ROUTER = "http://example.com/path/to/router.resinau";
    public static final String JAWABAN = "^[a-d|A-D]+\\.";
    public static final String PROCESSOR_COMMENT = "//";
    
    // Used in main program.
    public static final String DISPLAY = "console";
    public static final String VERSION = "Awal 1.0";
    public static final String BUILD_NUMBER = "20230805.1-0";
    public static final int MAX_OPT_ARG = 3;
    public static final int CHOICES_PER_QUESTION = 4;
    public static final int QUESTIONS_PER_SESSION = 3;

}
