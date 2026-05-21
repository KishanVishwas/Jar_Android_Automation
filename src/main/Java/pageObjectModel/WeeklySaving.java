package pageObjectModel;

import locaters.weeklySavingsLocators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import utilsPackage.PaymentHelper;

import static basePackage.driverFactory.driver;
import static utilsPackage.waitUtils.*;

@Slf4j
public class WeeklySaving {

    weeklySavingsLocators wsL = new weeklySavingsLocators(driver);
    PaymentHelper payment = new PaymentHelper();

    public void setWeeklySaving(String amount) {
        waitForVisibility(wsL.getProfileIcon()).click();
        scrollUntilElementFound(driver, wsL.getWeekly_Saving());

        try {
            waitForVisibility(wsL.getWeekly_Saving()).click();
        } catch (Exception e) {
            log.info("Weekly Saving CTA is not clickable");
            return;
        }

        try {
            waitForClick(wsL.getWeeklySavingtextField()).click();
            wsL.getWeeklySavingtextField().clear();
            wsL.getWeeklySavingtextField().sendKeys(amount);
        } catch (Exception e) {
            log.info("Loading is taking time");
            waitForClick(wsL.getWeeklySavingtextField()).click();
            wsL.getWeeklySavingtextField().sendKeys(amount);
        }

        try {
            waitForClick(wsL.getWeeklySavingProceedCTA()).click();
            waitForSeconds(3);
            waitForClick(wsL.getProceedForPaymentCTA()).click();
        } catch (Exception e) {
            log.info("Proceed For Payment CTA is not clickable");
        }

        try {
            payment.completePhonePePayment();
        } catch (Exception e) {
            log.info("Payment app is not clickable");
            return;
        }

        try {
            waitForVisibility(wsL.getWSOrderSuccessScreenStatus());
            log.info("Got Weekly saving order success screen");
        } catch (TimeoutException e) {
            log.info("Weekly saving order success is not getting loaded");
        }

        waitForClick(wsL.getWSOrderSuccessScreen_GoToHomeCTA()).click();
        log.info("User is on the home screen");
    }

    public void stopWeeklySaving() {
        waitForVisibility(wsL.getProfileIcon()).click();
        scrollUntilElementFound(driver, wsL.getWeekly_Saving());
        wsL.getWeekly_Saving().click();

        try {
            waitForVisibility(wsL.getWS_Active_Status_screen());
        } catch (Exception e) {
            log.info("WS screen is not loaded");
        }

        scrollUntilElementFound(driver, wsL.getWS_setupDetailDropDown());

        try {
            waitForClick(wsL.getWS_setupDetailDropDown()).click();
            waitForClick(wsL.getStopWeeklySavingCTA()).click();
            waitForClick(wsL.getWS_SillWantToStopWS()).click();
        } catch (TimeoutException e) {
            log.info("Stop weekly saving CTA is not visible");
            return;
        }

        try {
            waitForVisibility(wsL.getWS_StopPermanentlyRedioButtom());
            wsL.getWS_StopPermanentlyRedioButtom().click();
        } catch (TimeoutException e) {
            log.info("Stop Permanently Radio Button CTA is not clickable");
            return;
        }

        try {
            waitForClick(wsL.getWS_StopNowCTA()).click();
        } catch (Exception e) {
            log.info("Stop now CTA is not clickable");
            return;
        }

        waitForClick(wsL.getGoToHomeCTA()).click();
    }

    public void pauseWeeklySaving() {
        waitForVisibility(wsL.getProfileIcon()).click();
        scrollUntilElementFound(driver, wsL.getWeekly_Saving());
        wsL.getWeekly_Saving().click();

        try {
            waitForVisibility(wsL.getWS_Active_Status_screen());
        } catch (Exception e) {
            log.info("WS screen is not loaded");
        }

        scrollUntilElementFound(driver, wsL.getWS_setupDetailDropDown());

        try {
            waitForClick(wsL.getWS_setupDetailDropDown()).click();
            waitForClick(wsL.getStopWeeklySavingCTA()).click();
            waitForClick(wsL.getWS_SillWantToStopWS()).click();
        } catch (TimeoutException e) {
            log.info("Stop weekly saving CTA is not visible");
        }

        try {
            waitForVisibility(wsL.getWS_stopFor3WeeksRedioButtom());
            wsL.getWS_stopFor3WeeksRedioButtom().click();
        } catch (TimeoutException e) {
            log.info("Radio CTA is not clickable");
        }

        try {
            waitForClick(wsL.getWS_StopNowCTA()).click();
        } catch (Exception e) {
            log.info("Stop now CTA is not clickable");
        }

        waitForVisibility(wsL.getWeekly_Saving());
        driver.navigate().back();
    }

    public void resumeWeeklySaving() {
        waitForVisibility(wsL.getProfileIcon()).click();
        scrollUntilElementFound(driver, wsL.getWeekly_Saving());
        wsL.getWeekly_Saving().click();

        try {
            waitForVisibility(wsL.getWS_Resume_Status_screen());
        } catch (Exception e) {
            log.info("WS screen is not loaded");
        }

        scrollUntilElementFound(driver, wsL.getWS_setupDetailDropDown());

        try {
            waitForClick(wsL.getWS_setupDetailDropDown()).click();
            waitForClick(wsL.getWS_Resume_Now_CTA()).click();
            log.info("Weekly saving is resumed successfully");
        } catch (RuntimeException e) {
            log.info("Resume now CTA is not clickable");
        }

        waitForVisibility(wsL.getWS_Active_Status_screen());
        driver.navigate().back();
        driver.navigate().back();
    }
}