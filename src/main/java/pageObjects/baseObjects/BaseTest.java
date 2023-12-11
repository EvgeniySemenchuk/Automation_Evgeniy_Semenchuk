package pageObjects.baseObjects;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import static driver.DriverCreation.createDriver;
import static driver.DriverCreation.quitDriver;
import static driver.DriverTypes.CHROME;

public class BaseTest {

    @BeforeTest
    protected void setUp() {
        createDriver(CHROME);
    }

    @AfterTest
    protected void tearDown() {
        quitDriver();
    }

}
