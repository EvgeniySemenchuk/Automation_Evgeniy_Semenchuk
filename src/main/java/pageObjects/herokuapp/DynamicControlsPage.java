package pageObjects.herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class DynamicControlsPage extends BasePage {

    private final By header = By.tagName("h4");
    private final By checkBox = By.xpath("//input[@type='checkbox']");
    private final By removeButton = By.xpath("(//button)[1]");
    private final By enableButton = By.xpath("(//button)[2]");
    private final By messageAfterRemoving = By.xpath("//p[@id='message']");
    private final By input = By.tagName("input");


    public void verifyTitleText() {
        wait.until(textToBe(header,"Dynamic Controls"));
    }

    public void verifyRemovingCheckBox() {
        wait.until(not(visibilityOfElementLocated(checkBox)));
    }

    public void verifyTextAfterRemovingCheckBox() {
        wait.until(visibilityOfElementLocated(messageAfterRemoving));
    }

    public void verifyInput(Boolean status) {
        Assert.assertEquals(driver.findElement(input).isEnabled(), status);
    }

    public void verifyTurningOnInput(){
        wait.until(visibilityOfElementLocated(messageAfterRemoving));
    }

    public void clickCheckBox() {
        click(checkBox);
    }

    public void clickRemoveOrAddButton() {
        click(removeButton);
    }

    public void clickEnableButton() {
        click(enableButton);
    }







}
