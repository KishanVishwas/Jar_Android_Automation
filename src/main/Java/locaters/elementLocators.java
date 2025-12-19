package locaters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Data
public class elementLocators {
    private AppiumDriver driver;

    public elementLocators(AppiumDriver driver) { // created constructor to access the private variable from locators class
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'English')]")
    private WebElement English;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Choose the app language you prefer.']")
    private WebElement languagePageText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Skip']")
    private WebElement skipOnboardingVideo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Use another number\"]")
    private WebElement useOtherNumberCTA;

    @AndroidFindBy(id = "com.google.android.gms:id/cancel")
    private WebElement noneOfTheAbove;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='onboarding_v2_number_input_text_field']")
    private WebElement phoneNumberTextField;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id='onboarding_v2_send_otp_cta']")
    private WebElement sendOtpCTA;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"onboarding_v2_otp_input_text_field\").instance(0)")
    private WebElement enterOtpTextArea;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id='onboarding_v2_verify_otp_cta']")
    private WebElement verifyOtpCTA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.aso_centric.jar.staging:id/tvLogin']")
    private WebElement welcomeBackText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Daily Saving']")
    private WebElement dailySavingTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Skip']")
    private WebElement skipInOnboardingDS;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.jar.app.replica:id/textView\" and @text=\"Cancel\"]")
    private WebElement cancelDSonboard;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Apply\"]")
    private WebElement applyCTA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
    private WebElement homeTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"⚡ Save Instantly\"]")
    private WebElement saveInstantlyCTA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"हिंदी\"]")
    private WebElement Hindi;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Start by entering your phone number\"]")
    private WebElement enterNumberTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Save in Gold\"]")
    private WebElement saveInGoldTitle;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement amountInputArea;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Pay Now\"]")
    private WebElement payNowCTA;

    @AndroidFindBy(accessibility = "profile Icon")
    private WebElement ProfileIcon;

    //  @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Weekly Saving\"]")
    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View[3]/android.view.View[3]/android.view.View")
    private WebElement Weekly_Saving;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Logout\"]")
    private WebElement logoutCTA;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.aso_centric.jar.staging:id/etSipAmount\"]")
    private WebElement WeeklySavingtextField;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.aso_centric.jar.staging:id/btnSetupSip\"]/android.view.ViewGroup")
    private WebElement WeeklySavingProceedCTA;

    @AndroidFindBy(id = "Displayed_DS_Text")
    private WebElement paymentScreenHeder;

    // @AndroidFindBy(xpath = "(//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.aso_centric.jar.staging:id/composeView\"])[6]/android.view.View/android.view.View")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Proceed for Payment\"]")
    private WebElement ProceedForPaymentCTA;

    @AndroidFindBy(xpath = "com.phonepe.simulator:id/merchant_name")
    private WebElement paymentBottomSheet;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id=\"com.phonepe.simulator:id/pay_button\"]")
    private WebElement phonePayPaymentButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.phonepe.simulator:id/done\"]")
    private WebElement PinCompleted;

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

     @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Stop Weekly Savings\"]")
    private WebElement stopWeeklySavingCTA;


     @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"I still want to cancel\"]")
    private WebElement WS_SillWantToStopWS;

     @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Permanently\"]")
    private WebElement WS_StopPermanentlyRedioButtom;

     @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"For 3 weeks\"]")
     private WebElement WS_stopFor3WeeksRedioButtom;

     @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Stop Now\"]")
    private WebElement WS_StopNowCTA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Go To Home\"]")
    private WebElement goToHomeCTA;

    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]")
    private WebElement payNowCTAinBS;

    @AndroidFindBy(id = "//android.widget.TextView[@resource-id=\"com.jar.app.replica:id/tvPaymentType\"]")
    private WebElement phnPeSimulator;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.jar.app.replica:id/btnGoToHome\"]/android.view.ViewGroup")
    private WebElement goToHomePageCTA;

    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View[3]/android.view.View")
    private WebElement instantSaveInProfile;

    @AndroidFindBy(id = "com.aso_centric.jar.staging:id/tvExtraGoldLabel")
    private WebElement availableOfferTitle;

    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View")
    private WebElement startSJCTA;

    @AndroidFindBy(xpath="//android.widget.TextView[normalize-space(@text)='Daily Saving']")
    private WebElement dsInProfile;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement dsAmountArea;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Setup Daily Savings\"]")
    private WebElement setupDsCTA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Proceed for Payment\"]")
    private WebElement proceedForPaymentCTA;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"ACTIVE\"]")
    private WebElement dsLandingStatus;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Manage Savings\"]")
    private WebElement dsManageSavingropDown;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Pause\"]")
    private WebElement dsPauseCTA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Stop\"]")
    private WebElement dsStopCTA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Pause Savings\"]")
    private  WebElement dsPauseSavingBottomScreenCTA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Continue Saving\"]")
    private  WebElement dsContinueSavingBottomScreenCTA;

    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.ImageView")
    private WebElement closePauseBottomScreen;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Stop Saving\"]")
    private WebElement dsStopSavingCTAFormVideo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Continue Saving\"]")
    private WebElement dsContinueSavingCTAFormVideo;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.ImageView[1]")
    private WebElement dsStopFormVideo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Don’t want to save anymore\"]")
    private WebElement dsDontWantToSaveAnymoreRedioButtonCTA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Submit\"]")
    private WebElement dsSubmitReasonCTA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"For 2 weeks\"]")
    private WebElement ds_stopFor2WeeksRedioButtom;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Permanently\"]")
    private WebElement ds_StopPermanentlyRedioButtom;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Stop Saving\"]")
    private WebElement dsStopSavingCTA;
    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"ACTIVE\"])[1]")
    private WebElement dsActiveStatus;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Daily Saving\"]")
    private WebElement dailySavingHamberger;

    @AndroidFindBy(xpath = " //android.widget.TextView[normalize-space(@text)='Update Daily Savings']")
    private WebElement UpdateDailySavingsCTA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.aso_centric.jar.staging:id/textView\"]")
    private WebElement payNowCTAExp1;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Skip for devs\"]")
    private WebElement skipForDev;

    }
