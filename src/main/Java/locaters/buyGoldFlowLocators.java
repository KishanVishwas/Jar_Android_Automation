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
        this.driver = this.driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"⚡ Save Instantly\"]")
    private WebElement saveInstantlyCTA;

    @AndroidFindBy(accessibility = "profile Icon")
    private WebElement ProfileIcon;

    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[4]/android.view.View[2]/android.view.View[3]/android.view.View")
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
}
