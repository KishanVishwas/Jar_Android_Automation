package locaters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
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

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='English']")
    private WebElement English;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Choose the app language you prefer.']")
    private WebElement languagePageText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Skip']")
    private WebElement skipOnboardingVideo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.aso_centric.jar.staging:id/tvContinueWithDifferentNumber']")
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

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.aso_centric.jar.staging:id/btnLater']/android.view.ViewGroup")
    private WebElement cancelDSonboard;

    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View[2]")
    private WebElement applyCTA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
    private WebElement homeTab;

    @AndroidFindBy(xpath = "(//androidx.compose.ui.platform.ComposeView[@resource-id='com.aso_centric.jar.staging:id/composeView'])[1]/android.view.View/android.view.View/android.view.View[5]/android.view.View[1]/android.view.View/android.view.View/android.view.View[5]")
    private WebElement saveInstantlyCTA;
}
