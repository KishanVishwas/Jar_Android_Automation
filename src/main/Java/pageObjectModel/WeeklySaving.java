package pageObjectModel;


import io.appium.java_client.android.AndroidDriver;
import locaters.elementLocators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.TimeoutException;

import static basePackage.driverFactory.driver;
import static basePackage.driverFactory.wait;
import static utilsPackage.waitUtils.*;

@Slf4j
public class WeeklySaving {
    elementLocators loc = new elementLocators(driver);

    // elementLocators loc = new elementLocators(driver);
    public void setWeeklySaving(String amount) throws InterruptedException {
        waitForVisibility(loc.getProfileIcon()).click();
        scrollUntilElementFound((AndroidDriver) driver, loc.getWeekly_Saving());
        try {
            waitForVisibility(loc.getWeekly_Saving()).click();
        } catch (Exception e) {
            log.info("Weekly_Saving CTA is not clickable");
        }
        try {
            waitForClick(loc.getWeeklySavingtextField()).click();
            loc.getWeeklySavingtextField().sendKeys(amount);
        } catch (Exception e) {
            log.info("Loding is taking time");
            waitForClick(loc.getWeeklySavingtextField()).click();
            loc.getWeeklySavingtextField().sendKeys(amount);
        }
        waitForClick(loc.getWeeklySavingProceedCTA()).click();
        Thread.sleep(3000);
        //waitForVisibility(loc.getPaymentScreenHeder());
        try {
            waitForClick(loc.getProceedForPaymentCTA()).click();
        } catch (Exception e) {
            log.info("Proceed For Payment CTA is not clickable");
        }
        try {
            waitForVisibility(loc.getPhonePayPaymentButton());
            waitForClick(loc.getPhonePayPaymentButton()).click();
        } catch (Exception e) {
            log.info("Payment bottom sheet is not clickable  ");
        }
        // waitForClick(loc.getProceedForPaymentCTA()).click();
        waitForClick(loc.getPinCompleted()).click();
        try {
            waitForVisibility(loc.getWSOrderSuccessScreenStatus());
        } catch (TimeoutException e) {
            Thread.sleep(5000);
        }
        waitForClick(loc.getWSOrderSuccessScreen_GoToHomeCTA()).click();
    }

    public void stopWeeklySaving() {
        waitForVisibility(loc.getProfileIcon()).click();
        scrollUntilElementFound((AndroidDriver) driver, loc.getWeekly_Saving());
        if (loc.getWS_Status_in_hamberger().getText().equalsIgnoreCase("ACTIVE")) {
            scrollUntilElementFound(driver, loc.getWeekly_Saving());
            loc.getWeekly_Saving().click();
            try {
                waitForVisibility(loc.getWS_Status_WS_screen());
            } catch (Exception e) {
                log.info("WS Screen is not loaded");
            }
            scrollUntilElementFound(driver, loc.getWS_setupDetailDropDown());
            waitForClick(loc.getWS_setupDetailDropDown()).click();
            try {
                waitForClick(loc.getStopWeeklySavingCTA()).click();
                waitForClick(loc.getWS_SillWantToStopWS()).click();
            } catch (TimeoutException e) {
                log.info("Stop weekly saving CTA is not visible");
            }
            try {
                waitForVisibility(loc.getWS_StopPermanentlyRedioButtom());
                loc.getWS_StopPermanentlyRedioButtom().click();
            } catch (TimeoutException e) {
                log.info("Redio CTA is not clickable");
            }
            try {
                waitForClick(loc.getWS_StopNowCTA()).click();
            } catch (Exception e) {
                log.info("Stop now CTA is not clickable");
            }

            waitForClick(loc.getGoToHomeCTA()).click();

        }

    }
}
