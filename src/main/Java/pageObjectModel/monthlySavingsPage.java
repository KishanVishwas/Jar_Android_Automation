package pageObjectModel;

import io.appium.java_client.android.AndroidDriver;
import locaters.monthlySavingsLocators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

import static basePackage.driverFactory.driver;
import static utilsPackage.waitUtils.*;

@Slf4j
public class monthlySavingsPage {
    monthlySavingsLocators ml = new monthlySavingsLocators(driver);

    public void monthlySavingsSetupFlow() {
        monthlySavingsRedirection();
        monthlyAmountflow();
    }

    public void monthlySavingsStopFlow() {
        stopRedirection();
        stopMonthFlow();
    }

    private void monthlySavingsRedirection() {
        waitForClick(ml.getProfileIcon()).click();
        log.info("Profile Icon clicked");
        if (ml.getMonthlySavingsEntry() != null) {
            waitForClick(ml.getMonthlySavingsCard()).click();
        } else {
            driver.navigate().back();
            scrollUntilElementFound(driver, ml.getApSavingsEntryPoint());
            waitForClick(ml.getSaveMonthlyEntry()).click();
        }
    }

    private void monthlyAmountflow() {
        WebElement amount = waitForClick(ml.getAmountArea());
        amount.clear();
        amount.sendKeys("200");
        waitForClick(ml.getProceedCTA()).click();
        waitForClick(ml.getProceedForPayment()).click();
        waitForClick(ml.getPayButton()).click();
        waitForClick(ml.getPinCompleted()).click();
    }

    private void stopRedirection() {
        scrollUntilElementFound(driver, ml.getApSavingsEntryPoint());
        scrollDown((AndroidDriver) driver);
        WebElement mAct = waitForVisibility(ml.getApSavingsMonthlyActiveCard());
        WebElement suTi = waitForVisibility(ml.getApMonthSubtitle());
        if (mAct != null || "Creating the future you deserve".equalsIgnoreCase(suTi.toString())) {
            mAct.click();
        }
    }

    private void stopMonthFlow() {
        scrollUntilElementFound(driver, ml.getSetupDetailsDropdown());
        waitForClick(ml.getSetupDetailsView()).click();
        waitForClick(ml.getStopMonthlySavingsEntry()).click();
        waitForClick(ml.getCancelButton()).click();
        waitForClick(ml.getRadioForSelection()).click();
        waitForClick(ml.getStopNowButton()).click();
        waitForClick(ml.getHomeButton()).click();
    }
}
