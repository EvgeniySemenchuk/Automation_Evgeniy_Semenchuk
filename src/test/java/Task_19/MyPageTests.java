package Task_19;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageFactory.saucedemo.LoginPage;
import pageObjects.baseObjects.BaseTest;
import pageObjects.mypage.HomePage;

import static driver.DriverCreation.getDriver;

public class MyPageTests extends BaseTest {

    @BeforeMethod
    public void precondtition() {
        get(HomePage.class).open();
    }

    @Test(priority = 1)
    public void firstColumnText() {
        System.out.println(get(HomePage.class).getFirstColumnData());
    }

    @Test(priority = 2)
    public void inputTest() {
        get(HomePage.class).enterField("The catcher on the rye");
    }

    @Test(priority = 3)
    public void checkBoxTest() {
        get(HomePage.class).clickCheckBox1().clickCheckBox2();
    }

    @Test(priority = 4)
    public void selectTest() {
        get(HomePage.class).selectCity("Mogilev");
    }

    @Test(priority = 5)
    public void buttonTest() {
        get(HomePage.class).clickButton();
    }

    @Test(priority = 6)
    public void imageTest() {
        Assert.assertTrue(get(HomePage.class).visibilityOfImage());
    }

    @Test(priority = 7)
    public void paragraphTest() {
        System.out.println(get(HomePage.class).getTextInParagraph());
    }

    @Test(priority = 8)
    public void linkTest() {
        get(HomePage.class).clickLink();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.livelib.ru/books/top");
    }

}
