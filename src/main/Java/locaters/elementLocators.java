package locaters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class elementLocators {

    private AppiumDriver driver;

    public elementLocators(AppiumDriver driver) { // created constructor to access the private variable from locators class
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Getter
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='English']")
    private WebElement English;

    @Getter
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Choose the app language you prefer.']")
    private WebElement languagePageText;

    @Getter
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Skip']")
    private WebElement skipOnboardingVideo;

    @Getter
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.aso_centric.jar.staging:id/tvContinueWithDifferentNumber']")
    private WebElement useOtherNumberCTA;

    @Getter
    @AndroidFindBy(id = "com.google.android.gms:id/cancel")
    private WebElement noneOfTheAbove;

    @Getter
    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='onboarding_v2_number_input_text_field']")
    private WebElement phoneNumberTextField;

    @Getter
    @AndroidFindBy(xpath = "//android.view.View[@resource-id='onboarding_v2_send_otp_cta']")
    private WebElement sendOtpCTA;

    @Getter
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"onboarding_v2_otp_input_text_field\").instance(0)")
    private WebElement enterOtpTextArea;

    @Getter
    @AndroidFindBy(xpath = "//android.view.View[@resource-id='onboarding_v2_verify_otp_cta']")
    private WebElement verifyOtpCTA;

    @Getter
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.aso_centric.jar.staging:id/tvLogin']")
    private WebElement welcomeBackText;

    @Getter
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Daily Saving']")
    private WebElement dailySavingTitle;

    @Getter
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Skip']")
    private WebElement skipInOnboardingDS;

    @Getter
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.aso_centric.jar.staging:id/btnLater']/android.view.ViewGroup")
    private WebElement cancelDSonboard;

    @Getter
    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View[2]")
    private WebElement applyCTA;

    @Getter
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
    private WebElement homeTab;

    @Getter
    @AndroidFindBy(xpath = "(//androidx.compose.ui.platform.ComposeView[@resource-id='com.aso_centric.jar.staging:id/composeView'])[1]/android.view.View/android.view.View/android.view.View[5]/android.view.View[1]/android.view.View/android.view.View/android.view.View[5]")
    private WebElement saveInstantlyCTA;

}
