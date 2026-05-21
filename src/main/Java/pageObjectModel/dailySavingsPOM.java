package pageObjectModel;

import locaters.buyGoldFlowLocators;
import locaters.dailySavingsLocators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import utilsPackage.PaymentHelper;

import static basePackage.driverFactory.driver;
import static utilsPackage.waitUtils.*;

@Slf4j
public class dailySavingsPOM {
    dailySavingsLocators dsL = new dailySavingsLocators(driver);
    buyGoldFlowLocators buyG = new buyGoldFlowLocators(driver);
    PaymentHelper payment = new PaymentHelper();

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
        payment.completePhonePePayment();
        payment.goToHome();
    }

    public void stopDailySaving() {
        waitForClick(dsL.getProfileIcon()).click();
        try {
            scrollUntilElementFound(driver, dsL.getDsInProfile());
            waitForVisibility(dsL.getDsInProfile()).click();
            try {
                waitForVisibility(dsL.getDsActiveStatus());
                log.info("Daily saving is active");
            } catch (NoSuchElementException e) {
                log.info("Daily saving is not active");
            }
        } catch (RuntimeException e) {
            log.info("Daily saving is not visible in hamburger");
            return;
        }

        try {
            scrollUntilElementFound(driver, dsL.getDsManageSavingropDown());
            waitForVisibility(dsL.getDsManageSavingropDown()).click();
            waitForVisibility(dsL.getDsStopCTA()).click();
        } catch (RuntimeException e) {
            log.info("Manage Saving Drop Down CTA is not visible");
            return;
        }
        try {
            waitForVisibility(dsL.getDsStopSavingCTAFormVideo()).click();
            log.info("FOMO video is getting played");
        } catch (RuntimeException e) {
            log.info("FOMO video is not getting played");
        }

        try {
            WebElement reason = waitForVisibility(dsL.getDsDontWantToSaveAnymoreRedioButtonCTA());
            if (reason != null && reason.isEnabled()) {
                waitForClick(reason).click();
            }
            log.info("Don't Want To Save Anymore reason is selected");
        } catch (RuntimeException e) {
            WebElement issueSec = waitForVisibility(dsL.getIssueInWithdrawalAmount());
            if (issueSec != null && "Issue in withdrawal amount".equalsIgnoreCase(issueSec.getText())) {
                issueSec.click();
            }
            log.info("Don't Want To Save Anymore reason is not displaying");
            return;
        }
        try {
            WebElement submit = waitForClick(dsL.getDsSubmitReasonCTA());
            if (submit.isEnabled()) {
                waitForClick(dsL.getDsSubmitReasonCTA()).click();
            }
        } catch (RuntimeException e) {
            WebElement stopInSec = waitForVisibility(dsL.getStopSavingCTAissuesSec());
            if (stopInSec != null) {
                stopInSec.click();
            }
            log.info("Submit CTA in the reason selection is not clickable");
            return;
        }
        try {
            waitForVisibility(dsL.getDsStopSavingCTA()).click();
            log.info("Clicked on Stop saving after selecting the reason");
            waitForVisibility(dsL.getDsStopSavingCTA()).click();
        } catch (RuntimeException e) {
            log.info("Stop saving CTA after selecting the reason is not displaying");
            return;
        }

        try {
            waitForVisibility(dsL.getDs_StopPermanentlyRedioButtom()).click();
            waitForClick(dsL.getDsStopSavingCTA()).click();
        } catch (Exception e) {
            log.info("Stop Permanently Radio Button is not clickable");
            return;
        }
        try {
            WebElement goT = waitForVisibility(dsL.getGoToHomeCTA());
            if (goT != null) {
                goT.click();
            }
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
            WebElement increase = waitForVisibility(dsL.getUpdateMandateCta());
            if (increase.isEnabled()) {
                increase.click();
            }
        } catch (Exception e) {
            log.info("Increase CTA is disabled");
        }
        try {
            String apText = waitForVisibility(dsL.getAutomaticStepUpBottomSheet()).getText();
            log.info("User got Automatic Step-Up bottom sheet");
            if (apText.equalsIgnoreCase("Automatic Step-Up")) {
                waitForClick(dsL.getProceedWithOutStepUpRedioButton()).click();
                waitForVisibility(dsL.getProceedWithOutStepUpRedioButton()).click();
            }
        } catch (Exception e) {
            log.info("Auto step up bottom sheet has not opened");
        }
        try {
            payment.completePhonePePayment();
        } catch (Exception e) {
            log.info("PhonePe bottom sheet has not opened");
        }
        try {
            WebElement lockerCTA = waitForVisibility(dsL.getGoToLockerCTA());
            if (lockerCTA.isDisplayed()) {
                lockerCTA.click();
                driver.navigate().back();
            }
        } catch (TimeoutException e) {
            log.info("Locker CTA not visible, going to home");
            waitForVisibility(dsL.getOrdrSucessGoToHomeCTA()).click();
        }
    }

    public void autoStepup() {
        try {
            String apText = waitForVisibility(dsL.getAutomaticStepUpBottomSheet()).getText();
            log.info("User got Automatic Step-Up bottom sheet");
            if (apText.equalsIgnoreCase("Automatic Step-Up")) {
                waitForClick(dsL.getWithStepUpRedioButton()).click();
                waitForVisibility(dsL.getActivateStepUpCTA()).click();
            }
        } catch (Exception e) {
            log.info("User is not eligible for Auto step up bottom sheet");
        }
    }
}