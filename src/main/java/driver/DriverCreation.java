package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverCreation {

    private static WebDriver webDriver;

    public static void createDriver(DriverTypes type) {
        if(webDriver == null) {
            switch (type) {
                case CHROME:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("start-maximized");
                    webDriver = new ChromeDriver();
                    break;
                case FIREFOX:
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    webDriver = new FirefoxDriver();
                    break;
                case IDGE:
                    EdgeOptions edgeOptions = new EdgeOptions();
                    webDriver = new EdgeDriver();
                    break;
            }
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
    }

    public static WebDriver getDriver() {
        return webDriver;
    }

    public static void quitDriver() {
        webDriver.quit();
    }




}
