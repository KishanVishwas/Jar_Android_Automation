package pageObjectModel;

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
            WebElement english = waitForClick(loc.getEnglish());
            english.click();
            log.info("English, selecting English langauge");
            WebElement apply = waitForClick(loc.getApplyCTA());
            apply.click();
        } catch (TimeoutException e) {
            waitForVisibility(loc.getSelectLanguage());
            WebElement pwd = waitForClick(loc.getProceedWithEnglish());
            pwd.click();
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
            waitForVisibility(loc.getSaveInGoldTitle());
            driver.navigate().back();
            waitForClick(loc.getCancelDSonboard()).click();
        } catch (TimeoutException e) {
            log.error("User redirection to home failed due to timeout", e);
        }
    }
}
