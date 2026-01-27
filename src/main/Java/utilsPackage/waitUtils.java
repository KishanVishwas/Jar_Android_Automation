package utilsPackage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void scrollToElementByText(AndroidDriver driver, String visibleText) {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().text(\"" + visibleText + "\"));"));
    }

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

    public static void swipeDownFromElement(WebElement element) {

        Rectangle rect = element.getRect();

        // IMPORTANT: start slightly BELOW center
        int startX = rect.getX() + rect.getWidth() / 2;
        int startY = rect.getY() + (int)(rect.getHeight() * 0.7);

        // Strong downward swipe
        int endY = startY + (int)(rect.getHeight() * 3);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.viewport(),
                startX,
                startY));

        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        // SLOW swipe = momentum
        swipe.addAction(finger.createPointerMove(
                Duration.ofMillis(1000),
                PointerInput.Origin.viewport(),
                startX,
                endY));

        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    public static void swipeDownUsingGesture(WebElement element) {

        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) element).getId());
        params.put("direction", "down");
        params.put("percent", 0.75); // strong swipe

        driver.executeScript("mobile: swipeGesture", params);
    }

    public static void pressAndDragDown(WebElement element) {

        Rectangle rect = element.getRect();

        int startX = rect.getX() + rect.getWidth() / 2;
        int startY = rect.getY() + rect.getHeight() / 2;

        // Drag down strongly
        int endX = startX;
        int endY = startY + (rect.getHeight() * 3);

        Map<String, Object> params = new HashMap<>();
        params.put("startX", startX);
        params.put("startY", startY);
        params.put("endX", endX);
        params.put("endY", endY);
        params.put("duration", 1500); // LONG press + drag

        driver.executeScript("mobile: dragGesture", params);
    }

    public static void pressAndDragFromElement(WebElement element) {

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence drag = new Sequence(finger, 1);

        // Start exactly on the element
        drag.addAction(finger.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.fromElement(element),
                0,
                0
        ));

        // LONGER PRESS
        drag.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        drag.addAction(new Pause(finger, Duration.ofMillis(1200)));// ⬅ increased

        // LONGER + SLOWER DRAG
        drag.addAction(finger.createPointerMove(
                Duration.ofMillis(1800), // ⬅ slower
                PointerInput.Origin.fromElement(element),
                0,
                700 // ⬅ longer drag
        ));

        drag.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(drag));
    }
}
