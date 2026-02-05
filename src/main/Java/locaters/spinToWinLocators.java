package locaters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Data
public class spinToWinLocators {
    private AppiumDriver driver;

    public spinToWinLocators(AppiumDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.aso_centric.jar.staging:id/tvHeader\" and @text=\"Spin to Win\"]")
    private WebElement titleSpinToWin;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.aso_centric.jar.staging:id/tvSpinToWin\"]")
    private WebElement spinToWinBanner;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.aso_centric.jar.staging:id/activeDropDown\")")
    private WebElement activeDropDownPoint;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"back\"]")
    private WebElement backButtoninSpins;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Use Winnings\"]")
    private WebElement useWinningsCta;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"INSTANT SAVING\"]")
    private WebElement instantSavingHeader;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(0)")
    private WebElement backNavigate;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\")")
    private WebElement crossOptionInInstantsave;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
    private WebElement homeTab;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"⚡ Save Instantly\"]")
    private WebElement saveInstantlyCTA;

    @AndroidFindBy(xpath = "(//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.aso_centric.jar.staging:id/composeView\"])[1]/android.view.View/android.view.View/android.view.View[4]/android.widget.ImageView")
    private WebElement nudge;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.aso_centric.jar.staging:id/spinsImage\"]")
    private WebElement spinImage;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.aso_centric.jar.staging:id/cta\"]")
    private WebElement arrowCta;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.aso_centric.jar.staging:id/cardContent\")")
    private WebElement cardContent;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.aso_centric.jar.staging:id/tvHeader\" and @text=\"Nek Collections\"]")
    private WebElement nekCollectionsHeader;


}
