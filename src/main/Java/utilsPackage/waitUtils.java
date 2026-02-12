package utilsPackage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static basePackage.driverFactory.driver;

@Slf4j
public class waitUtils {

    public static WebElement waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForSeconds(int seconds) {
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public static void scrollToElementByText(AndroidDriver driver, String visibleText) {
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().text(\"" + visibleText + "\"));"));
//    }

    public static void scrollUntilElementFound(AppiumDriver driver, WebElement element) {
        int maxScroll = 10;

        for (int i = 0; i < maxScroll; i++) {
            try {
                if (element.isDisplayed()) {
                    log.info("Element found!");
                    return;
                }
            } catch (Exception e) {
                log.info("Element is not found");
                scrollDown((AndroidDriver) driver);
            }
        }
        throw new RuntimeException("Element not found after scrolling");
    }

    public static void scrollUpUntilElementFound(WebElement element) {
        int maxScrolls = 10;

        for (int i = 0; i < maxScrolls; i++) {
            try {
                if (driver.findElement((By) element)!= null) {
                    log.info("Element found after scrolling up");
                    return;
                }
            } catch (Exception e) {
                log.info("Element not found, scrolling up... attempt " + (i + 1));
                scrollUp((AndroidDriver) driver);
            }
        }

        throw new RuntimeException("Element not found after scrolling up");
    }


    public static void scrollDown(AndroidDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.3);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    public static void scrollUp(AndroidDriver driver) {

        Dimension size = driver.manage().window().getSize();

        int startX = size.width / 2;
        int startY = (int) (size.height * 0.3);
        int endY = (int) (size.height * 0.85);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(900), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    public static void scrollTillEndOfSection(WebElement sectionElement) {

        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) sectionElement).getId());
        params.put("direction", "down");
        params.put("percent", 1.0);

        driver.executeScript("mobile: swipeGesture", params);
    }



    public static void dragCoinToEnd(WebElement coinElement, WebElement goldBarElement) {

        Point coinLocation = coinElement.getLocation();
        Dimension coinSize = coinElement.getSize();

        Point goldLocation = goldBarElement.getLocation();
        Dimension goldSize = goldBarElement.getSize();

        // Start from center of coin
        int startX = coinLocation.getX() + coinSize.getWidth() / 2;
        int startY = coinLocation.getY() + coinSize.getHeight() / 2;

        // End at center of gold bar
        int endX = goldLocation.getX() + goldSize.getWidth() / 2;
        int endY = goldLocation.getY() + goldSize.getHeight() / 2;

        Map<String, Object> params = new HashMap<>();

        params.put("startX", startX);
        params.put("startY", startY);
        params.put("endX", endX);
        params.put("endY", endY);
        params.put("speed", 800); // adjust if needed

        driver.executeScript("mobile: dragGesture", params);
    }



}
