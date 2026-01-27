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

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"com.aso_centric.jar.staging:id/tvTitle\"]")
    private WebElement titleSpinToWin;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id=\"com.aso_centric.jar.staging:id/tvSpinToWin\"]")
    private WebElement spinToWinBanner;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"com.aso_centric.jar.staging:id/activeDropContainer\"]")
    private WebElement activeDropDownPoint;


}
