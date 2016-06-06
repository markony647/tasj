package core;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.firefox.FirefoxDriver;

import static core.ConciseAPI.getWebDriver;
import static core.ConciseAPI.setWebDriver;


public class BaseTest {

    @BeforeClass
    public static void setup() {
        setWebDriver(new FirefoxDriver());
    }

    @AfterClass
    public static void tearDown() {
        getWebDriver().quit();
    }
}
