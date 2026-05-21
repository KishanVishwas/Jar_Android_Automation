package locaters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Data
public class PaymentLocators {
    private AppiumDriver driver;

    public PaymentLocators(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.phonepe.simulator:id/pay_button")
    private WebElement phonePayButton;

    @AndroidFindBy(id = "com.phonepe.simulator:id/merchant_name")
    private WebElement merchantBottomSheet;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.phonepe.simulator:id/done\"]")
    private WebElement pinCompleted;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Go To Home\")")
    private WebElement goToHomeCTA;
}