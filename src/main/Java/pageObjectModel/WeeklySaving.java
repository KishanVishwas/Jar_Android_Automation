package pageObjectModel;

import io.appium.java_client.android.AndroidDriver;
import locaters.elementLocators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;

import static basePackage.driverFactory.driver;
import static utilsPackage.waitUtils.*;

@Slf4j
public class WeeklySaving {

    elementLocators loc = new elementLocators(driver);

    public void setWeeklySaving(String amount) throws InterruptedException {
        waitForVisibility(loc.getProfileIcon()).click();
        scrollUntilElementFound((AndroidDriver) driver, loc.getWeekly_Saving());

        try {
            waitForVisibility(loc.getWeekly_Saving()).click();
        } catch (Exception e) {
            log.info("Weekly_Saving CTA is not clickable");
            return;
        }

        try {
            waitForClick(loc.getWeeklySavingtextField()).click();
            loc.getWeeklySavingtextField().clear();
            loc.getWeeklySavingtextField().sendKeys(amount);
            log.info("amount enter in the WS text field");
        } catch (Exception e) {
            log.info("Loading is taking time");
            waitForClick(loc.getWeeklySavingtextField()).click();
            loc.getWeeklySavingtextField().sendKeys(amount);
        }
        try {
            waitForClick(loc.getWeeklySavingProceedCTA()).click();
            Thread.sleep(3000);
            waitForClick(loc.getProceedForPaymentCTA()).click();
            log.info("click on the proceed for payment CTA ");
        } catch (Exception e) {
            log.info("Proceed For Payment CTA is not clickable");
        }

        try {
            waitForVisibility(loc.getPhonePayPaymentButton());
            waitForClick(loc.getPhonePayPaymentButton()).click();
            waitForClick(loc.getPinCompleted()).click();
        } catch (Exception e) {
            log.info("Payment app  is not clickable");
            return;
        }

        try {
            waitForVisibility(loc.getWSOrderSuccessScreenStatus());
            log.info("got Weekly saving order success screen ");
        } catch (TimeoutException e) {
            log.info("Weekly saving order success is not getting loaded");
        }

        waitForClick(loc.getWSOrderSuccessScreen_GoToHomeCTA()).click();
        log.info("User in the home screen");

    }

    public void stopWeeklySaving() {
        waitForVisibility(loc.getProfileIcon()).click();
        scrollUntilElementFound((AndroidDriver) driver, loc.getWeekly_Saving());
        loc.getWeekly_Saving().click();

        try {
            waitForVisibility(loc.getWS_Active_Status_screen());
        } catch (Exception e) {
            log.info("WS Screen is not loaded");
        }

        scrollUntilElementFound(driver, loc.getWS_setupDetailDropDown());

        try {
            waitForClick(loc.getWS_setupDetailDropDown()).click();
            waitForClick(loc.getStopWeeklySavingCTA()).click();
            waitForClick(loc.getWS_SillWantToStopWS()).click();
        } catch (TimeoutException e) {
            log.info("Stop weekly saving CTA is not visible");
            return;
        }

        try {
            waitForVisibility(loc.getWS_StopPermanentlyRedioButtom());
            loc.getWS_StopPermanentlyRedioButtom().click();
        } catch (TimeoutException e) {
            log.info("Stop Permanently Radio Button CTA is not clickable");
            return;
        }

        try {
            waitForClick(loc.getWS_StopNowCTA()).click();
        } catch (Exception e) {
            log.info("Stop now CTA is not clickable");
            return;
        }

        waitForClick(loc.getGoToHomeCTA()).click();
    }

    public void pauseWeeklySaving() {
        waitForVisibility(loc.getProfileIcon()).click();
        scrollUntilElementFound((AndroidDriver) driver, loc.getWeekly_Saving());
        loc.getWeekly_Saving().click();

        try {
            waitForVisibility(loc.getWS_Active_Status_screen());
        } catch (Exception e) {
            log.info("WS Screen is not loaded");
        }

        scrollUntilElementFound(driver, loc.getWS_setupDetailDropDown());

        try {
            waitForClick(loc.getWS_setupDetailDropDown()).click();
            waitForClick(loc.getStopWeeklySavingCTA()).click();
            waitForClick(loc.getWS_SillWantToStopWS()).click();
        } catch (TimeoutException e) {
            log.info("Stop weekly saving CTA is not visible");
        }

        try {
            waitForVisibility(loc.getWS_stopFor3WeeksRedioButtom());
            loc.getWS_stopFor3WeeksRedioButtom().click();
        } catch (TimeoutException e) {
            log.info("Radio CTA is not clickable");
        }

        try {
            waitForClick(loc.getWS_StopNowCTA()).click();
        } catch (Exception e) {
            log.info("Stop now CTA is not clickable");
        }

        waitForVisibility(loc.getWeekly_Saving());
        driver.navigate().back();
    }

    public void ResumeWeeklySaving() {
        waitForVisibility(loc.getProfileIcon()).click();
        scrollUntilElementFound((AndroidDriver) driver, loc.getWeekly_Saving());
        loc.getWeekly_Saving().click();
        try {
            waitForVisibility(loc.getWS_Resume_Status_screen());

        } catch (Exception e) {
            log.info("WS Screen is not loaded");
        }

        scrollUntilElementFound(driver, loc.getWS_setupDetailDropDown());

        try {
            waitForClick(loc.getWS_setupDetailDropDown()).click();
            waitForClick(loc.getWS_Resume_Now_CTA()).click();
            log.info("Weekly saving is resumed successfully");
        } catch (RuntimeException e) {
            log.info("Resume now CTA is not clickable");
        }

        waitForVisibility(loc.getWS_Active_Status_screen());
        driver.navigate().back();
        driver.navigate().back();
    }
}
