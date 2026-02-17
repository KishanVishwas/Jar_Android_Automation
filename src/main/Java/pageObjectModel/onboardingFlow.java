package pageObjectModel;

import static basePackage.driverFactory.driver;
import static utilsPackage.waitUtils.*;

import locaters.onboardingLocators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

@Slf4j
public class onboardingFlow {

    onboardingLocators onB = new onboardingLocators(driver);

    public void langaugeSelection() {
        try {
            waitForVisibility(onB.getLanguagePageText());
            WebElement english = waitForClick(onB.getEnglish());
            english.click();
            log.info("English, selecting English langauge");
            WebElement apply = waitForClick(onB.getApplyCTA());
            apply.click();
        } catch (TimeoutException e) {
            waitForVisibility(onB.getSelectLanguage());
            WebElement pwd = waitForClick(onB.getProceedWithEnglish());
            pwd.click();
        }
    }

    public void onboardingVideo() {
        try {
            WebElement skipinDev = waitForVisibility(onB.getSkipForDev());
            if (skipinDev != null) {
                skipinDev.click();
            }
            WebElement ssjCTA = waitForClick(onB.getStartSJCTA());
            if (ssjCTA.isEnabled()) {
                ssjCTA.click();
            }
        } catch (Exception e) {
            waitForVisibility(onB.getUseOtherNumberCTA());
        }
        try {
            WebElement useAnother = waitForVisibility(onB.getUseOtherNumberCTA());
            if (useAnother.isDisplayed()) {
                useAnother.click();
            }
        } catch (TimeoutException e) {
            waitForVisibility(onB.getEnterNumberTitle());
            WebElement enterArea = waitForVisibility(onB.getEnterNumberArea());
            enterArea.click();
            waitForClick(onB.getDone()).click();

            log.info("Got directly Enter number screen without prefered numbers");
        }
        try {
            WebElement none = waitForVisibility(onB.getNoneOfTheAbove());
            if (none != null) {
                none.click();
            }
        } catch (Exception e) {
            log.info("Non of the Above CTA is not visible");
        }
    }

    public void userLogin(String number, String otp) {

        WebElement phnArea = waitForVisibility(onB.getPhoneNumberTextField());
        phnArea.sendKeys(number);

        waitForClick(onB.getSendOtpCTA()).click();

        waitForVisibility(onB.getEnterOtpTextArea()).sendKeys(otp);

        try {
            waitForClick(onB.getVerifyOtpCTA()).click();
        } catch (Exception e) {
            log.info("user went directly by not clicking CTA");
        }

    }

    public void userRedirectiontoHome() {

        try {
            waitForVisibility(onB.getSaveInGoldTitle());
            driver.navigate().back();
            waitForClick(onB.getCancelDSonboard()).click();
        } catch (TimeoutException e) {
            WebElement sk = waitForVisibility(onB.getSkipInOnboarding());
            if (sk != null) {
                sk.click();
            }
            waitForClick(onB.getCancelDSonboard()).click();
            log.error("User not able to redirect to the homepage");
        }
    }
}
