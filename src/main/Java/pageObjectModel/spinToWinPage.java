package pageObjectModel;

import locaters.spinToWinLocators;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

import static basePackage.actions.takeScreenShot;
import static basePackage.driverFactory.wait;
import static utilsPackage.waitUtils.*;
import static basePackage.driverFactory.driver;

@Slf4j
public class spinToWinPage {
    spinToWinLocators sp = new spinToWinLocators(driver);

    public void jackpotFlow() throws InterruptedException {
        scrollUntilElementFound(driver, sp.getTitleSpinToWin());
        waitForClick(sp.getTitleSpinToWin()).click();
        waitForVisibility(sp.getSpinToWinBanner());
        scrollTillEndOfSection(sp.getActiveDropDownPoint());
        Thread.sleep(2000);
        scrollTillEndOfSection(sp.getActiveDropDownPoint());
        waitForClick(sp.getBackButtoninSpins()).click();
        WebElement cta = waitForClick(sp.getUseWinningsCta());
        if (cta.getText().equals("Use Winnings") || cta.isDisplayed()) {
            cta.click();
            waitForVisibility(sp.getInstantSavingHeader());
            waitForClick(sp.getBackNavigate()).click();

            WebElement crsOp = waitForVisibility(sp.getCrossOptionInInstantsave());
            if (crsOp.isDisplayed()) {
                crsOp.click();
            } else {
               takeScreenShot(driver, "Home");
            }
        } else {
            takeScreenShot(driver, "HomeScreen");
        }
    }
}
