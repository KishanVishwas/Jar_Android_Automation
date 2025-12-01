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
        waitForVisibility(loe.getProfileIcon()).click();
        scrollUntilElementFound((AndroidDriver) driver, loe.getWeekly_Saving());
           // scrollUntilElementFound(driver, loe.getWeekly_Saving());
            loe.getWeekly_Saving().click();
            try {
                waitForVisibility(loe.getWS_Active_Status_screen());
            } catch (Exception e) {
                log.info("WS Screen is not loaded");
            }
            scrollUntilElementFound(driver, loe.getWS_setupDetailDropDown());

            try {
                waitForClick(loe.getWS_setupDetailDropDown()).click();
                waitForClick(loe.getStopWeeklySavingCTA()).click();
                waitForClick(loe.getWS_SillWantToStopWS()).click();
            } catch (TimeoutException e) {
                log.info("Stop weekly saving CTA is not visible");
                return;
            }
            try {
                waitForVisibility(loe.getWS_StopPermanentlyRedioButtom());
                loe.getWS_StopPermanentlyRedioButtom().click();
            }catch (TimeoutException e){
                log.info("Stop Permanently Redio Buttom CTA is not clickable");
                return;
            }
            try {
                waitForClick(loc.getWS_StopNowCTA()).click();
            } catch (Exception e) {
                log.info("Stop now CTA is not clickable");
                return;
            }

           waitForClick(loe.getGoToHomeCTA()).click();
    }
    public void pauseWeeklySaving() {
        waitForVisibility(loe.getProfileIcon()).click();
        scrollUntilElementFound((AndroidDriver) driver, loe.getWeekly_Saving());
        loe.getWeekly_Saving().click();
        try {
            waitForVisibility(loe.getWS_Active_Status_screen());
        } catch (Exception e) {
            System.out.println("WS Screen is not loaded");
        }
        scrollUntilElementFound(driver, loe.getWS_setupDetailDropDown());

        try {
            waitForClick(loe.getWS_setupDetailDropDown()).click();
            waitForClick(loe.getStopWeeklySavingCTA()).click();
            waitForClick(loe.getWS_SillWantToStopWS()).click();
        } catch (TimeoutException e) {
            log.info("Stop weekly saving CTA is not visible");
        }
        try {
            waitForVisibility(loe.getWS_stopFor3WeeksRedioButtom());
            loe.getWS_stopFor3WeeksRedioButtom().click();
        }catch (TimeoutException e){
            log.info("Redio CTA is not clickable");
        }
        try{
            waitForClick(loe.getWS_StopNowCTA()).click();
        }
        catch (Exception e){
            log.info("Stop now CTA is not clickable");
        }
        waitForVisibility(loe.getWeekly_Saving());

    }
    public void ResumeWeeklySaving() {
        waitForVisibility(loe.getProfileIcon()).click();
        scrollUntilElementFound((AndroidDriver) driver, loe.getWeekly_Saving());
        loe.getWeekly_Saving().click();
        try {
            waitForVisibility(loe.getWS_Resume_Status_screen());
        } catch (Exception e) {
            System.out.println("WS Screen is not loaded");
        }
        scrollUntilElementFound(driver, loe.getWS_setupDetailDropDown());
        try{
            waitForClick(loe.getWS_setupDetailDropDown()).click();
            waitForClick(loe.getWS_Resume_Now_CTA()).click();
            log.info("Weekly saving is resume successfully");
        }
        catch (RuntimeException e){
            log.info("Resume now CTA is not click able");
        }
        waitForVisibility(loe.getWS_Active_Status_screen());
        driver.navigate().back();
        driver.navigate().back();
    }


}
