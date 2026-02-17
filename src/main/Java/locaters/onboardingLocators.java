package locaters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Data
public class onboardingLocators {
    private AppiumDriver driver;

    public onboardingLocators(AppiumDriver driver) { // created constructor to access the private variable from locators class
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'English')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"English\"`]")
    private WebElement English;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Choose the app language you prefer.']")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Choose the app language you prefer.\"`]")
    private WebElement languagePageText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Skip']")
    private WebElement skipOnboardingVideo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Use another number\"]")
    private WebElement useOtherNumberCTA;

    @AndroidFindBy(id = "com.google.android.gms:id/cancel")
    private WebElement noneOfTheAbove;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"onboarding_v2_number_input_text_field\")")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"00000 00000\"`]")
    private WebElement phoneNumberTextField;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Send OTP\")")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Send OTP\"`]")
    private WebElement sendOtpCTA;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"onboarding_v2_otp_input_text_field\").instance(0)")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[1]/XCUIElementTypeTextField")
    private WebElement enterOtpTextArea;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id='onboarding_v2_verify_otp_cta']")
    private WebElement verifyOtpCTA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.aso_centric.jar.staging:id/tvLogin']")
    private WebElement welcomeBackText;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Daily Saving']")
    private WebElement dailySavingTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Skip']")
    private WebElement skipInOnboardingDS;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.aso_centric.jar.staging:id/textView\" and @text=\"Cancel\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Cancel\"`]")
    private WebElement cancelDSonboard;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Apply\")")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Apply\"`]")
    private WebElement applyCTA;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Start by entering your phone number\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Start by entering your phone number\"`]")
    private WebElement enterNumberTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Select language\"]")
    private WebElement selectLanguage;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Proceed with English\")")
    private WebElement proceedWithEnglish;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Save in Gold\"]")
    private WebElement saveInGoldTitle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Skip for devs\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Skip for devs\"`]")
    private WebElement skipForDev;

    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View/android.view.View")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"Start your saving journey\"`]")
    private WebElement startSJCTA;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"00000 00000\"`]")
    private WebElement enterNumberArea;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name == \"Skip\"`]")
    private WebElement skipInOnboarding;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeWindow[3]/XCUIElementTypeOther/XCUIElementTypeOther")
    private WebElement done;
}
