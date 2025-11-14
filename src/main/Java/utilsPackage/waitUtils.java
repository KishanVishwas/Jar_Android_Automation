package utilsPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static basePackage.driverFactory.driver;
import static basePackage.driverFactory.wait;

public class waitUtils {

    public static WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static WebElement waitForPresenceElementLocated(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement findElementwithAppium(By locator) {
        return driver.findElement(locator);
    }
}
