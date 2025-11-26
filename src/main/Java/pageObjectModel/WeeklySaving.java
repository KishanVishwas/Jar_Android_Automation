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
    elementLocators loe = new elementLocators(driver);

    // elementLocators loc = new elementLocators(driver);
    public void setWeeklySaving(String amount) throws InterruptedException {
        waitForVisibility(loe.getProfileIcon()).click();
        scrollUntilElementFound((AndroidDriver) driver, loe.getWeekly_Saving());
        try {
            waitForVisibility(loe.getWeekly_Saving()).click();
        } catch (Exception e) {
            log.info("Weekly_Saving CTA is not clickable");
        }
        try {
            waitForClick(loe.getWeeklySavingtextField()).click();
            loe.getWeeklySavingtextField().sendKeys(amount);
        } catch (Exception e) {
            log.info("Loding is taking time");
            waitForClick(loe.getWeeklySavingtextField()).click();
            loe.getWeeklySavingtextField().sendKeys(amount);
        }
        waitForClick(loe.getWeeklySavingProceedCTA()).click();
        Thread.sleep(3000);
        //waitForVisibility(loe.getPaymentScreenHeder());
        try {
            waitForClick(loe.getProceedForPaymentCTA()).click();
        } catch (Exception e) {
            log.info("Proceed For Payment CTA is not clickable");
        }
        try {
            waitForVisibility(loe.getPhonePayPaymentButton());
            waitForClick(loe.getPhonePayPaymentButton()).click();
        } catch (Exception e) {
            log.info("Payment bottom sheet is not clickable  ");
        }
        // waitForClick(loe.getProceedForPaymentCTA()).click();
        waitForClick(loe.getPinCompleted()).click();
        try {
            waitForVisibility(loe.getWSOrderSuccessScreenStatus());
        } catch (TimeoutException e) {
            Thread.sleep(5000);
        }
        waitForClick(loe.getWSOrderSuccessScreen_GoToHomeCTA()).click();
    }

    public void stopWeeklySaving() {
        waitForVisibility(loe.getProfileIcon()).click();
        scrollUntilElementFound((AndroidDriver) driver, loe.getWeekly_Saving());
        if (loe.getWS_Status_in_hamberger().getText().equalsIgnoreCase("ACTIVE")) {
            scrollUntilElementFound(driver, loe.getWeekly_Saving());
            loe.getWeekly_Saving().click();
            try {
                waitForVisibility(loe.getWS_Status_WS_screen());
            } catch (Exception e) {
                log.info("WS Screen is not loaded");
            }
            scrollUntilElementFound(driver, loe.getWS_setupDetailDropDown());
            waitForClick(loe.getWS_setupDetailDropDown()).click();
            try {
                waitForClick(loe.getStopWeeklySavingCTA()).click();
                waitForClick(loe.getWS_SillWantToStopWS()).click();
            } catch (TimeoutException e) {
                log.info("Stop weekly saving CTA is not visible");
            }
            try {
                waitForVisibility(loe.getWS_StopPermanentlyRedioButtom());
                loe.getWS_StopPermanentlyRedioButtom().click();
            } catch (TimeoutException e) {
                log.info("Redio CTA is not clickable");
            }
            try {
                waitForClick(loe.getWS_StopNowCTA()).click();
            } catch (Exception e) {
                log.info("Stop now CTA is not clickable");
            }

            waitForClick(loe.getGoToHomeCTA()).click();

        }

    }
}
