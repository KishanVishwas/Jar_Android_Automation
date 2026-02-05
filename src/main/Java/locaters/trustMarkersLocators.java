package locaters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Data
public class trustMarkersLocators {
    private AppiumDriver driver;

    public trustMarkersLocators(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"0/2 COMPLETED\")")
    private WebElement flowCompleted;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").instance(8)")
    private WebElement flowArrow;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(0)")
    private WebElement nudge;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.aso_centric.jar.staging:id/tvHeader\")")
    private WebElement headerToScroll;

    @AndroidFindBy(id = "com.aso_centric.jar.staging:id/etPan")
    private WebElement editPan;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private WebElement editText1;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(2)")
    private WebElement editText2;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(3)")
    private WebElement editText3;

    @AndroidFindBy(id = "com.aso_centric.jar.staging:id/textView")
    private WebElement verifyPan;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"⚡ Save Instantly\"]")
    private WebElement saveInstantlyCTA;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"See Details\")")
    private WebElement detailsCTA;

}
