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

    public void instantSaveFlow() {
        instantSaveScreen();
        amountEntering();
        buyGoldAsZomatoAndNonZomato();
    }

    void instantSaveScreen() {
        try {
            WebElement instantSave = waitForVisibility(buyG.getSaveInstantlyCTA());
            log.info("Fetched the Instant save CTA in the locker");
            instantSave.click();
        } catch (TimeoutException e) {
            try {
                WebElement profile1 = waitForVisibility(buyG.getProfileIcon());
                WebElement profile2 = waitForVisibility(buyG.getProfileIcon2());
                log.info("Instant save CTA not in locker, redirecting from profile");
                if (profile1.isEnabled()) {
                    profile1.click();
                } else if (profile2.isEnabled()) {
                    profile2.click();
                }
                waitForVisibility(buyG.getInstantSaveInProfile()).click();
            } catch (Exception e1) {
                driver.navigate().back();
                log.info("Redirected to HomeScreen");
                takeScreenShot(driver, "instant_save_screen");
            }
        }
    }

    void amountEntering() {
        try {
            waitForVisibility(buyG.getSaveInGoldTitle());
            log.info("Redirected to buy gold screen");
            WebElement amountEnter = waitForClick(buyG.getAmountInputArea());
            amountEnter.clear();
            amountEnter.sendKeys("10");
            log.info("Amount entered");
            WebElement payCta = waitForVisibility(buyG.getPayNowCTA());
            if (payCta != null) {
                payCta.click();
                log.info("Clicked Pay CTA");
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

    void buyGoldAsZomatoAndNonZomato() {
        try {
            waitForClick(buyG.getPhnPeSimulator()).click();
            log.info("Clicked PhonePe simulator");
            try {
                WebElement merchant = waitForVisibility(buyG.getPhonePayMerchantBottomSheet());
                if (merchant.isDisplayed()) {
                    waitForVisibility(buyG.getPayCTAphonepeSimulatorBottomsheet()).click();
                    waitForClick(ds.getPinCompleted()).click();
                }
            } catch (Exception e) {
                log.info("PhonePe Simulator bottom sheet not displayed");
            }
            WebElement goToHome = waitForVisibility(buyG.getGoToHomePageCTA());
            if (goToHome != null) {
                goToHome.click();
            }
        } catch (TimeoutException e) {
            log.info("Payment listing not shown, retrying PhonePe");
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
                log.info("Order success screen is getting displayed");
            }
        }
    }
}