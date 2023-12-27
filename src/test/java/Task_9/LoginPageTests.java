package Task_9;

import org.checkerframework.checker.units.qual.N;
import org.testng.annotations.*;
import pageObjects.baseObjects.BaseTest;
import pageObjects.saucedemo.LoginPage;
import pageObjects.saucedemo.NavigationPage;

public class LoginPageTests extends BaseTest {

    private LoginPage loginPage;
    private NavigationPage navigationPage;

    @BeforeTest
    public void precondition() {
        loginPage = new LoginPage();
        navigationPage = new NavigationPage();
        loginPage.open();
    }

    @Test(dataProvider = "login test", description = "1 successful and 3 negative test of login page")
    public void loginTests(String userName, String password, Boolean loginStatus) {
        loginPage.verifyPage();
        loginPage.enterUsername(userName);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        if(loginStatus) {
            navigationPage.openMenu();
            navigationPage.clickMenuItem("Logout");
        }
    }

    @DataProvider(name = "login test")
    public Object[][] getData() {
        return new Object[][] {
                {"badLogin","secret_sauce",false},
                {"standard_user","wrongPassword2",false},
                {"standard_user","secret_sauce",true},
                {"standard_user","wrongPassword3",false},
        };
    }


}
