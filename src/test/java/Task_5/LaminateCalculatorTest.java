package Task_5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static driver.SimpleWebDriver.*;


public class LaminateCalculatorTest {

    @BeforeTest
    public void setUp() {
        setUpWebDriver("https://masterskayapola.ru/kalkulyator/laminata.html");
    }

    @Test (priority =  1)
    public void smokeTest1() {
        submitNumbersInAreas("14,500" , "2,700","1355","190","11","500","400", "10");
        Select option = new Select(getWebDriver().findElement(By.name("calc_direct")));
        option.selectByValue("tow"); //toh
        WebElement squareResult = getWebDriver().findElement(By.id("s_lam"));
        getWebDriver().findElement(By.cssSelector("[class='btn btn-secondary btn-lg tocalc']")).click();

        Assert.assertTrue(squareResult.isDisplayed(), "Параметры не рассчитались");

    }

    @Test(priority =  2)
    public void smokeTest2() {
        submitNumbersInAreas("12,300" , "1,700","1455","290","12","350","380", "12");
        Select option = new Select(getWebDriver().findElement(By.name("calc_direct")));
        option.selectByValue("toh"); //toh
        WebElement squareResult = getWebDriver().findElement(By.id("s_lam"));
        getWebDriver().findElement(By.cssSelector("[class='btn btn-secondary btn-lg tocalc']")).click();

        Assert.assertTrue(squareResult.isDisplayed(), "Параметры не рассчитались");
    }

    @Test(priority =  3)
    public void negativeTest1() {
        submitNumbersInAreas("-12" , "-1,7","-1355","-290","-12","-350","-380", "-12");
        Select option = new Select(getWebDriver().findElement(By.name("calc_direct")));
        option.selectByValue("toh"); //toh
        WebElement squareResult = getWebDriver().findElement(By.id("s_lam"));
        getWebDriver().findElement(By.cssSelector("[class='btn btn-secondary btn-lg tocalc']")).click();

        Assert.assertTrue(squareResult.isDisplayed(), "Негативные числа не заменились - параметры не рассчитались");
    }

    @AfterTest
    public void tearDown() {
        quit();
    }

    public static void submitNumbersInAreas(String ... values) {
        getWebDriver().findElement(By.name("calc_roomwidth")).sendKeys(values[0]);
        getWebDriver().findElement(By.name("calc_roomheight")).sendKeys(values[1]);
        getWebDriver().findElement(By.name("calc_lamwidth")).sendKeys(values[2]);
        getWebDriver().findElement(By.name("calc_lamheight")).sendKeys(values[3]);
        getWebDriver().findElement(By.name("calc_inpack")).sendKeys(values[4]);
        getWebDriver().findElement(By.name("calc_price")).sendKeys(values[5]);
        getWebDriver().findElement(By.name("calc_bias")).sendKeys(values[6]);
        getWebDriver().findElement(By.name("calc_walldist")).sendKeys(values[7]);
    }
}
