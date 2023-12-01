package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SimpleWebDriver {

    private static WebDriver webDriver;


    {
        if (webDriver == null) {
            webDriver = new ChromeDriver(chromeOptions());
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
    }

    public static void setUpWebDriver(String url) {
        if (webDriver == null) {
            webDriver = new ChromeDriver(chromeOptions());
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            webDriver.get(url);
        }
    }


    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void quit() {
        webDriver.quit();
    }

    public static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return options;
    }

}
