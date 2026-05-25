package basePackage;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.*;

public class baseSetup {
    public static AppiumDriver driver;

    @BeforeSuite
    public void globalSetup() throws Exception {
        appiumServerManager.startServer();
        driver = driverFactory.driverSetup();
    }

    @AfterSuite
    public void globalTearDown() {
        if (driver != null) {
            driver.quit();
        }
        appiumServerManager.stopServer();
    }
}