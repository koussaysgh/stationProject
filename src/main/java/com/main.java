package com;

import com.models.InputFile;
import com.models.OutputFile;
import com.service.FileService;
import com.service.PricingService;
import com.serviceImp.FileServiceImpl;
import com.serviceImp.PricingServiceImp;

public class main  {
    public  static FileService fileService=new FileServiceImpl();
    public  static PricingService pricingService=new PricingServiceImp();

    public static void main(String[] args) {
        InputFile input = fileService.readFile("C:\\Users\\ksghaier\\Desktop\\stationProject\\src\\main\\resources\\CandidateInputExample.txt");
        OutputFile outputFile=pricingService.generateFile(input);
        fileService.writeFile(outputFile,"C:\\Users\\ksghaier\\Desktop\\stationProject\\src\\main\\resources\\CandidateOutputExample.txt");
    }
}
