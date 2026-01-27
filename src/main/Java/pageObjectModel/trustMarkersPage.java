package pageObjectModel;

import locaters.trustMarkersLocators;
import org.openqa.selenium.WebElement;

import static basePackage.driverFactory.driver;
import static utilsPackage.waitUtils.*;

public class trustMarkersPage {
    trustMarkersLocators tmL = new trustMarkersLocators(driver);

    public void kycCompletion() {
        WebElement flow = waitForVisibility(tmL.getFlowCompleted());
        if (flow.isDisplayed()) {
            scrollUntilElementFound(driver, tmL.getHeaderToScroll());
            waitForClick(tmL.getFlowArrow()).click();
        } else {
            scrollUntilElementFound(driver, tmL.getHeaderToScroll());
            waitForClick(tmL.getNudge()).click();
            waitForClick(tmL.getFlowArrow()).click();
        }
        waitForVisibility(tmL.getEditPan()).sendKeys("FOKPR6232A");
        waitForVisibility(tmL.getEditText1()).sendKeys("27");
        waitForVisibility(tmL.getEditText2()).sendKeys("07");
        waitForVisibility(tmL.getEditText3()).sendKeys("2000");
        waitForClick(tmL.getVerifyPan()).click();



    }
}
