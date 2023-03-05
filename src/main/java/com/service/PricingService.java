package com.service;

import com.models.InputFile;
import com.models.OutputFile;

public interface PricingService {
     OutputFile generateFile(InputFile input);

}
