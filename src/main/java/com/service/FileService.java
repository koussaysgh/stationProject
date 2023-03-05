package com.service;

import com.models.InputFile;
import com.models.OutputFile;


public interface FileService {
     InputFile readFile(String fileName);
      void writeFile(OutputFile output,String fileName);

}
