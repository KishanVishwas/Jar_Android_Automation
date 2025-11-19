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

//    @BeforeClass
    public static void setUpVirtualDevices() {
//        simulatorManager.openSimulator();
        emulatorManager.openAndroidEmulator();
    }

    @BeforeTest
    public static void createDriver() throws Exception {
        driverFactory.driverSetup();
    }

    @AfterTest
    public static void destroyDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

//    @AfterClass
    public static void closeVirtualDevices() {
//        simulatorManager.closingSimulator();
        emulatorManager.closeAndroidEmulator();
    }

    @AfterSuite
    public static void stopAppiumServer() {
        appiumServerManager.stopServer();
    }
}
