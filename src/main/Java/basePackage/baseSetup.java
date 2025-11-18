package basePackage;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class baseSetup {
    public static AppiumDriver driver;

    @BeforeSuite
    public static void startAppiumServer() {
        appiumServerManager.startServer();
    }

    @BeforeClass
    public static void setUpEmulator() {
        emulatorManager.openAndroidEmulator();
    }

    @BeforeTest
    public static void createDriver() throws MalformedURLException {
        driverFactory.driverSetup();
    }

    @AfterClass
    public static void destroyDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterClass
    public static void closeEmulator() {
        emulatorManager.closeAndroidEmulator();
    }

    @AfterSuite
    public static void stopAppiumServer() {
        appiumServerManager.stopServer();
    }
}
