package com.kalexs8.resinau;
import com.kalexs8.resinau.io_wrap.*;
import com.kalexs8.resinau.processors.RSSoal;
import com.kalexs8.resinau.processors.RSJawaban;
import java.io.File;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        final RSReader reader = new RSReader();
        RSSoal soalProcessor = new RSSoal();
        RSJawaban jawabanProcessor = new RSJawaban();
        boolean lanjut = true;
        RSWriter.print(
            "Selamat datang di ReSinau!\n\nVersi: %s,\nTampilan: %s,\nBuild: %s\n\n",
            RSConstants.VERSION, RSConstants.DISPLAY,
            RSConstants.BUILD_NUMBER
        );
        while(lanjut){
            RSWriter.stdout("Pilihan:\n1. Download data dari router (OUT)\n2. Kerjakan data soal\n3. Editor Teks Soal (OUT)\n4. Keluar\n$> ");
            int opt = reader.getInt();
            switch(opt){
                case 2:
                    String filename = reader.getInput("Masukkan nama file: ");
                    if(!new File(filename).isAbsolute())
                        filename = RSSys.cwd() + filename;
                    ArrayList<String> getFileLines = RSReader.readFileAsList(filename);

                    soalProcessor.setLines(getFileLines);
                    jawabanProcessor.setLines(getFileLines);

                    ArrayList<String> getSoalLines = soalProcessor.listSoal();
                    ArrayList<String> getJawabanLines = jawabanProcessor.listJawaban();
                    ArrayList<Character> getCorrectAnswers = jawabanProcessor.listJawabanBenar();
                    
                    int questionsCount = getSoalLines.size();
                    int choicesCount = getJawabanLines.size();
                    RSWriter.print(
                        "Dapat %d soal dan %d pilihan, membandingkan dengan soal pangkat dari %d dan pilihan pangkat dari %d...\n\n",
                        questionsCount, choicesCount,
                        RSConstants.QUESTIONS_PER_SESSION, RSConstants.CHOICES_PER_QUESTION
                    );
                    int questionSessionCount = questionsCount / RSConstants.QUESTIONS_PER_SESSION;

                    RSWriter.print(
                        "Jumlah Sesi\n\nSoal: %d\nPilihan: %d\nSoal yang tidak dimasukkan:\n%d Soal\n\n",
                        questionSessionCount, choicesCount,
                        questionsCount % RSConstants.QUESTIONS_PER_SESSION
                    );

                    if(getCorrectAnswers.size() / RSConstants.QUESTIONS_PER_SESSION != questionSessionCount){
                        RSWriter.stderrln("Soal kekurangan jawaban benar...");
                        break;
                    }

                    RSWriter.stdoutln("Menyiapkan soal... (masukkan :read-EXIT untuk keluar)");
                    RSWriter.stdoutln(
                        "Cara mengerjakan soal: JAWABAN-1,JAWABAN2,JAWABAN-3 dan seterusnya, misal: a,d,c. Koma itu harus!!!!\n"
                    );
                    int soalPtr = 0, jawabanPtr = 0, answersPtr = 0, counter = 0;
                    String getInput;
                    boolean hasExited = false;
                    while(counter != questionSessionCount){
                        for(; soalPtr < (RSConstants.QUESTIONS_PER_SESSION * (counter+1)); soalPtr++){
                            RSWriter.stdoutln(getSoalLines.get(soalPtr));
                            for(; jawabanPtr < (RSConstants.CHOICES_PER_QUESTION * (soalPtr+1)); jawabanPtr++)
                                RSWriter.stdoutln(getJawabanLines.get(jawabanPtr));
                        }
                        RSWriter.stdout("\n\n");

                        getInput = reader.getInput("Masukkan: ");
                        if(getInput.equals(":read-EXIT")){
                            hasExited = true;
                            break;
                        }
                        String[] getAnswers = getInput.toLowerCase().split(",");
                        if(getAnswers.length < 3){
                            RSWriter.stdoutln("Jawaban yang dimasukkan kurang...");
                            jawabanPtr -= (RSConstants.CHOICES_PER_QUESTION * soalPtr);
                            soalPtr -= RSConstants.QUESTIONS_PER_SESSION;
                            continue;
                        }
                        
                        if(
                            getAnswers[0].charAt(0) == getCorrectAnswers.get(answersPtr++)
                            && getAnswers[1].charAt(0) == getCorrectAnswers.get(answersPtr++)
                            && getAnswers[2].charAt(0) == getCorrectAnswers.get(answersPtr++)
                        ){
                            RSWriter.stdoutln("Mantap!");
                            counter++;
                            continue;
                        }
                        RSWriter.stdoutln("Jawaban salah... Coba lagi");
                        answersPtr -= RSConstants.QUESTIONS_PER_SESSION;
                        jawabanPtr -= ((jawabanPtr - RSConstants.CHOICES_PER_QUESTION * soalPtr) < 0 ? jawabanPtr : RSConstants.CHOICES_PER_QUESTION * soalPtr);
                        soalPtr -= RSConstants.QUESTIONS_PER_SESSION;
                    }
                    if(!hasExited)
                        RSWriter.stdoutln("Selamat! Anda telah mengerjakan semua data soal file " + filename);
                    break;
                case 3:
                break;
                case 4:
                    RSSys.exit(0);
                default:
                    RSWriter.stderrln("Tidak di support.");
                break;
            }
            lanjut = reader.getChoice("Lanjut?");
        }
    }
}