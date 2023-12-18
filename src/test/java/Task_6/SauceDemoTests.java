package Task_6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static driver.SimpleWebDriver.*;

public class SauceDemoTests {

    @BeforeTest
    public void setUp() {
        setUpWebDriver("https://www.saucedemo.com");
    }

    @Test (priority = 1)
    public void checkNamesTest() {
        loginToSauceDemo();
        String nameOfProduct = getWebDriver().findElement(By.linkText("Sauce Labs Backpack")).getText();
        getWebDriver().findElement(By.linkText("Sauce Labs Backpack")).click();
        getWebDriver().findElement(By.cssSelector("button[class = 'btn btn_primary btn_small btn_inventory']")).click();
        getWebDriver().findElement(By.xpath("//div[@class='shopping_cart_container']//a[@class='shopping_cart_link']")).click();
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//div[@class='inventory_item_name']")).getText(), nameOfProduct, "Названия товара не совпали!");
        logoutFromSauceDemo();
    }

    @Test (priority = 2)
    public void checkPricesTest() {
        loginToSauceDemo();
        String priceOfProduct = getWebDriver().findElement(By.xpath("//button[@name='remove-sauce-labs-backpack']//..//div[@class='inventory_item_price']")).getText();
        getWebDriver().findElement(By.xpath("//div[@class='shopping_cart_container']//a[@class='shopping_cart_link']")).click();
        Assert.assertEquals(getWebDriver().findElement(By.xpath("//div[@class='inventory_item_price']")).getText(), priceOfProduct, "Цены товара не совпали!");
    }

    @AfterTest
    public void tearDown() {
        quit();
    }

    public static void loginToSauceDemo() {
        getWebDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        getWebDriver().findElement(By.name("password")).sendKeys("secret_sauce");
        getWebDriver().findElement(By.xpath("//input[@class='input_error form_input']")).submit();
    }

    public static void logoutFromSauceDemo() {
        getWebDriver().findElement(By.tagName("button")).click();
        getWebDriver().findElement(By.partialLinkText("Logout")).click();
    }
}
