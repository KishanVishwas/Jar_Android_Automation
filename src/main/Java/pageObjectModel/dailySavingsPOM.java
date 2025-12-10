package pageObjectModel;

import io.appium.java_client.android.AndroidDriver;
import locaters.elementLocators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import static basePackage.driverFactory.driver;
import static basePackage.driverFactory.wait;
import static utilsPackage.waitUtils.*;

@Slf4j
public class dailySavingsPOM {
    elementLocators loc = new elementLocators(driver);

    public void setupDailySaving() {
        waitForVisibility(loc.getProfileIcon()).click();
        scrollUntilElementFound(driver, loc.getDsInProfile());
        try {
            waitForVisibility(loc.getDsInProfile()).click();
        } catch (Exception e) {
            log.info("Daily savings option CTA is not clickable");
        }
        WebElement dstextArea = waitForVisibility(loc.getDsAmountArea());
        dstextArea.clear();
        dstextArea.sendKeys("200");
        waitForClick(loc.getSetupDsCTA()).click();
        WebElement proceedCTA = waitForVisibility(loc.getProceedForPaymentCTA());
        if (proceedCTA.isEnabled()) {
            proceedCTA.click();
        }
        waitForVisibility(loc.getPhonePayPaymentButton()).click();
        waitForClick(loc.getPinCompleted()).click();
        waitForVisibility(loc.getGoToHomeCTA()).click();
    }
    public void stopDailySaving() {
        waitForClick(loc.getProfileIcon()).click();
        try{
            scrollUntilElementFound(driver, loc.getDsInProfile());;
            waitForVisibility(loc.getDsInProfile()).click();
            try{
                waitForVisibility(loc.getDsActiveStatus());
                log.info("Daily saving is active ");
            }
            catch (NoSuchElementException e){
                log.info("Daily saving is not active ");
            }
        }
        catch (RuntimeException e){
            log.info("Daily saving is not visable  in hamberger");
            return;
        }

        try{
            scrollUntilElementFound(driver,loc.getDsManageSavingropDown());
            waitForVisibility(loc.getDsManageSavingropDown()).click();
            waitForVisibility(loc.getDsStopCTA()).click();
        }
        catch (RuntimeException e){
            log.info("Manage Saving Drop Down CTA is not visable");
            return;
        }
        try{
            waitForVisibility(loc.getDsStopSavingCTAFormVideo()).click();
            log.info("Form video is  getting played");
        }
        catch (RuntimeException e){
            log.info("Form video is not getting played");
        }
        try{
            WebElement reason = waitForVisibility(loc.getDsDontWantToSaveAnymoreRedioButtonCTA());
            if(reason.isDisplayed() && reason.isEnabled()){
                waitForClick(reason).click();
            }
            log.info("Don't Want To Save Any more reason is  selected");
        }
        catch (RuntimeException e){
            log.info("Don't Want To Save Any more reason is not displaying in the screen ");
            return;
        }
        try{
            WebElement submit = waitForClick(loc.getDsSubmitReasonCTA());
            if(submit.isEnabled()){
                waitForClick(loc.getDsSubmitReasonCTA()).click();
            }
        }
        catch (RuntimeException e){
            log.info("Submit CTA in the reason selection is not clickable");
            return;
        }
        try{
            waitForVisibility(loc.getDsStopSavingCTA()).click();
            log.info("Clicked on Stop saving after selecting the reason");
        }
        catch (RuntimeException e){
            log.info("Stop saving CTA after selecting the reason is not displaying");
            return;
        }
        try {
            waitForVisibility(loc.getDs_StopPermanentlyRedioButtom()).click();
            waitForClick(loc.getDsStopSavingCTA()).click();
        }
        catch (Exception e){
            log.info("Stop Permanently Radio Button is not clickable ");
            return;
        }
        try{
            waitForVisibility(loc.getGoToHomeCTA()).click();
            log.info("Clicked on Go to home CTA");
        }
        catch (Exception e){
            log.info("Go to home CTA is not visible");
        }
    }

}
