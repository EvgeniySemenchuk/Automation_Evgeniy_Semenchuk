package pageObjects.baseObjects;

import driver.DriverTypes;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import testngUtils.InvokedListener;
import testngUtils.Listener;


import java.lang.reflect.InvocationTargetException;

import static driver.DriverCreation.createDriver;
import static driver.DriverCreation.*;
import static driver.DriverTypes.*;
import static driver.DriverTypes.CHROME;
import static propertyUtils.PropertyReader.getProperties;

@Listeners({Listener.class, InvokedListener.class})
public class BaseTest {

    @BeforeTest
    protected void setUp() {
        createDriver(System.getProperties().containsKey("config")
                ? valueOf(getProperties().getProperty("browser").toUpperCase())
                : CHROME
        );
    }


    protected <T> T get(Class<T> page) {
        T instance;
        try {
            instance = page.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return instance;
    }

    @AfterTest(alwaysRun = true)
    protected void tearDown() {
        quitDriver();
    }

}
