import com.models.InputFile;
import com.models.OutputFile;
import com.models.Tap;
import com.service.PricingService;
import com.serviceImp.PricingServiceImp;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PricingServiceTest {
    public static PricingService pricingService = new PricingServiceImp();
    List<Tap> tapList = new ArrayList<>();
    @Before
    public void setUp() {

        tapList.add(new Tap(10000L, 1L, "A"));
        tapList.add(new Tap(10020L, 1L, "B"));
        tapList.add(new Tap(10030L, 1L, "B"));
        tapList.add(new Tap(10050L, 1L, "D"));
    }
    @Test
    public void generateFile() {
        var outputFile = pricingService.generateFile(new InputFile(tapList));
        assertEquals(1, outputFile.getCustomerSummaries().size());

    }


}
