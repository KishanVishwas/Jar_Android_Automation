package locators;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class onbordingScreen {
    public static final By english = AppiumBy.xpath ("//android.widget.TextView[@text='English']");
    public static final By lengvagePageText =AppiumBy.xpath ("//android.widget.TextView[@text=\"Choose the app language you prefer.\"]");
    public static final By ApplyLangvage =AppiumBy.xpath ("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View");
    public static final By skipOnboardingvideo =AppiumBy.xpath ("//android.widget.TextView[@text='Skip']");
    public static final By startSavingJoueyCTA =AppiumBy.xpath ("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]");
    public static final By useOtherNumberCTA =AppiumBy.xpath ("//android.widget.TextView[@resource-id=\"com.aso_centric.jar.staging:id/tvContinueWithDifferentNumber\"]");

    public static final By useSameNumberCTA =AppiumBy.xpath ("//android.widget.FrameLayout[@resource-id=\"com.aso_centric.jar.staging:id/btnContinue\"]/android.view.ViewGroup");
    public static final By nonOfTheAbove =AppiumBy.id("com.google.android.gms:id/cancel");

    public static final By phoneNumberTextField =AppiumBy.xpath ("//android.widget.EditText");
    public static final By  sendOtpCTA=AppiumBy.xpath ("//android.widget.TextView[@text='Send OTP']");
    public static final By  enterOtpText =AppiumBy.xpath ("//android.widget.TextView[@text='Enter the OTP']");
    public static final By  enterOtp =AppiumBy.xpath ("//android.widget.ScrollView/android.widget.EditText[1]");
    public static final By  verifyOtpCTA =AppiumBy.xpath ("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View");
    public static final By redireactionPageTitle = AppiumBy.id("com.aso_centric.jar.staging:id/tvTitle");
    public static final By skipCTAinRedirection = AppiumBy.id("com.aso_centric.jar.staging:id/tvEnd");
    public static final By  welcomeBackText =AppiumBy.xpath ("//android.widget.TextView[@resource-id=\"com.aso_centric.jar.staging:id/tvLogin\"]");
    public static final By  botttomSheet =AppiumBy.id ("com.aso_centric.jar.staging:id/brandCouponEmptyImage");
    public static final By  cancalBsCTA =AppiumBy.xpath ("//android.widget.FrameLayout[@resource-id=\"com.aso_centric.jar.staging:id/btnLater\"]/android.view.ViewGroup");

}
