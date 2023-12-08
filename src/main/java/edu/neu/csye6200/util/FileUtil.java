package edu.neu.csye6200.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileUtil {

    public static List<String> readCsv(String fileName, boolean removeHeader){
        List<String> fileData = new ArrayList<>();
        try(BufferedReader inLine = new BufferedReader(new FileReader(fileName))){
            String line = null;
            while((line = inLine.readLine()) != null){
                fileData.add(line);
            }
        } catch (IOException e){ 
            e.printStackTrace();
        }
        if (removeHeader) fileData.remove(0);
        return fileData;
    }

    public static List<String> readCsv(String fileName){
        return readCsv(fileName, true);
    }

    public static void writeCsv(String fileName, List<String> lines){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            writer.flush();
        }catch (IOException e){ 
            e.printStackTrace();
        }
    }
}

