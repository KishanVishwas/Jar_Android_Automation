package locaters;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class elementLocators {

    public static final By English = AppiumBy.xpath("//android.widget.TextView[@text='English']");
    public static final By langaugePageText = AppiumBy.xpath("//android.widget.TextView[@text=\"Choose the app language you prefer.\"]");
    public static final By skipOnboardingvideo = AppiumBy.xpath("//android.widget.TextView[@text='Skip']");
    public static final By useOtherNumberCTA = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.aso_centric.jar.staging:id/tvContinueWithDifferentNumber\"]");
    public static final By nonOfTheAbove = AppiumBy.id("com.google.android.gms:id/cancel");
    public static final By phoneNumberTextField = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"onboarding_v2_number_input_text_field\"]");
    public static final By sendOtpCTA = AppiumBy.xpath("//android.view.View[@resource-id=\"onboarding_v2_send_otp_cta\"]");
    public static final By enterOtpTextArea = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"onboarding_v2_otp_input_text_field\").instance(0)");
    public static final By verifyOtpCTA = AppiumBy.xpath("//android.view.View[@resource-id=\"onboarding_v2_verify_otp_cta\"]");
    public static final By welcomeBackText = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.aso_centric.jar.staging:id/tvLogin\"]");
    public static final By Daily_SAVING_Title = AppiumBy.xpath("//android.widget.TextView[@text=\"Daily Saving\"]");
    public static final By skipInOnboardingDS = AppiumBy.xpath("//android.widget.TextView[@text=\"Skip\"]");
    public static final By cancelDSonboard = AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"com.aso_centric.jar.staging:id/btnLater\"]/android.view.ViewGroup");
    public static final By applyCTA=AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[3]/android.view.View/android.view.View/android.view.View[2]");
    public static final By homeTab=AppiumBy.xpath("//android.widget.TextView[@text=\"Home\"]");
    public static final By saveInstantlyCTA=AppiumBy.xpath("(//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.aso_centric.jar.staging:id/composeView\"])[1]/android.view.View/android.view.View/android.view.View[5]/android.view.View[1]/android.view.View/android.view.View/android.view.View[5]");
}


