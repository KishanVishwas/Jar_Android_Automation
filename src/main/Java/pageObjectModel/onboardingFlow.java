package pageObjectModel;

import static basePackage.actions.takeScreenShot;
import static basePackage.driverFactory.driver;
import static utilsPackage.waitUtils.*;

import locaters.elementLocators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

@Slf4j
public class onboardingFlow {

    elementLocators loc = new elementLocators(driver);

    public void langaugeSelection() {

        try {
            waitForVisibility(loc.getLanguagePageText());
            WebElement english = loc.getEnglish();
            if (english.isDisplayed()) {
                english.click();
                log.info("English found and selecting");
            }
        } catch (NoSuchElementException e) {
            log.info("English not found , selecting Hindi langauge");
            WebElement hindi = loc.getHindi();
            if (hindi.isDisplayed()) {
                hindi.click();
            }
        }
        try {
            WebElement applyCta = waitForClick(loc.getApplyCTA());
            if (applyCta.isDisplayed()) {
                applyCta.click();
                log.info("Apply cta found and clicked");
            }
        } catch (NoSuchElementException e) {
            log.info("Apply cta not found");
        }
        waitForClick(loc.getApplyCTA()).click();
    }

    public void onboardingVideo() {
        waitForClick(loc.getSkipOnboardingVideo()).click();

        try {
            WebElement useAnother = waitForVisibility(loc.getUseOtherNumberCTA());
            if (useAnother.isDisplayed()) {
                useAnother.click();
            }
        } catch (TimeoutException e) {
            waitForVisibility(loc.getEnterNumberTitle());
            log.info("Got directly Enter number screen without preffered numbers");
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

    public void userLogin(String number, String OTP) {

        WebElement phnArea = waitForVisibility(loc.getPhoneNumberTextField());
        phnArea.sendKeys(number);

        waitForClick(loc.getSendOtpCTA()).click();

        waitForVisibility(loc.getEnterOtpTextArea()).sendKeys(OTP);

        waitForClick(loc.getVerifyOtpCTA()).click();
    }

    public void userRedirectiontoHome() {

        try {
            WebElement dsTitle = waitForVisibility(loc.getDailySavingTitle());
            if (dsTitle.isDisplayed()) {
                waitForClick(loc.getSkipInOnboardingDS()).click();
                waitForClick(loc.getCancelDSonboard()).click();
            }
        } catch (TimeoutException e) {
            waitForVisibility(loc.getHomeTab());
            takeScreenShot(driver, "homeScreen_notRedirecting");
        }
    }
}