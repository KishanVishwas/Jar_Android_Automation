package pageObjectModel;

import io.appium.java_client.android.AndroidDriver;
import locaters.weeklySavingsLocators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;

import static basePackage.driverFactory.driver;
import static utilsPackage.waitUtils.*;

@Slf4j
public class WeeklySaving {

    weeklySavingsLocators wsL = new weeklySavingsLocators(driver);

    public void setWeeklySaving(String amount) throws InterruptedException {
        waitForVisibility(wsL.getProfileIcon()).click();
        scrollUntilElementFound((AndroidDriver) driver, wsL.getWeekly_Saving());

        try {
            waitForVisibility(wsL.getWeekly_Saving()).click();
        } catch (Exception e) {
            log.info("Weekly_Saving CTA is not clickable");
            return;
        }

        try {
            waitForClick(wsL.getWeeklySavingtextField()).click();
            wsL.getWeeklySavingtextField().clear();
            wsL.getWeeklySavingtextField().sendKeys(amount);
            log.info("amount enter in the WS text field");
        } catch (Exception e) {
            log.info("Loading is taking time");
            waitForClick(wsL.getWeeklySavingtextField()).click();
            wsL.getWeeklySavingtextField().sendKeys(amount);
        }
        try {
            waitForClick(wsL.getWeeklySavingProceedCTA()).click();
            Thread.sleep(3000);
            waitForClick(wsL.getProceedForPaymentCTA()).click();
            log.info("click on the proceed for payment CTA ");
        } catch (Exception e) {
            log.info("Proceed For Payment CTA is not clickable");
        }

        try {
            waitForVisibility(wsL.getPhonePayPaymentButton());
            waitForClick(wsL.getPhonePayPaymentButton()).click();
            waitForClick(wsL.getPinCompleted()).click();
        } catch (Exception e) {
            log.info("Payment app  is not clickable");
            return;
        }

        try {
            waitForVisibility(wsL.getWSOrderSuccessScreenStatus());
            log.info("got Weekly saving order success screen ");
        } catch (TimeoutException e) {
            log.info("Weekly saving order success is not getting loaded");
        }

        waitForClick(wsL.getWSOrderSuccessScreen_GoToHomeCTA()).click();
        log.info("User in the home screen");

    }

    public void stopWeeklySaving() {
        waitForVisibility(wsL.getProfileIcon()).click();
        scrollUntilElementFound((AndroidDriver) driver, wsL.getWeekly_Saving());
        wsL.getWeekly_Saving().click();

        try {
            waitForVisibility(wsL.getWS_Active_Status_screen());
        } catch (Exception e) {
            log.info("WS Screen is not loaded");
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
        scrollUntilElementFound((AndroidDriver) driver, wsL.getWeekly_Saving());
        wsL.getWeekly_Saving().click();

        try {
            waitForVisibility(wsL.getWS_Active_Status_screen());
        } catch (Exception e) {
            log.info("WS Screen is not loaded");
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

    public void ResumeWeeklySaving() {
        waitForVisibility(wsL.getProfileIcon()).click();
        scrollUntilElementFound((AndroidDriver) driver, wsL.getWeekly_Saving());
        wsL.getWeekly_Saving().click();
        try {
            waitForVisibility(wsL.getWS_Resume_Status_screen());

        } catch (Exception e) {
            log.info("WS Screen is not loaded");
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
