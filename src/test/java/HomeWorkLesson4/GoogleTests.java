package HomeWorkLesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleTests {

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }

    @Test(priority = 2)
    public void googleSearchHelloWorldTest() {
        String currentURL = driver.getCurrentUrl();
        submitSomethingInSearchArea("Привет,мир");
        Assert.assertFalse(currentURL.equals(driver.getCurrentUrl()), "Поиск  не удался");
    }

    @Test(priority = 1)
    public void googleSearchNothingFoundTest() {
        submitSomethingInSearchArea("-DskipTests=true");
        WebElement noResultsMessage = driver.findElement(By.cssSelector("p[aria-level='3'][role='heading'][style*='padding-top:.33em']"));
        String actualMessage = noResultsMessage.getText().trim();
        String expectedMessage = "По запросу -DskipTests=true ничего не найдено.";
        Assert.assertTrue(actualMessage.equals(expectedMessage),"Неправильно работает поиск по сообщению -DskipTests=true");
        driver.navigate().back();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    public void submitSomethingInSearchArea(String value) {
        WebElement searchTextArea = driver.findElement(By.name("q"));
        searchTextArea.sendKeys(value);
        searchTextArea.submit();
    }


}
