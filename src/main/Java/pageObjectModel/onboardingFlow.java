package pageObjectModel;


import static basePackage.actions.takeScreenShot;
import static basePackage.driverFactory.driver;
import static utilsPackage.waitUtils.*;

import locaters.elementLocators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

@Slf4j
public class onboardingFlow {

    elementLocators loc = new elementLocators(driver);

    public void langaugeSelection() {
        try {
            try {
                WebElement english = waitForClick(loc.getEnglish());
                english.click();
                log.info("English, selecting English langauge");
                waitForClick(loc.getApplyCTA()).click();
            } catch (NoSuchElementException e) {
                WebElement pwd = waitForClick(loc.getProceedWithEnglish());
                pwd.click();
            }
        } catch (Exception e) {
            log.info("OnBoaring video is getting played");
        }
    }

    public void onboardingVideo() {
        try {
            waitForClick(loc.getSkipForDev()).click();
            WebElement ssjCTA = waitForClick(loc.getStartSJCTA());
            if (ssjCTA.isEnabled()) {
                ssjCTA.click();
            }
        } catch (Exception e) {
            waitForVisibility(loc.getUseOtherNumberCTA());
        }
        try {
            WebElement useAnother = waitForVisibility(loc.getUseOtherNumberCTA());
            if (useAnother.isDisplayed()) {
                useAnother.click();
            }
        } catch (TimeoutException e) {
            waitForVisibility(loc.getEnterNumberTitle());
            log.info("Got directly Enter number screen without prefered numbers");
        }
        try {
            WebElement noneOfAbove = waitForClick(loc.getNoneOfTheAbove());
            noneOfAbove.click();
            log.info("got the None of the ABove option and clicking");
        } catch (TimeoutException e) {
            waitForVisibility(loc.getEnterNumberTitle());
            log.info("Got directly Enter number screen without preffered numbers");
        }
    }

    public void userLogin(String number, String otp) {

        WebElement phnArea = waitForVisibility(loc.getPhoneNumberTextField());
        phnArea.sendKeys(number);

        waitForClick(loc.getSendOtpCTA()).click();

        waitForVisibility(loc.getEnterOtpTextArea()).sendKeys(otp);

        waitForClick(loc.getVerifyOtpCTA()).click();
    }

    public void userRedirectiontoHome() {

        try {
            WebElement skip = waitForVisibility(loc.getSkipInInstantSave());
            if (skip.isDisplayed()) {
                skip.click();
                waitForClick(loc.getCancelDSonboard()).click();
            } else {
                driver.navigate().back();    // handled the Instant saving flow as well using back navigation
                waitForClick(loc.getCancelDSonboard()).click();
            }
        } catch (Exception e) {
            WebElement dsTitle = waitForVisibility(loc.getDailySavingTitle());
            if (dsTitle.isDisplayed()) {
                waitForClick(loc.getSkipInOnboardingDS()).click();
                waitForClick(loc.getCancelDSonboard()).click();
            }
        }
    }
}