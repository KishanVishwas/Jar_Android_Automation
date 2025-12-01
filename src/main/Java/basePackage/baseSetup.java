package basePackage;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.*;

public class baseSetup {
    public static AppiumDriver driver;

    @BeforeSuite
    public void globalSetup() throws Exception {
        // Start Appium one time
        appiumServerManager.startServer();

        // Start emulator one time
        emulatorManager.openAndroidEmulator();

        // Create driver one time
        driverFactory.driverSetup();
    }

    @AfterSuite
    public void globalTearDown() {
        // Quit driver one time
        if (driver != null) {
            driver.quit();
        }

        // Close emulator one time
        emulatorManager.closeAndroidEmulator();

        // Stop Appium one time
        appiumServerManager.stopServer();
    }
}
