package pageObjects.herokuapp;

import org.openqa.selenium.By;
import pageObjects.baseObjects.BasePage;

import static driver.DriverCreation.getDriver;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static propertyUtils.PropertyReader.getProperties;

public class HomePage extends BasePage {

    private By getItemLocator(String item) {
        return By.linkText(item);
    }

    public void open(String url) {
        navigateTo(url);
    }

    public void open() {
        getDriver().get(getProperties().getProperty("url"));
    }

    public void clickOnItem(HomePageItems item) {
        wait.until(elementToBeClickable(getItemLocator(item.getItem())));
        click(getItemLocator(item.getItem()));
    }


}
