package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import propertyUtils.PropertyReader;

import java.time.Duration;
import java.util.HashMap;

import static java.io.File.separator;

public class DriverCreation {

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static void createDriver(DriverTypes type) {
        if(webDriver.get() == null) {
            switch (type) {
                case CHROME:
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments(PropertyReader.getProperties().getProperty("browser.option").split(";"));
                    webDriver.set(new ChromeDriver(options));
                    break;
                case FIREFOX:
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    webDriver.set(new FirefoxDriver(firefoxOptions));
                    break;
                case IDGE:
                    webDriver.set(new EdgeDriver());
                    break;
            }
            webDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        }
    }

    public static WebDriver getDriver() {
        return webDriver.get();
    }

    public static void quitDriver() {
        if (webDriver.get() != null) {
            webDriver.get().quit();
            webDriver.remove();
        }
    }




}
