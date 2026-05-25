package pageObjectModel;

import io.appium.java_client.android.AndroidDriver;
import locaters.dailySavingsLocators;
import locaters.monthlySavingsLocators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import utilsPackage.PaymentHelper;

import static basePackage.driverFactory.driver;
import static utilsPackage.waitUtils.*;

@Slf4j
public class monthlySavingsPage {
    monthlySavingsLocators ml = new monthlySavingsLocators(driver);
    dailySavingsLocators dsL = new dailySavingsLocators(driver);
    PaymentHelper payment = new PaymentHelper();

    public void monthlySavingsSetupFlow() {
        monthlySavingsRedirection();
        monthlyAmountFlow();
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

    private void monthlyAmountFlow() {
        WebElement amount = waitForClick(ml.getAmountArea());
        amount.clear();
        amount.sendKeys("200");
        waitForClick(ml.getProceedCTA()).click();
        waitForClick(ml.getProceedForPayment()).click();
        payment.completePhonePePayment();
        payment.goToHome();
    }

    private void stopRedirection() {
        waitForClick(ml.getProfileIcon()).click();
        log.info("Profile Icon clicked");
        if (ml.getMonthlySavingsEntry() != null) {
            waitForClick(ml.getMonthlySavingsCard()).click();
        } else {
            scrollUntilElementFound(driver, ml.getApSavingsEntryPoint());
            scrollDown((AndroidDriver) driver);
            WebElement mAct = waitForVisibility(ml.getApSavingsMonthlyActiveCard());
            WebElement suTi = waitForVisibility(ml.getApMonthSubtitle());
            if (mAct != null && "Creating the future you deserve".equalsIgnoreCase(suTi.getText())) {
                mAct.click();
            }
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