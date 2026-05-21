package basePackage;

import utilsPackage.configReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

@Slf4j
public class driverFactory {

    public static WebDriverWait wait;
    public static AppiumDriver driver;

    public static AppiumDriver driverSetup() throws Exception {
        String platform = configReader.get("androidPlatformName");
        String env = configReader.get("envLocal");

        log.info("ENV: [{}]", env);
        log.info("PLATFORM: [{}]", platform);

        if ("browserstack".equalsIgnoreCase(env)) {
            log.info("Running on BrowserStack");
            if ("Android".equalsIgnoreCase(platform)) {
                throw new UnsupportedOperationException("Android BrowserStack setup not implemented yet");
            } else if ("iOS".equalsIgnoreCase(platform)) {
                driver = setupIOSBrowserStack();
            } else {
                throw new IllegalArgumentException("Invalid platform for BrowserStack: " + platform);
            }
        } else {
            log.info("Running on LOCAL");
            if ("Android".equalsIgnoreCase(platform)) {
                driver = setupAndroid();
            } else if ("iOS".equalsIgnoreCase(platform)) {
                driver = setupIOS();
            } else {
                throw new IllegalArgumentException("Invalid platform (use Android or iOS): " + platform);
            }
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return driver;
    }

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

    private static AppiumDriver setupIOS() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", configReader.get("platformName"));
        caps.setCapability("appium:automationName", configReader.get("automationName"));
        caps.setCapability("appium:deviceName", configReader.get("deviceName"));
        caps.setCapability("appium:udid", configReader.get("uuid"));
        caps.setCapability("appium:platformVersion", configReader.get("bsPlatformVersion"));
        caps.setCapability("appium:autoAcceptAlerts", Boolean.parseBoolean(configReader.get("autoAcceptAlerts")));
        caps.setCapability("appium:noReset", false);
        caps.setCapability("appium:fullReset", false);
        caps.setCapability("appium:waitForQuiescence", false);
        caps.setCapability("appium:waitForIdleTimeout", 0);
        caps.setCapability("appium:simpleIsVisibleCheck", true);
        caps.setCapability("appium:includeNonModalElements", true);
        caps.setCapability("appium:usePrebuiltWDA", true);

        String app = configReader.getOrDefault("app", "");
        if (!app.isEmpty()) {
            caps.setCapability("appium:app", app);
        } else {
            caps.setCapability("appium:bundleId", configReader.get("bundleId"));
        }

        return new IOSDriver(new URL(configReader.get("appiumServerURL")), caps);
    }

    private static AppiumDriver setupIOSBrowserStack() throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "iOS");
        caps.setCapability("appium:automationName", "XCUITest");
        caps.setCapability("appium:app", configReader.get("bsApp"));
        caps.setCapability("appium:autoAcceptAlerts", true);

        HashMap<String, Object> bstackOptions = new HashMap<>();
        bstackOptions.put("userName", configReader.get("bsUser"));
        bstackOptions.put("accessKey", configReader.get("bsKey"));
        bstackOptions.put("deviceName", configReader.get("bsDeviceName"));
        bstackOptions.put("osVersion", configReader.get("bsPlatformVersion"));
        bstackOptions.put("debug", true);
        bstackOptions.put("networkLogs", true);

        caps.setCapability("bstack:options", bstackOptions);

        log.info("Starting BrowserStack session...");
        driver = new IOSDriver(new URL(configReader.get("bsHubUrl")), caps);
        log.info("BrowserStack session created: {}", driver.getSessionId());

        return driver;
    }
}