package pageObjectModel;

import locaters.buyGoldFlowLocators;
import locaters.weeklyMagicLocators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

import static basePackage.actions.takeScreenShot;
import static basePackage.driverFactory.driver;
import static utilsPackage.waitUtils.waitForClick;
import static utilsPackage.waitUtils.waitForVisibility;

@Slf4j
public class weeklyMagicPage {
    weeklyMagicLocators wM = new weeklyMagicLocators(driver);

    public void weeklyMagicSetup() {
        weeklyMagicRedirection();
        weeklyGoThrough();
    }

    private void weeklyMagicRedirection() {
        WebElement notch = waitForVisibility(wM.getWeeklyNotch());
        if (notch != null) {
            notch.click();
        } else {
            waitForClick(wM.getProfileIcon()).click();
            WebElement week = waitForVisibility(wM.getWeeklyMagicInProfile());
            if (week != null) {
                week.click();
            }
        }
    }

    private void weeklyGoThrough() {

        waitForClick(wM.getBtnLeftChevron()).click();
        waitForClick(wM.getLeftChevron()).click();
        WebElement title = waitForVisibility(wM.getCurrentWeekTitle());
        if (title != null) {
            takeScreenShot(driver, "Weekly_savings_currentWeek");
            log.info("Weekly_savings_currentWeek score");
        }
        waitForClick(wM.getBtnRightChevron()).click();
        waitForClick(wM.getRightChevron()).click();
        WebElement cta = waitForVisibility(wM.getGetMystryCardCta());
        if (cta != null && "Get Mystery Card".equals(cta.getText())) {
            cta.click();
        } else {
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
        }
    }
}
