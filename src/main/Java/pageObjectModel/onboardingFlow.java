package pageObjectModel;

import io.appium.java_client.AppiumBy;

import static basePackage.actions.closeKeyboard;
import static utilsPackage.waitUtils.*;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.Map;

import static basePackage.driverFactory.driver;
import static locaters.elementLocators.*;
@Slf4j
public class onboardingFlow
{
    public void langaugeSelection() {
        try {
            // Wait for the language screen to load
            waitForPresenceElementLocated(langaugePageText);
            // Try to find and click English
            WebElement english = driver.findElement(English);
            if (english.isDisplayed()) {
                log.info("✅ English is visible. Selecting English...");
                english.click();
            }
        } catch (NoSuchElementException e) {
            log.info("⚠️ English not found. Selecting Hindi instead...");
            try {
                WebElement hindi = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"हिंदी\"]"));
                hindi.click();
                log.info("✅ Hindi selected successfully.");
            } catch (Exception ex) {
                log.info("❌ Hindi also not found!");
            }
        }
        try {
            WebElement applyBtn = waitForElementToBeClickable(applyCTA);
            applyBtn.click();
            log.info("▶️ Clicked Apply button.");
        } catch (Exception ex) {
            log.info("⚠️ Apply button not found or not clickable yet.");
        }
    }

    public void onboardingVideo() {
        try {
            waitForElementToBeClickable(skipOnboardingvideo).click();
            log.info("Onboarding video as played");
        } catch (NoSuchElementException e) {
            log.info("Onboarding video is not playing");
        }
         WebElement wclText=waitForPresenceElementLocated(welcomeBackText);
        if (wclText.isDisplayed()) {
            waitForElementToBeClickable(useOtherNumberCTA).click();
        }
        WebElement NonOfAbove = waitForElementToBeClickable(nonOfTheAbove);
        if (NonOfAbove.isDisplayed()) {
            NonOfAbove.click();
        }
    }

    public void userLogin(String number, String OTP) {
        WebElement phnArea = waitForPresenceElementLocated(phoneNumberTextField);
        phnArea.click();
        phnArea.sendKeys(number);
        waitForElementToBeClickable(sendOtpCTA).click();
        WebElement otpArea = waitForElementToBeClickable(enterOtpTextArea);
        otpArea.sendKeys(OTP);
        waitForElementToBeClickable(verifyOtpCTA).click();
    }

    public void userRedirectiontoHome() {
        try {
            WebElement dsTitle = waitForPresenceElementLocated(Daily_SAVING_Title);
            log.info(dsTitle.getText());
            if (dsTitle.isDisplayed()) {
                waitForElementToBeClickable(skipInOnboardingDS).click();
                waitForElementToBeClickable(cancelDSonboard).click();
            }
        } catch (TimeoutException e) {
            waitForPresenceElementLocated(homeTab);
            log.info("HomeScreen Redirected");
        }
    }
}
