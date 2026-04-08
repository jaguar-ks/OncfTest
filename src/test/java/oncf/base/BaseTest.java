package oncf.base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import oncf.utils.DriverFactory;

public class BaseTest {
    final DriverFactory factory = DriverFactory.getInstance();
    
    @Before
    public void setUp(Scenario scenario) {
        System.out.println("\n========================================");
        System.out.println("🚀 Starting Test: " + scenario.getName());
        System.out.println("========================================");
    }

    @After
    public void cleanUp(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("❌ Test FAILED: " + scenario.getName());
            byte[] screenshot = ((TakesScreenshot) factory.getDriver())
                                .getScreenshotAs(OutputType.BYTES);
            scenario.attach(
                screenshot,
                "image/png",
                "Failed Screenshot"
            );
            System.out.println("📸 Screenshot captured");
        } else {
            System.out.println("✅ Test PASSED: " + scenario.getName());
        }
        System.out.println("========================================");
        System.out.println("🏁 Ending Test: " + scenario.getName());
        System.out.println("========================================\n");
    }
}
