package com.serviceImp;

import com.google.gson.Gson;
import com.models.InputFile;
import com.models.OutputFile;
import com.service.FileService;

import java.io.FileReader;
import java.io.FileWriter;

public class FileServiceImpl implements FileService {
    @Override
    public InputFile readFile(String fileName) {
        InputFile myInputFile = null;
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader(fileName);
            myInputFile = gson.fromJson(reader, InputFile.class);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return myInputFile;
    }

    @Override
    public void writeFile(OutputFile output,String fileName) {
        try {
            Gson gson = new Gson();
            FileWriter writer = new FileWriter(fileName);

            gson.toJson(output, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
   return;
    }
}
