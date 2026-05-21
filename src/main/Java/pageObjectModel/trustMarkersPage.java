package pageObjectModel;

import io.appium.java_client.AppiumDriver;
import locaters.trustMarkersLocators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import utilsPackage.configReader;

import static basePackage.driverFactory.driver;
import static utilsPackage.waitUtils.*;

@Slf4j
public class trustMarkersPage {

    trustMarkersLocators tmL = new trustMarkersLocators(driver);

    public void kycCompletion() {
        try {
            WebElement newEntry = waitForVisibility(tmL.getNewHomeTrustMarkersEntry());
            if (newEntry != null) {
                newEntry.click();
                log.info("New trust marker entry found and clicked");
            }
        } catch (TimeoutException e) {
            log.info("New entry not visible. Scrolling to trust marker section...");
            scrollUntilElementFound((AppiumDriver) driver, tmL.getHeaderToScroll());

            if (isFlowCompletedVisible()) {
                log.info("KYC already completed – opening details");
                waitForClick(tmL.getFlowArrow()).click();
            } else {
                log.info("KYC not completed – starting flow via nudge");
                waitForClick(tmL.getNudge()).click();
                waitForClick(tmL.getFlowArrow()).click();
            }
        }
        completePanVerification();
    }

    private boolean isFlowCompletedVisible() {
        try {
            return tmL.getFlowCompleted().isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private void completePanVerification() {
        waitForVisibility(tmL.getEditPan()).sendKeys(configReader.get("testPanNumber"));
        waitForVisibility(tmL.getEditText1()).sendKeys(configReader.get("testDobDay"));
        waitForVisibility(tmL.getEditText2()).sendKeys(configReader.get("testDobMonth"));
        waitForVisibility(tmL.getEditText3()).sendKeys(configReader.get("testDobYear"));
        waitForClick(tmL.getVerifyPan()).click();
        log.info("PAN verification completed");
    }
}