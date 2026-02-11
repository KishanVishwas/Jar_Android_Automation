package pageObjectModel;

import locaters.buyGoldFlowLocators;
import locaters.dailySavingsLocators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import static basePackage.actions.takeScreenShot;
import static basePackage.driverFactory.driver;
import static utilsPackage.waitUtils.*;

@Slf4j
public class buyGoldFromFloatingCTA {

    buyGoldFlowLocators buyG = new buyGoldFlowLocators(driver);
    dailySavingsLocators ds = new dailySavingsLocators(driver);

    public void instantSaveScreen() {
        try {
            WebElement instantSave = waitForVisibility(buyG.getSaveInstantlyCTA());
            log.info("Fetched the Instant save cta in the locker");
            instantSave.click();
            log.info("Clicked the instant save cta in the locker");

        } catch (TimeoutException e) {
            try {
                waitForVisibility(buyG.getProfileIcon()).click();
                log.info("didnt get the instant save cta in locker ,redirecting from the new profile to buy gold");
                waitForVisibility(buyG.getInstantSaveInProfile()).click();
                log.info("Clicked the instant save cta in the new profile");
            } catch (Exception e1) {
                waitForVisibility(buyG.getHomeTab());
                log.info("HomeScreen Redirected");
                takeScreenShot(driver, "instant_save_screen");
            }
        }
    }

    public void amountEntering() {
        try {
            waitForVisibility(buyG.getSaveInGoldTitle());
            log.info("Redirected to buy gold screen and doing another actions");
            WebElement amountEnter = waitForClick(buyG.getAmountInputArea());
            amountEnter.clear();
            amountEnter.sendKeys("100");
            WebElement payCta = waitForVisibility(buyG.getPayNowCTA());
            if (payCta != null) {
                payCta.click();
            } else {
                log.info("Pay Now CTA is disable");
            }
            try {
                if (payCta != null) {
                    payCta.click();
                }
            } catch (TimeoutException e) {
                log.info("Pay Now CTA is disable");
            }
            try {
                if (buyG.getManualToDSBottomSheet().isDisplayed()) {
                    waitForVisibility(buyG.getInstanteSaveRedioBottomSheet()).click();
                    if (buyG.getInstantSaveBottomCTA().isEnabled()) {
                        buyG.getInstantSaveBottomCTA().click();
                    }
                }
            } catch (Exception e) {
                log.info("Manual To DS bottom sheet is not displayed");
            }
        } catch (TimeoutException e) {
            log.info("Element is not visible");
        }

    }

    public void buyGoldAsZomatoAndNonZomato() {
        try {
            waitForClick(buyG.getPhnPeSimulator()).click();
            try {
                WebElement merchant = waitForVisibility(buyG.getPhonePayMerchantBottomSheet());
                if (merchant.isDisplayed()) {
                    waitForVisibility(buyG.getPayCTAphonepeSimulatorBottomsheet()).click();
                    waitForClick(ds.getPinCompleted()).click();
                }
            } catch (Exception e) {
                log.info("phonePe Simulator Bottom sheet as not displayed");
            }
            WebElement goToHome = waitForVisibility(buyG.getGoToHomePageCTA());
            if (goToHome.isDisplayed()) {
                goToHome.click();
            }
        } catch (TimeoutException e) {
            log.info("user has not redirect to payment listing and Go to Homepage cta is not displaying");
            WebElement simu = waitForVisibility(buyG.getPhnPeSimulator());
            if (simu.isEnabled()) {
                simu.click();
            }
            try {
                WebElement goToHome = waitForVisibility(buyG.getGoToHomePageCTA());
                if (goToHome.isDisplayed()) {
                    goToHome.click();
                }
            } catch (Exception f) {
                log.info("Order success screen is getting display");
            }
        }
    }
}