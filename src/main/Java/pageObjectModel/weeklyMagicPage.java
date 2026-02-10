package pageObjectModel;

import locaters.buyGoldFlowLocators;
import locaters.weeklyMagicLocators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

import static basePackage.actions.takeScreenShot;
import static basePackage.driverFactory.driver;
import static utilsPackage.waitUtils.*;

@Slf4j
public class weeklyMagicPage {
    weeklyMagicLocators wM = new weeklyMagicLocators(driver);

    public void weeklyMagicSetup() {
        weeklyMagicRedirection();
        weeklyGoThrough();
    }

    private void weeklyMagicRedirection() {
        waitForClick(wM.getProfileIcon()).click();
        scrollUntilElementFound(driver, wM.getWeeklyMagicInProfile());
        WebElement week = waitForVisibility(wM.getWeeklyMagicInProfile());
        if (week != null) {
            week.click();
        }
    }

    private void weeklyGoThrough() {

        try {
            WebElement lC = waitForClick(wM.getBtnLeftChevron());
            if (lC != null) {
                lC.click();
            }
        } catch (Exception e) {
            log.error("old weekly magic not displayed");
        }
        waitForClick(wM.getLeftChevron()).click();
        waitForClick(wM.getLeftChevron()).click();
        WebElement title = waitForVisibility(wM.getCurrentWeekTitle());
        if (title != null) {
            log.info("Weekly_savings_currentWeek score");
        }
        waitForClick(wM.getBtnRightChevron()).click();
        waitForClick(wM.getRightChevron()).click();
        waitForClick(wM.getRightChevron()).click();
        try {
            WebElement cta = waitForVisibility(wM.getGetMystryCardCta());
            if (cta != null && "Get Mystery Card".equals(cta.getText())) {
                log.info("Get Mystery Card cta is visible");
                cta.click();
            }
        } catch (Exception e) {
            log.error("Get Mystry Card cta is not visible");
        }
        try {
            WebElement header = waitForVisibility(wM.getInstantSaveHeader());
            if (header != null && "INSTANT SAVING".equals(header.getText())) {
                buyGoldFromFloatingCTA buyGold = new buyGoldFromFloatingCTA();
                buyGold.amountEntering();
                buyGold.buyGoldAsZomatoAndNonZomato();
            }
        } catch (Exception e) {
            waitForClick(wM.getBackNaviateWeekly()).click();
            driver.navigate().back();
            driver.navigate().refresh();
        }
    }
}
