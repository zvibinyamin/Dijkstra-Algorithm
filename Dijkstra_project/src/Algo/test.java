/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algo;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zvika
 */
public class test {

    static String file_in1 = "c:/in1.txt";
    static String file_in2 = "c:/in2.txt";

    static FileWriter File_Writer;
    static BufferedWriter Buffered_Writer;

    public static void openWriterFile(String filename) {
        File f = new File(filename);
        try {
            if (!f.exists()) {
                f.createNewFile();
            }

            File_Writer = new FileWriter(f);
            Buffered_Writer = new BufferedWriter(File_Writer);
        } catch (IOException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void CloseFile() {
        try {
            Buffered_Writer.close();
            File_Writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void addline(String line) {
        try {
            Buffered_Writer.write(line);
            Buffered_Writer.newLine();
        } catch (IOException ex) {
            Logger.getLogger(Graph.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        openWriterFile(file_in1);
        int N=40;
        addline(String.valueOf(N*N));
        addline("200");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(use()) addline(i + " " + j +" 1");
            }
        }

        CloseFile();
    }
    public static boolean use(){
        return Math.random()>0.6;
    }
}
