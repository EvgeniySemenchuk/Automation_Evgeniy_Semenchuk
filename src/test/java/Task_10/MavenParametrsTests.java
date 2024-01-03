package Task_10;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.NavigationPage;

public class MavenParametrsTests extends BaseTest {

    private LoginPage loginPage;
    private NavigationPage navigationPage;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
        navigationPage = new NavigationPage();
        loginPage.open();
    }

    @Test( description = "login page test with using maven paramerts ")
    public void loginTests() {
        loginPage.verifyPage();
        loginPage.enterUsername(System.getProperty("login"));
        loginPage.enterPassword(System.getProperty("password"));
        loginPage.clickLoginButton();
        navigationPage.openMenu();
        navigationPage.clickMenuItem("Logout");
    }

}
