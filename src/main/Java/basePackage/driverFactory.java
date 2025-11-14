package basePackage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class driverFactory {
    public static WebDriverWait wait;
    public static AppiumDriver driver = null;

    public static AppiumDriver driverSetup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // --- Android Device Capabilities ---
        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:deviceName", "Samsung Note 10");
        caps.setCapability("appium:udid", "R3CMA02PYNK");
        caps.setCapability("appium:platformVersion", "12.0");
        caps.setCapability("appium:autoAcceptAlerts", true);

        // --- App Specific Capabilities ---
        caps.setCapability("appium:app", "/Users/kishanr/Downloads/base (1).apk");
        caps.setCapability("appium:appPackage", "com.aso_centric.jar.staging");
        caps.setCapability("appium:appActivity", "com.jar.app.feature.home.ui.activity.HomeActivity");
        caps.setCapability("appium:appWaitActivity", "com.jar.app.*");
        caps.setCapability("appium:noReset", false);
        caps.setCapability("appium:fullReset", true);
        caps.setCapability("appium:autoGrantPermissions", true);

        // --- Connect to Appium Server ---
        URL url = new URL("http://127.0.0.1:4723/");

        driver = new AndroidDriver(url, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return driver;
    }
}
