import com.models.ConsumerSummary;
import com.models.InputFile;
import com.models.OutputFile;
import com.models.Tap;
import com.service.FileService;
import com.serviceImp.FileServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FileServiceTest {
    public  static FileService fileService=new FileServiceImpl();
    List<ConsumerSummary> consumerSummaryList=new ArrayList<>();

    @Before
    public void setUp() {
        consumerSummaryList.add(new ConsumerSummary(1L,1000,new ArrayList<>()));
        consumerSummaryList.add(new ConsumerSummary(2L,1500,new ArrayList<>()));
        consumerSummaryList.add(new ConsumerSummary(3L,2000,new ArrayList<>()));
    }
    @Test
   public void readFile() {
        InputFile input = fileService.readFile("C:\\Users\\ksghaier\\Desktop\\stationProject\\src\\main\\resources\\CandidateInputExampleTest.txt");
        assertEquals(16, input.getTaps().size());

    }

    @Test
   public void writeFile() {

        OutputFile outputFile=new OutputFile();
        outputFile.setCustomerSummaries(consumerSummaryList);
        fileService.writeFile(outputFile,"C:\\Users\\ksghaier\\Desktop\\stationProject\\src\\main\\resources\\CandidateOutputExampleTest.txt");
        File file=new File("C:\\Users\\ksghaier\\Desktop\\stationProject\\src\\main\\resources\\CandidateOutputExampleTest.txt");
        assertTrue(file.exists());

    }

}
