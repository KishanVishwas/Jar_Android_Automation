package pageObjectModel;


import com.beust.ah.A;
import locaters.buyGoldFlowLocators;
import locaters.dailySavingsLocators;
import locaters.onboardingLocators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import static basePackage.driverFactory.driver;
import static basePackage.driverFactory.wait;
import static utilsPackage.waitUtils.*;

@Slf4j
public class dailySavingsPOM {
    dailySavingsLocators dsL = new dailySavingsLocators(driver);
    buyGoldFlowLocators buyG = new buyGoldFlowLocators(driver);

    public void setupDailySaving() {
        waitForVisibility(dsL.getProfileIcon()).click();
        scrollUntilElementFound(driver, dsL.getDsInProfile());
        try {
            waitForVisibility(dsL.getDsInProfile()).click();
        } catch (Exception e) {
            log.info("Daily savings option CTA is not clickable");
        }
        WebElement dstextArea = waitForVisibility(dsL.getDsAmountArea());
        dstextArea.clear();
        dstextArea.sendKeys("200");
        waitForClick(dsL.getSetupDsCTA()).click();
        try {
            waitForClick(dsL.getWeeklyBoosterBS()).click();
            waitForVisibility(dsL.getProceedForPaymentCTA()).click();
        } catch (TimeoutException e) {
            waitForVisibility(dsL.getProceedForPaymentCTA()).click();
        }
        waitForVisibility(dsL.getPhonePayPaymentButton()).click();
        waitForClick(dsL.getPinCompleted()).click();
        waitForVisibility(dsL.getGoToHomeCTA()).click();
    }

    public void stopDailySaving() {
        waitForClick(dsL.getProfileIcon()).click();
        try {
            scrollUntilElementFound(driver, dsL.getDsInProfile());
            waitForVisibility(dsL.getDsInProfile()).click();
            try {
                waitForVisibility(dsL.getDsActiveStatus());
                log.info("Daily saving is active ");
            } catch (NoSuchElementException e) {
                log.info("Daily saving is not active ");
            }
        } catch (RuntimeException e) {
            log.info("Daily saving is not visable  in hamberger");
            return;
        }

        try {
            scrollUntilElementFound(driver, dsL.getDsManageSavingropDown());
            waitForVisibility(dsL.getDsManageSavingropDown()).click();
            waitForVisibility(dsL.getDsStopCTA()).click();
        } catch (RuntimeException e) {
            log.info("Manage Saving Drop Down CTA is not visable");
            return;
        }
        try {
            waitForVisibility(dsL.getDsStopSavingCTAFormVideo()).click();
            log.info("Form video is  getting played");
        } catch (RuntimeException e) {
            log.info("Form video is not getting played");
        }
        try {
            WebElement reason = waitForVisibility(dsL.getDsDontWantToSaveAnymoreRedioButtonCTA());
            if (reason.isDisplayed() && reason.isEnabled()) {
                waitForClick(reason).click();
            }
            log.info("Don't Want To Save Any more reason is  selected");
        } catch (RuntimeException e) {
            log.info("Don't Want To Save Any more reason is not displaying in the screen ");
            return;
        }
        try {
            WebElement submit = waitForClick(dsL.getDsSubmitReasonCTA());
            if (submit.isEnabled()) {
                waitForClick(dsL.getDsSubmitReasonCTA()).click();
            }
        } catch (RuntimeException e) {
            log.info("Submit CTA in the reason selection is not clickable");
            return;
        }
        try {
            waitForVisibility(dsL.getDsStopSavingCTA()).click();
            log.info("Clicked on Stop saving after selecting the reason");
        } catch (RuntimeException e) {
            log.info("Stop saving CTA after selecting the reason is not displaying");
            return;
        }

        try {
            waitForVisibility(dsL.getDs_StopPermanentlyRedioButtom()).click();
            waitForClick(dsL.getDsStopSavingCTA()).click();
        } catch (Exception e) {
            log.info("Stop Permanently Radio Button is not clickable ");
            return;
        }
        try {
            waitForVisibility(dsL.getGoToHomeCTA()).click();
            log.info("Clicked on Go to home CTA");
        } catch (Exception e) {
            log.info("Go to home CTA is not visible");
        }
    }

    public void updateDS() {
        waitForClick(buyG.getProfileIcon()).click();
        try {
            waitForVisibility(dsL.getDsUpdateProfile()).click();
        } catch (TimeoutException e) {
            log.info("Daily saving is not active");
        }
        try {
            WebElement increas = waitForVisibility(dsL.getUpdateMandateCta());
            if (increas.isEnabled()) {
                increas.click();
            }
        } catch (Exception e) {
            log.info("increase CTA is disable");
        }
        try {
            String ApText = waitForVisibility(dsL.getAutomaticStepUpBottomSheet()).getText();
            log.info("user got Automatic Step-Up Bottom sheet");
            if (ApText.equalsIgnoreCase("Automatic Step-Up")) {

                waitForClick(dsL.getWithOutStepUpRedioButton()).click();
                waitForVisibility(dsL.getProceedWithOutStepUpRedioButton()).click();
            } else {
                log.info("Auto step up bottom sheet has not opened");
            }
        } catch (Exception e) {
            log.info("Auto step up bottom sheet has not opened");
        }
        try {
            waitForVisibility(dsL.getPhonePayPaymentButton()).click();
            waitForClick(dsL.getPinCompleted()).click();
            waitForVisibility(dsL.getGoToHomeCTA()).click();
        } catch (Exception e) {
            log.info("PhonePay bottom sheet as not opened");
        }
        try {
            WebElement lockerCTA = waitForVisibility(dsL.getGoToLockerCTA());
            if(lockerCTA.isDisplayed()) {
                lockerCTA.click();
                driver.navigate().back();
            }
        } catch (TimeoutException e) {
            log.info("New order success screen is not displayed so Locker CTA is not clickable");
            WebElement goToHameCTA = waitForVisibility(dsL.getOrdrSucessGoToHomeCTA());
            goToHameCTA.click();

        }

    }

    public void autoStepup() {
        try {
            String ApText = waitForVisibility(dsL.getAutomaticStepUpBottomSheet()).getText();
            log.info("user got Automatic Step-Up Bottom sheet");
            if (ApText.equalsIgnoreCase("Automatic Step-Up")) {
                waitForClick(dsL.getWithStepUpRedioButton()).click();
                waitForVisibility(dsL.getActivateStepUpCTA()).click();
            } else {
                log.info("Auto step up bottom sheet has not opened");
            }
        } catch (Exception e) {
            log.info("User is not Eligible for Auto step up bottom sheet");
        }

    }
}
