package Task_17;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTestSelenide;
import pageObjects.rw.HomePage;
import pageObjects.rw.SchedulePage;

import static com.codeborne.selenide.Selenide.back;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.driver;
public class SearchByRouteTests extends BaseTestSelenide {

    @Test(priority = 2)
    public void searchByRouteTest(){
        get(HomePage.class)
                .enterFrom("Витебск")
                .enterTo("Минск")
                .searchRoute();
        Assert.assertFalse(driver().url().equals("https://www.rw.by"), "Couldn't navigate to the selected route page");
        get(HomePage.class).navigateBack();
    }

    @Test(priority = 1)
    public void switchTest() {
        get(HomePage.class)
                .enterFrom("Гомель")
                .enterTo("Москва")
                .clickSwitch();
        Assert.assertTrue(get(HomePage.class).getFrom().equals("Москва") && get(HomePage.class).getTo().equals("Гомель"),"Switch failed");
    }

    @Test(priority = 3)
    public void scheduleTest() {
        get(HomePage.class)
                .enterFrom("Гомель")
                .enterTo("Минск")
                .searchRoute();
        get(SchedulePage.class)
                .getRoutesInfo()
                .navigateBack();
    }

}
