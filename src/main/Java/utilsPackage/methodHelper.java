package utilsPackage;

import org.openqa.selenium.By;

import static basePackage.driverFactory.driver;

public class methodHelper {

    public static boolean isElementPresent( By locator) {
    return !driver.findElements(locator).isEmpty();
    }
}
