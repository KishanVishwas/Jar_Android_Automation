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
            waitForClick(onB.getSkipForDev()).click();
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
            log.info("Got directly Enter number screen without prefered numbers");
        }
        try {
            WebElement none = waitForVisibility(onB.getNoneOfTheAbove());
            if (none.isDisplayed()) ;
            onB.getNoneOfTheAbove().click();
        }
        catch (Exception e){
            log.info("Non of the Above CTA is not visible");
        }
    }

    public void userLogin(String number, String otp) {

        WebElement phnArea = waitForVisibility(onB.getPhoneNumberTextField());
        phnArea.sendKeys(number);

        waitForClick(onB.getSendOtpCTA()).click();

        waitForVisibility(onB.getEnterOtpTextArea()).sendKeys(otp);

        waitForClick(onB.getVerifyOtpCTA()).click();
    }

    public void userRedirectiontoHome() {

        try {
            waitForVisibility(onB.getSaveInGoldTitle());
            driver.navigate().back();
            waitForClick(onB.getCancelDSonboard()).click();
        } catch (TimeoutException e) {
            log.error("User not able to redirect to the homepage");
        }
    }
}
