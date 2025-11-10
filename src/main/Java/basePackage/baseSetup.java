package basePackage;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;

public class baseSetup {
    public static AppiumDriver driver;

    @BeforeSuite
    public static void startAppiumServer(){
        appiumServerManager.startServer();
    }

    @BeforeClass
    public static void createDriver() throws MalformedURLException {
        driverFactory.driverSetup();
    }

    @AfterClass
    public static void destroyDriver(){
        if (driver!=null){
            driver.quit();
        }
    }

    @AfterSuite
    public static void stopAppiumServer(){
        appiumServerManager.stopServer();
    }
}
