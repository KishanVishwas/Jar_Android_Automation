package basePackage;

import utilsPackage.configReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

public class driverFactory {

    public static WebDriverWait wait;
    public static AppiumDriver driver;

    // -------------------------------------------------------
    //     MAIN DRIVER SETUP (Platform Switch)
    // -------------------------------------------------------
    public static AppiumDriver driverSetup() throws Exception {

        String platform = configReader.get("platformName");

        if (platform.equalsIgnoreCase("Android")) {
            driver = setupAndroid();
        }
        else if (platform.equalsIgnoreCase("iOS")) {
            driver = setupIOS();
        }
        else {
            throw new Exception("❌ Invalid platform! Use: android / ios");
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        return driver;
    }
    //                   ANDROID SETUP
    private static AppiumDriver setupAndroid() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:appPackage","com.aso_centric.jar.staging");
        caps.setCapability("appium:appActivity", configReader.get("androidActivity"));

        // You can load these also from config.xml if needed
        //caps.setCapability("appium:deviceName", configReader.get("androidDeviceName"));
        caps.setCapability("appium:udid", configReader.get("androidUDID"));
        caps.setCapability("appium:platformVersion", configReader.get("androidPlatformVersion"));

        caps.setCapability("appium:autoGrantPermissions", true);
        caps.setCapability("appium:deviceName", configReader.get("androidDeviceName"));
        caps.setCapability("appium:noReset", false);
        caps.setCapability("appium:app", configReader.get("androidApp"));



        return new AndroidDriver(new URL(configReader.get("appiumServerURL")), caps);
    }
    //                     iOS SETUP
    private static AppiumDriver setupIOS() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", configReader.get("platformName"));
        caps.setCapability("appium:automationName", configReader.get("automationName"));
        caps.setCapability("appium:deviceName", configReader.get("deviceName"));
        caps.setCapability("appium:udid", configReader.get("uuid"));
        caps.setCapability("appium:platformVersion", configReader.get("platformVersion"));

        caps.setCapability("appium:autoAcceptAlerts",
                Boolean.parseBoolean(configReader.get("autoAcceptAlerts")));

        caps.setCapability("appium:noReset", false);
        caps.setCapability("appium:fullReset", true);
// ⚠ should not be true with noReset

// 🔥 Important capabilities for your iOS 17.5 workaround
        caps.setCapability("appium:waitForQuiescence", false);
        caps.setCapability("appium:waitForIdleTimeout", 0);
        caps.setCapability("appium:simpleIsVisibleCheck", true);
        caps.setCapability("appium:includeNonModalElements", true);
        caps.setCapability("appium:usePrebuiltWDA", true);

// iOS App: app (.app/.ipa) OR bundleId
        if (configReader.get("app") != null && !configReader.get("app").isEmpty()) {
            caps.setCapability("appium:app", configReader.get("app"));
        } else {
            caps.setCapability("appium:bundleId", configReader.get("bundleId"));
        }

        return new IOSDriver(new URL(configReader.get("appiumServerURL")), caps);

    }
}
