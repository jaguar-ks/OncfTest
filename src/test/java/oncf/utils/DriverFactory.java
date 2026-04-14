package oncf.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.cdimascio.dotenv.Dotenv;

public class DriverFactory {
    static WebDriver driver;
    final static Dotenv dotEnv = Dotenv.load();
    final static DriverFactory instance = new DriverFactory();

    private DriverFactory() {
        String browser = dotEnv.get("browser");
        if (browser == null)
            throw new IllegalArgumentException("VALUE ERROR: Browser not specified");
        DriverFactory.driver = switch (browser) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            default -> throw new IllegalArgumentException(
                "VALUE ERROR: Browser '" +
                browser +
                "' not supported"
            );
        };
    }

    public static DriverFactory getInstance() {
        if (DriverFactory.instance == null) {
            String browser = dotEnv.get("browser");
            if (browser == null)
                throw new IllegalArgumentException("VALUE ERROR: Browser not specified");
            DriverFactory.driver = switch (browser) {
                case "chrome" -> new ChromeDriver();
                case "firefox" -> new FirefoxDriver();
                default -> throw new IllegalArgumentException(
                    "VALUE ERROR: Browser '" +
                    browser +
                    "' not supported"
                );
            };
        }
        return DriverFactory.instance;
    }

    public static WebDriver getDriver() {return driver;}

    public static String getEnvVar(String key) {return dotEnv.get(key);}
}
