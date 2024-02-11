package pageObjects.mypage;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pageObjects.baseObjects.BasePage;
import pageObjects.saucedemo.LoginPage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static driver.DriverCreation.getDriver;
import static propertyUtils.PropertyReader.getProperties;

public class HomePage extends BasePage {

    private final By table = By.tagName("table");
    private final By inputField = By.id("fbook");
    private final By button = By.id("button_good");
    private final By bookImage = By.id("image_books");
    private final By text = By.tagName("p");
    private final By link = By.id("top100_books");
    private final By select = By.name("books_select");
    private final By firstColumn = By.className("first_column");

    private WebElement getCheckBox(Integer index) {
        return driver.findElement(By.name("book" + index));
    }

//    public HomePage open() {
//        getDriver().get(getProperties().getProperty("url"));
//        return this;
//    }

    public HomePage open() {
        getDriver().get("file://" + System.getProperty("user.dir") + "/" + "src/test/resources/files/mypage.html");
        return this;
    }

    public void quit() {
        driver.quit();
    }

    private List<WebElement> getFirstColumn() {
       return driver.findElements(firstColumn);
    }

    public List<String> getFirstColumnData() {
        return getFirstColumn().stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public HomePage enterField(String value) {
        waitUntilElementBeVisible(inputField);
        sendKeys(inputField,value);
        return this;
    }

    public String getInputFieldText() {
        return driver.findElement(inputField).getText();
    }

    public HomePage clickCheckBox1() {
        waitUntilElementToBeClickable(getCheckBox(1));
        click(getCheckBox(1));
        return this;
    }

    public HomePage clickCheckBox2() {
        waitUntilElementToBeClickable(getCheckBox(2));
        click(getCheckBox(2));
        return this;
    }

    public HomePage clickCheckBox3() {
        waitUntilElementToBeClickable(getCheckBox(3));
        click(getCheckBox(3));
        return this;
    }

    public HomePage clickButton() {
        waitUntilElementToBeClickable(button);
        click(button);
        return this;
    }

    public String getTextInParagraph() {
        return driver.findElement(text).getText();
    }

    public HomePage clickLink() {
        waitUntilElementBeVisible(link);
        click(link);
        return this;
    }

    public Boolean visibilityOfImage() {
        return driver.findElement(bookImage).isDisplayed();
    }

    public HomePage selectCity(String value) {
        Select select = new Select(driver.findElement(this.select));
        select.selectByValue(value);
        return this;
    }

}
