package pageObjectModel;

import io.appium.java_client.android.AndroidDriver;
import locaters.spinToWinLocators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

import static basePackage.actions.takeScreenShot;
import static utilsPackage.waitUtils.*;
import static basePackage.driverFactory.driver;

@Slf4j
public class spinToWinPage {

    spinToWinLocators sp = new spinToWinLocators(driver);

    public void jackpotFlow() {

        try {
            // Scroll to Spin to Win section
            scrollUntilElementFound(driver, sp.getTitleSpinToWin());
            scrollUntilElementFound(driver, sp.getNekCollectionsHeader());

            if (sp.getSpinImage().isDisplayed()) {
                waitForClick(sp.getArrowCta()).click();
            }
            waitForVisibility(sp.getSpinToWinBanner());
            // Scroll dropdown twice
            scrollTillEndOfSection(sp.getActiveDropDownPoint());
            waitForSeconds(2);
            scrollTillEndOfSection(sp.getActiveDropDownPoint());

            // Back from spins
            waitForClick(sp.getBackButtoninSpins()).click();

            // Handle Use Winnings flow
            handleUseWinningsCTA();

        } catch (Exception e) {
            log.error("Exception in jackpotFlow", e);
            handleUseWinningsCTA();
        }
    }

    private void handleUseWinningsCTA() {

        WebElement cta = null;

        try {
            cta = waitForVisibility(sp.getUseWinningsCta());
        } catch (Exception e) {
            log.info("Use Winnings CTA not found, scrolling up");
            for (int i = 0; i < 2; i++) {
                scrollUp((AndroidDriver) driver);
            }
        }

        if (cta != null && cta.isDisplayed()
                && "Use Winnings".equalsIgnoreCase(cta.getText())) {

            log.info("Clicking Use Winnings CTA");
            cta.click();

            waitForVisibility(sp.getInstantSavingHeader());
            waitForClick(sp.getBackNavigate()).click();
//            waitForSeconds(2);

//            try {
//                if (sp.getCrossOptionInInstantsave().isDisplayed()) {
//                    waitForClick(sp.getCrossOptionInInstantsave()).click();
//                }
//                else {
//                    log.info("Clicking Cross Option In Instantsave");
//                }
//            } catch (Exception e) {
//                log.info("Cross option not visible in Instant Save");
//            }

        } else {
            log.info("Use Winnings CTA not visible or text mismatch");
            takeScreenShot(driver, "HomeScreen");
        }
    }
}
