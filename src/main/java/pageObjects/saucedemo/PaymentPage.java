package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.Arrays;

import static driver.DriverCreation.getDriver;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class PaymentPage extends BasePage {

    private final By header = By.className("app_logo");
    private final By moveToShoppingCardButton = By.className("shopping_cart_link");
    private final By productList = By.className("cart_item");
    private final By quantityOfProduct = By.xpath("//div[@class='cart_quantity']");
    private final By priceOfProduct = By.className("inventory_item_price");
    private final By totalPrice = By.xpath("//div[@class='summary_info_label summary_total_label']");
    private final By cancelButton = By.id("cancel");
    private final By finishPaymentButton = By.id("finish");
    private final By amountOfTax = By.className("summary_tax_label");

    public void verifyPage() {
        wait.until(textToBe(header, "Swag Labs"));
        wait.until(visibilityOfElementLocated(productList));
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html", "Wrong header url.");
    }

    public void clickCancelButton() {
        click(cancelButton);
    }

    public void clickFinishPaymentButton() {
        click(finishPaymentButton);
    }

    public void clickMoveToShoppingCardButton() {
        click(moveToShoppingCardButton);
    }

    public String getQuantityOfProduct(Integer index) {
        return getDriver().findElements(productList).get(index).findElement(quantityOfProduct).getText();
    }

    public String getPriceOfProduct(Integer index) {
        return getDriver().findElements(productList).get(index).findElement(priceOfProduct).getText();
    }

    public String getTotalPriceShowedOnPage() {
        return getDriver().findElement(totalPrice).getText().substring(8);
    }

    public String getAmountOfTax() {
        return getDriver().findElement(amountOfTax).getText().substring(6);
    }


}
