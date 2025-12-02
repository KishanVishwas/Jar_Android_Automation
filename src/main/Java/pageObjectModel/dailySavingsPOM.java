package pageObjectModel;

import locaters.elementLocators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

import static basePackage.driverFactory.driver;
import static utilsPackage.waitUtils.*;

@Slf4j
public class dailySavingsPOM {
    elementLocators loc = new elementLocators(driver);

    public void setupDailySaving() {
        waitForVisibility(loc.getProfileIcon()).click();
        scrollUntilElementFound(driver, loc.getDsInProfile());
        try {
            waitForVisibility(loc.getDsInProfile()).click();
        } catch (Exception e) {
            log.info("Daily savings option CTA is not clickable");
        }
        WebElement dstextArea = waitForVisibility(loc.getDsAmountArea());
            dstextArea.sendKeys("200");
        waitForClick(loc.getSetupDsCTA()).click();
        WebElement proceedCTA = waitForVisibility(loc.getProceedForPaymentCTA());
        if (proceedCTA.isEnabled()) {
            proceedCTA.click();
        }
        waitForVisibility(loc.getPhonePayPaymentButton()).click();
        waitForClick(loc.getPinCompleted()).click();
        waitForVisibility(loc.getGoToHomeCTA()).click();
    }
}
