package basePackage;

import utilsPackage.configReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class driverFactory {

    public static WebDriverWait wait;
    public static AppiumDriver driver;

    // -------------------------------------------------------
    //     MAIN DRIVER SETUP (Platform + Environment Switch)
    // -------------------------------------------------------
    public static AppiumDriver driverSetup() throws Exception {

        String platform = configReader.get("platformName");   // Android / iOS
        String env = configReader.get("env");                 // local / browserstack

        System.out.println("ENV: [" + env + "]");
        System.out.println("PLATFORM: [" + platform + "]");

        // ---------------- BrowserStack ----------------
        if ("browserstack".equalsIgnoreCase(env)) {

            System.out.println("👉 Running on BrowserStack");

            if ("Android".equalsIgnoreCase(platform)) {
                throw new UnsupportedOperationException("Android BrowserStack setup not implemented yet");

            } else if ("iOS".equalsIgnoreCase(platform)) {
                driver = setupIOSBrowserStack();
            } else {
                throw new Exception("❌ Invalid platform for BrowserStack");
            }

        }
        // ---------------- Local ----------------
        else {

            System.out.println("👉 Running on LOCAL");

            if ("Android".equalsIgnoreCase(platform)) {
                driver = setupAndroid();
            } else if ("iOS".equalsIgnoreCase(platform)) {
                driver = setupIOS();
            } else {
                throw new Exception("❌ Invalid platform! Use Android / iOS");
            }
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return driver;
    }

    // -------------------------------------------------------
    //                   ANDROID LOCAL SETUP
    // -------------------------------------------------------
    private static AppiumDriver setupAndroid() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:appPackage", "com.aso_centric.jar.staging");
        caps.setCapability("appium:appActivity", configReader.get("androidActivity"));

        caps.setCapability("appium:udid", configReader.get("androidUDID"));
        caps.setCapability("appium:platformVersion", configReader.get("androidPlatformVersion"));
        caps.setCapability("appium:deviceName", configReader.get("androidDeviceName"));

        caps.setCapability("appium:autoGrantPermissions", true);
        caps.setCapability("appium:noReset", false);
        caps.setCapability("appium:app", configReader.get("androidApp"));

        return new AndroidDriver(new URL(configReader.get("appiumServerURL")), caps);
    }

    // -------------------------------------------------------
    //                   iOS LOCAL SETUP
    // -------------------------------------------------------
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

        caps.setCapability("appium:waitForQuiescence", false);
        caps.setCapability("appium:waitForIdleTimeout", 0);
        caps.setCapability("appium:simpleIsVisibleCheck", true);
        caps.setCapability("appium:includeNonModalElements", true);
        caps.setCapability("appium:usePrebuiltWDA", true);

        if (configReader.get("app") != null && !configReader.get("app").isEmpty()) {
            caps.setCapability("appium:app", configReader.get("app"));
        } else {
            caps.setCapability("appium:bundleId", configReader.get("bundleId"));
        }

        return new IOSDriver(new URL(configReader.get("appiumServerURL")), caps);
    }

    // -------------------------------------------------------
    //               iOS BROWSERSTACK SETUP
    // -------------------------------------------------------
    private static AppiumDriver setupIOSBrowserStack() throws Exception {

        DesiredCapabilities caps = new DesiredCapabilities();

        // Core
        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:automationName", "XCUITest");
        caps.setCapability("appium:app", "bs://dd41d344a15407d959b3987875b7ba01c397ea55");
        caps.setCapability("appium:autoAcceptAlerts", true);

        // BrowserStack options
        HashMap<String, Object> bstackOptions = new HashMap<>();

        bstackOptions.put("userName", "testing_repf4l");
        bstackOptions.put("accessKey", "wsGdeqpsQfqbCFK4dvE3");

        bstackOptions.put("deviceName", "iPhone 16 Pro");
        bstackOptions.put("osVersion", "18.0");

//        bstackOptions.put("projectName", "Mobile Automation");
//        bstackOptions.put("buildName", "Inspector Debug");
//        bstackOptions.put("sessionName", "Inspector iOS Session");

        bstackOptions.put("debug", true);
        bstackOptions.put("networkLogs", true);

        caps.setCapability("bstack:options", bstackOptions);

        System.out.println("🚀 Starting BrowserStack session...");

        // ✅ IMPORTANT: assign to global driver (no shadowing)
        driver = new IOSDriver(
                new URL("http://hub-cloud.browserstack.com/wd/hub"),
                caps
        );

        System.out.println("✅ BrowserStack session created: " + driver.getSessionId());

        return driver;
    }
}