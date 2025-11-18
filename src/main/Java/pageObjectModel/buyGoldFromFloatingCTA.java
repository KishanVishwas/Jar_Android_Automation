package pageObjectModel;

import locaters.elementLocators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import static basePackage.actions.takeScreenShot;
import static basePackage.driverFactory.driver;
import static utilsPackage.waitUtils.waitForVisibility;

@Slf4j
public class buyGoldFromFloatingCTA {

    elementLocators loc = new elementLocators(driver);

    public void instantSaveScreen() {
        try {
            WebElement instantSave = waitForVisibility(loc.getSaveInstantlyCTA());
            instantSave.click();

        } catch (TimeoutException e) {

            waitForVisibility(loc.getHomeTab());
            log.info("HomeScreen Redirected");

            takeScreenShot(driver, "instant_save_screen");
        }
    }
}