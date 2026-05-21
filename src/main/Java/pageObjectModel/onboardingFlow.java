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

    public void languageSelection() {
        try {
            waitForVisibility(onB.getLanguagePageText());
            WebElement english = waitForClick(onB.getEnglish());
            english.click();
            log.info("Selecting English language");
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
            WebElement skipInDev = waitForVisibility(onB.getSkipForDev());
            if (skipInDev != null) {
                skipInDev.click();
            }
            WebElement ssjCTA = waitForClick(onB.getStartSJCTA());
            if (ssjCTA.isEnabled()) {
                ssjCTA.click();
            }
        } catch (Exception e) {
            log.info("Skip for dev CTA not needed");
        }
        try {
            WebElement useAnother = waitForVisibility(onB.getUseOtherNumberCTA());
            if (useAnother.isDisplayed()) {
                useAnother.click();
            }
        } catch (TimeoutException e) {
            try {
                waitForVisibility(onB.getEnterNumberTitle());
                waitForVisibility(onB.getPhoneNumberTextField()).click();
            } catch (Exception e2) {
                log.info("Keyboard enabled directly");
            }
            log.info("Got directly to Enter number screen without preferred numbers");
        }
        try {
            WebElement none = waitForVisibility(onB.getNoneOfTheAbove());
            if (none != null) {
                none.click();
            }
        } catch (Exception e) {
            log.info("None Of The Above CTA is not visible");
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
            log.info("User proceeded without clicking verify CTA (auto-verified)");
        }
    }

    public void userRedirectionToHome() {
        try {
            try {
                waitForVisibility(onB.getSaveInGoldTitle());
                driver.navigate().back();
                waitForClick(onB.getCancelDSonboard()).click();
            } catch (Exception e) {
                WebElement sk = waitForVisibility(onB.getSkipInOnboarding());
                if (sk != null) {
                    sk.click();
                }
                waitForClick(onB.getCancelDSonboard()).click();
                log.error("User not able to redirect to the homepage");
            }
        } catch (TimeoutException e) {
            log.info("iOS implementation — no DS onboarding prompt");
        }
    }

    /** @deprecated Use {@link #userRedirectionToHome()} */
    @Deprecated
    public void userRedirectiontoHome() {
        userRedirectionToHome();
    }
}