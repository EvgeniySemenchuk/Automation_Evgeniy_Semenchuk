package Task_13;

import entities.saucedemo.UserBuilder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageFactory.saucedemo.LoginPage;
import pageObjects.baseObjects.BaseTest;

public class BuilderTests extends BaseTest {

    @BeforeMethod
    public void setUpTest() {
        get(LoginPage.class).open();
    }


    @Test(priority = 3, dataProvider = "get user builder")
    public void loginTest(UserBuilder user) {
        get(LoginPage.class)
                .waitUntilPageLoaded()
                .login(user)
                .clickLogin();
    }

    @DataProvider(name = "get user builder")
    public Object[][] getUserData() {
        return new Object[][]{
                { UserBuilder.builder()
                        .withUsername("standard_user")
                        .withPassword("secret_sauce")
                        .build()},
                {UserBuilder.builder()
                        .withUsername("locked_out_user")
                        .withPassword("secret_sauce")
                        .build()},
                {UserBuilder.builder()
                        .withUsername("problem_user")
                        .withPassword("secret_sauce")
                        .build()}
        };
    }

}
