package locaters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Data;
import org.openqa.selenium.WebElement;

@Data
public class weeklySavingsLocators {
    private AppiumDriver driver;
    public weeklySavingsLocators(AppiumDriver driver){
        this.driver=driver;
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"ACTIVE\"]")
    private WebElement WSOrderSuccessScreenStatus;

    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[4]")
    private WebElement WSOrderSuccessScreen_GoToHomeCTA;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"ACTIVE\"])[2]")
    private WebElement WS_Status_in_hamberger;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Active\"]")
    private WebElement WS_Active_Status_screen;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Resume\"]")
    private WebElement WS_Resume_Status_screen;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Resume Now\"]")
    private WebElement WS_Resume_Now_CTA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Setup details\"]")
    private WebElement WS_setupDetailDropDown;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Proceed for Payment\"]")
    private WebElement ProceedForPaymentCTA;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.phonepe.simulator:id/pay_button\"]")
    private WebElement phonePayPaymentButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Stop Weekly Savings\"]")
    private WebElement stopWeeklySavingCTA;

    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]")
    private WebElement weeklyBoosterBS;

    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View[3]/android.view.View[3]/android.view.View")
    private WebElement Weekly_Saving;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.phonepe.simulator:id/done\"]")
    private WebElement PinCompleted;

    @AndroidFindBy(accessibility = "profile Icon")
    private WebElement ProfileIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"I still want to cancel\"]")
    private WebElement WS_SillWantToStopWS;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Permanently\"]")
    private WebElement WS_StopPermanentlyRedioButtom;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"For 3 weeks\"]")
    private WebElement WS_stopFor3WeeksRedioButtom;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Stop Now\"]")
    private WebElement WS_StopNowCTA;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.aso_centric.jar.staging:id/etSipAmount\"]")
    private WebElement WeeklySavingtextField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.aso_centric.jar.staging:id/btnSetupSip\"]/android.view.ViewGroup")
    private WebElement WeeklySavingProceedCTA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Go To Home\"]")
    private WebElement goToHomeCTA;
}
