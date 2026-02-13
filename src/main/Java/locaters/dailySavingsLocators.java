package locaters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Data
public class dailySavingsLocators {
    private AppiumDriver driver;

    public dailySavingsLocators(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"ProfileIcon\")")
    private WebElement ProfileIcon;

    @AndroidFindBy(xpath = "//android.widget.TextView[normalize-space(@text)='Daily Saving']")
    private WebElement dsInProfile;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement dsAmountArea;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Setup Daily Savings\"]")
    private WebElement setupDsCTA;

    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]")
    private WebElement weeklyBoosterBS;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Proceed for Payment\"]")
    private WebElement ProceedForPaymentCTA;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.phonepe.simulator:id/pay_button\"]")
    private WebElement phonePayPaymentButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.phonepe.simulator:id/done\"]")
    private WebElement PinCompleted;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Go To Home\"]")
    private WebElement goToHomeCTA;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"ACTIVE\"])[1]")
    private WebElement dsActiveStatus;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Manage Savings\"]")
    private WebElement dsManageSavingropDown;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Stop\"]")
    private WebElement dsStopCTA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Stop Saving\"]")
    private WebElement dsStopSavingCTAFormVideo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Don’t want to save anymore\"]")
    private WebElement dsDontWantToSaveAnymoreRedioButtonCTA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Submit\"]")
    private WebElement dsSubmitReasonCTA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Stop Saving\"]")
    private WebElement dsStopSavingCTA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Permanently\"]")
    private WebElement ds_StopPermanentlyRedioButtom;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"Update\")]")
    private WebElement dsUpdateProfile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Daily Savings\"]")
    private WebElement  dsUpdateText;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id=\"update_mandate_cta\"]")
    private WebElement updateMandateCta;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Automatic Step-Up\"]")
    private WebElement AutomaticStepUpBottomSheet;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Activate Step-up\"]")
    private WebElement ActivateStepUpCTA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"With Step-Up\"]")
    private WebElement withStepUpRedioButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Without Step-Up\"]")
    private WebElement withOutStepUpRedioButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Proceed without Step-up\"]")
    private WebElement ProceedWithOutStepUpRedioButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Go to Locker\"]")
    private WebElement goToLockerCTA;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.aso_centric.jar.staging:id/btnGoToHomePage\"]/android.view.ViewGroup")
    private WebElement ordrSucessGoToHomeCTA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Issue in withdrawal amount\"]")
    private WebElement issueInWithdrawalAmount;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Stop Saving\"]")
    private WebElement stopSavingCTAissuesSec;


}
