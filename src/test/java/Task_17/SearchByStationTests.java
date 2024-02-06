package Task_17;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTestSelenide;
import pageObjects.rw.HomePage;

import static com.codeborne.selenide.WebDriverRunner.driver;

public class SearchByStationTests extends BaseTestSelenide {

    @Test(dataProvider = "station")
    public void searchByStationTest(String station) {
        get(HomePage.class)
                .choseByStation()
                .enterStation(station)
                .searchStation();
        Assert.assertFalse(driver().url().equals("https://www.rw.by"), "Couldn't navigate to the selected route page");
        driver().getWebDriver().navigate().back();
    }

    @DataProvider(name = "station")
    public Object[][] getData2() {
        return new Object[][]{
                {"Институт Культуры "},
                {"Лебяжий "},
                {"#GF#4 "}

        };
    }

}
