package pageObjectModel;

import locaters.elementLocators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import static basePackage.actions.takeScreenShot;
import static basePackage.driverFactory.driver;
import static utilsPackage.waitUtils.waitForClick;
import static utilsPackage.waitUtils.waitForVisibility;

@Slf4j
public class buyGoldFromFloatingCTA {

    elementLocators loc = new elementLocators(driver);

    public void instantSaveScreen() {
        try {
            WebElement instantSave = waitForVisibility(loc.getSaveInstantlyCTA());
            log.info("Fetched the Instant save cta in the locker");
            instantSave.click();
            log.info("Clicked the instant save cta in the locker");

        } catch (TimeoutException e) {
            try {
                waitForVisibility(loc.getProfileIcon()).click();
                log.info("didnt get the instant save cta in locker ,redirecting from the new profile to buy gold");
                waitForVisibility(loc.getInstantSaveInProfile()).click();
                log.info("Clicked the instant save cta in the new profile");
            } catch (Exception e1) {
                waitForVisibility(loc.getHomeTab());
                log.info("HomeScreen Redirected");
                takeScreenShot(driver, "instant_save_screen");
            }
        }
    }

    public void amountEntering() {
        try {
            waitForVisibility(loc.getSaveInGoldTitle());
            log.info("Redirected to buy gold screen and doing another actions");
            WebElement amountEnter = waitForClick(loc.getAmountInputArea());
            amountEnter.clear();
            amountEnter.sendKeys("100");
            WebElement payCta = waitForVisibility(loc.getPayNowCTA());
            if (payCta.isEnabled()) {
                payCta.click();
            }
//            waitForClick(loc.getPayNowCTAinBS()).click();
        } catch (TimeoutException e) {
            WebElement payCta = waitForVisibility(loc.getPayNowCTA());
            if (payCta.isEnabled()) {
                payCta.click();
            }
//            waitForClick(loc.getPayNowCTAinBS()).click();
        }
    }

    public void buyGoldAsZomatoAndNonZomato() {
        try {
            WebElement phnPe = waitForVisibility(loc.getPhnPeSimulator());
            if (phnPe.isDisplayed()) {
                phnPe.click();
            }
            WebElement goToHome = waitForVisibility(loc.getGoToHomePageCTA());
            if (goToHome.isDisplayed()) {
                goToHome.click();
            }
        } catch (TimeoutException e) {
            log.info("user has not redirect to payment listing and Go to Homepage cta is not displaying");
            WebElement simu=waitForVisibility(loc.getPhnPeSimulator());
            if (simu.isEnabled()){
                simu.click();
            }
            WebElement goToHome = waitForVisibility(loc.getGoToHomePageCTA());
            if (goToHome.isDisplayed()) {
                goToHome.click();
            }
        }
    }
}