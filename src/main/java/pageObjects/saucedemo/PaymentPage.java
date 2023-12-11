package pageObjects.saucedemo;

import org.openqa.selenium.By;
import org.testng.Assert;
import pageObjects.baseObjects.BasePage;

import java.util.Arrays;

import static driver.DriverCreation.getDriver;
import static java.lang.Integer.parseInt;

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
        Assert.assertEquals(getDriver().findElement(header).getText(), "Swag Labs", "Wrong header name.");
        Assert.assertFalse(getDriver().findElements(productList).isEmpty(), "Product list is empty.");
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
        return Arrays.stream(getDriver().findElement(totalPrice).getText().split("$"))
                .filter(value -> !value.contains("Total: "))
                .findFirst().orElse("");
    }

    public String getAmountOfTax() {
        return Arrays.stream(getDriver().findElement(amountOfTax).getText().split("$"))
                .filter(value -> !value.contains("Tax: "))
                .findFirst().orElse("");
    }

    public Boolean compareTotalPrices() {
        int totalPriceByProducts = 0;
        for (int i = 0; i < getDriver().findElements(productList).size(); i++) {
            totalPriceByProducts = parseInt(getDriver().findElements(productList).get(i).findElement(quantityOfProduct).getText()) *
                    parseInt(getDriver().findElements(productList).get(i).findElement(priceOfProduct).getText());
        }
        if(parseInt(String.valueOf(totalPrice)) == totalPriceByProducts) return true;
        else return false;
    }



}
