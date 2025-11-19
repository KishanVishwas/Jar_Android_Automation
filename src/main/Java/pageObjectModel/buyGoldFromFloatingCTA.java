package pageObjectModel;

import locaters.elementLocators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import static basePackage.actions.takeScreenShot;
import static basePackage.driverFactory.driver;
import static basePackage.driverFactory.wait;
import static utilsPackage.waitUtils.waitForClick;
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

    public void amountEntering() {
        try {
            waitForVisibility(loc.getSaveInGoldTitle());
            WebElement amountEnter = waitForClick(loc.getAmountInputArea());
            amountEnter.clear();
            amountEnter.sendKeys("100");
            WebElement payCta = waitForVisibility(loc.getPayNowCTA());
            if (payCta.isEnabled()) {
                payCta.click();
            }
        } catch (TimeoutException e) {
            WebElement payCta = waitForVisibility(loc.getPayNowCTA());
            if (payCta.isEnabled()) {
                payCta.click();
            }
        }
    }
}