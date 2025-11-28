package pageObjectModel;

import locaters.elementLocators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import static basePackage.actions.takeScreenShot;
import static basePackage.driverFactory.driver;
import static basePackage.driverFactory.wait;
import static utilsPackage.waitUtils.waitForClick;
import static utilsPackage.waitUtils.waitForVisibility;

@Slf4j
public class buyGoldFromFloatingCTA {

    elementLocators loc = new elementLocators(driver);

    public void instantSaveScreen() {
        try {
            WebElement instantSave = waitForVisibility(loc.getSaveInstantlyCTA());
            instantSave.click();

        } catch (TimeoutException e) {
            try {
                waitForVisibility(loc.getProfileIcon()).click();
                waitForVisibility(loc.getInstantSaveInProfile()).click();
            }catch (Exception e1){
            waitForVisibility(loc.getHomeTab());
            log.info("HomeScreen Redirected");
            takeScreenShot(driver, "instant_save_screen");}
        }
    }
    public void amountEntering() {
        try {
            waitForVisibility(loc.getAvailableOfferTitle());
            WebElement amountEnter = waitForClick(loc.getAmountInputArea());
            amountEnter.clear();
            amountEnter.sendKeys("100");
            WebElement payCta = waitForVisibility(loc.getPayNowCTA());
            if (payCta.isEnabled()) {
                payCta.click();
            }
        } catch (TimeoutException e) {
            WebElement payCta = waitForVisibility(loc.getPayNowCTA());
            if (payCta.isEnabled()) {
                payCta.click();
            }
            waitForClick(loc.getPayNowCTAinBS()).click();
        }
    }
    public void buyGoldAsZomatoAndNonZomato(){
        try {
            WebElement phnPe=waitForVisibility(loc.getPhnPeSimulator());
            if (phnPe.isDisplayed()){
                phnPe.click();
            }
            WebElement goToHome=waitForVisibility(loc.getGoToHomeCTA());
            if (goToHome.isDisplayed()){
                goToHome.click();
            }
        }catch (TimeoutException e){
            log.info("user has not redirect to payment listing and Go to Homepage cta is not displaying");
        }
    }
}