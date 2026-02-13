package locaters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Data
public class monthlySavingsLocators {
    private AppiumDriver driver;

    public monthlySavingsLocators(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"ProfileIcon\")")
    private WebElement ProfileIcon;

    @AndroidFindBy(xpath = "\t\n" +
            "//android.widget.TextView[@text=\"Monthly Saving\"]")
    private WebElement monthlySavingsEntry;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Gold Saving plans\")")
    private WebElement apSavingsEntryPoint;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Save Monthly\"]")
    private WebElement saveMonthlyEntry;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Monthly \n" +
            "Saving\"]/../android.view.View")
    private WebElement monthlySavingsCard;

    @AndroidFindBy(id = "com.aso_centric.jar.staging:id/etSipAmount")
    private WebElement AmountArea;

    @AndroidFindBy(id = "com.aso_centric.jar.staging:id/textView")
    private WebElement proceedCTA;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Proceed for Payment\")")
    private WebElement proceedForPayment;

    @AndroidFindBy(id = "com.phonepe.simulator:id/pay_button")
    private WebElement payButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.phonepe.simulator:id/done\"]")
    private WebElement PinCompleted;

    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Monthly\")")
    private WebElement apSavingsMonthlyActiveCard;

    @AndroidFindBy(uiAutomator ="new UiSelector().text(\"Creating the future you deserve\")")
    private WebElement ApMonthSubtitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Setup details\")")
    private WebElement setupDetailsDropdown;

    @AndroidFindBy(xpath = "//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View[5]/android.view.View/android.widget.ImageView")
    private WebElement setupDetailsView;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Stop Monthly Savings\")")
    private WebElement stopMonthlySavingsEntry;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"I still want to cancel\")")
    private WebElement cancelButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").instance(12)")
    private WebElement radioForSelection;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Stop Now\")")
    private WebElement stopNowButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Go To Home\")")
    private WebElement homeButton;

}
