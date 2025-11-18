package pageObjectModel;

import io.appium.java_client.AppiumBy;

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

        waitForVisibility(loc.getLanguagePageText());
        WebElement english = loc.getEnglish();
        if (english.isDisplayed()) {
            english.click();
        }

        waitForClick(loc.getApplyCTA()).click();
    }

    public void onboardingVideo() {
        waitForClick(loc.getSkipOnboardingVideo()).click();
        waitForClick(loc.getUseOtherNumberCTA()).click();
        waitForClick(loc.getNoneOfTheAbove()).click();
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