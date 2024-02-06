package pageObjects.rw;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.driver;

public class HomePage {

    private final SelenideElement from = $("#acFrom");
    private final SelenideElement to = $("#acTo");
    private final SelenideElement searchByRoute = $x("//div[@class=\"button-wrapper\"]//input");
    private final SelenideElement searchByStation = $x("  (//div[@class=\"button-wrapper\"]//input)[2]");
    private final SelenideElement station = $("#acStation");
    private final SelenideElement switchStation = $(".switch");

    public HomePage enterFrom(String from) {
        this.from.shouldBe(visible).clear();
        this.from.sendKeys(from);
        return this;
    }

    public HomePage enterTo(String to) {
        this.to.shouldBe(visible).clear();
        this.to.sendKeys(to);
        return this;
    }

    public HomePage searchRoute() {
        searchByRoute.shouldBe(enabled).click();
        return this;
    }

    public HomePage searchStation() {
        searchByStation.shouldBe(enabled).click();
        return this;
    }

    public HomePage clickSwitch() {
        switchStation.shouldBe(visible).click();
        return this;
    }

    public String getFrom() {
        return from.getValue();
    }

    public String getTo() {
        return to.getValue();
    }

    //by route(1) or by station(2)
    private SelenideElement getTypeOfSearch(Integer index) {
        return $x("//label[@for=\"tabForm" + index + "\"]");
    }


    public HomePage choseByRoute() {
        getTypeOfSearch(1).shouldBe(exist).click();
        return this;
    }

    public HomePage choseByStation() {
        getTypeOfSearch(2).shouldBe(exist).click();
        return this;
    }

    public HomePage enterStation(String station) {
        this.station.shouldBe(visible).sendKeys(station);
        return this;
    }

    public HomePage navigateBack() {
        driver().getWebDriver().navigate().back();
        return this;
    }

}
