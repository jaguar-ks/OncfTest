package oncf.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.cdimascio.dotenv.Dotenv;

public class DriverFactory implements AutoCloseable {
    static WebDriver driver;
    final static DriverFactory instance = new DriverFactory();
    final static Dotenv dotEnv = Dotenv.load();

    private DriverFactory() {
        String browser = dotEnv.get("browser");
        if (browser == null)
            throw new IllegalArgumentException("VALUE ERROR: Browser not specified");
        driver = switch (browser) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            default -> throw new IllegalArgumentException(
                "VALUE ERROR: Browser '" +
                browser +
                "' not supported"
            );
        };
    }

    @Override
    public void close() {
        if (driver != null)
            driver.quit();
    }

    public static DriverFactory getInstance() {return instance;}

    public static WebDriver getDriver() {return driver;}

    public static String getEnvVar(String key) {return dotEnv.get(key);}
}
