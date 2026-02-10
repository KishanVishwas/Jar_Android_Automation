package locaters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Data
public class buyGoldFlowLocators {
    private AppiumDriver driver;
    public buyGoldFlowLocators(AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"⚡ Save Instantly\"]")
    private WebElement saveInstantlyCTA;

    @AndroidFindBy(accessibility = "profile Icon")
    private WebElement ProfileIcon;

    @AndroidFindBy(xpath = "(//android.widget.TextView[contains(@text,\"Instant\")])[1]")
    private WebElement instantSaveInProfile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
    private WebElement homeTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Save in Gold\"]")
    private WebElement saveInGoldTitle;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement amountInputArea;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Pay Now\"]")
    private WebElement payNowCTA;

    @AndroidFindBy(id = "com.aso_centric.jar.staging:id/tvPaymentType")
    private WebElement phnPeSimulator;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.aso_centric.jar.staging:id/textView\" and @text=\"Go To Homepage\"]")
    private WebElement goToHomePageCTA;


    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.aso_centric.jar.staging:id/tvTopLabel\"]")
    private WebElement manualToDSBottomSheet;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.aso_centric.jar.staging:id/tvOneTimeLabel\"]")
    private WebElement instanteSaveRedioBottomSheet;
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.aso_centric.jar.staging:id/textView\"]")
    private WebElement instantSaveBottomCTA;
    @AndroidFindBy(id = "com.phonepe.simulator:id/merchant_name")
    private WebElement phonePayMerchantBottomSheet;
    @AndroidFindBy(id = "com.phonepe.simulator:id/pay_button")
    private WebElement payCTAphonepeSimulatorBottomsheet;



}
