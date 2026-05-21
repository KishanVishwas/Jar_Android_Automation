package utilsPackage;

import locaters.PaymentLocators;
import lombok.extern.slf4j.Slf4j;

import static basePackage.driverFactory.driver;
import static utilsPackage.waitUtils.*;

@Slf4j
public class PaymentHelper {

    private final PaymentLocators pl;

    public PaymentHelper() {
        this.pl = new PaymentLocators(driver);
    }

    public void completePhonePePayment() {
        waitForVisibility(pl.getPhonePayButton()).click();
        try {
            if (waitForVisibility(pl.getMerchantBottomSheet()).isDisplayed()) {
                waitForVisibility(pl.getPhonePayButton()).click();
            }
        } catch (Exception e) {
            log.info("PhonePe merchant bottom sheet not displayed — proceeding directly to pin");
        }
        waitForClick(pl.getPinCompleted()).click();
        log.info("PhonePe payment completed");
    }

    public void goToHome() {
        try {
            waitForVisibility(pl.getGoToHomeCTA()).click();
            log.info("Navigated to home");
        } catch (Exception e) {
            log.info("Go To Home CTA not visible");
        }
    }
}