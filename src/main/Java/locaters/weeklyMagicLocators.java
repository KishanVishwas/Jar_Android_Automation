package locaters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Data
public class weeklyMagicLocators {
    private AppiumDriver driver;

    public weeklyMagicLocators(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.View\").instance(5)")
    private WebElement weeklyNotch;

    @AndroidFindBy(accessibility = "profile Icon")
    private WebElement ProfileIcon;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Weekly \n" +
            "Magic\")")
    private WebElement weeklyMagicInProfile;

    @AndroidFindBy(id = "com.aso_centric.jar.staging:id/btnLeftChevron")
    private WebElement btnLeftChevron;

    @AndroidFindBy(id = "com.aso_centric.jar.staging:id/btnRightChevron")
    private WebElement btnRightChevron;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(2)")
    private WebElement leftChevron;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(3)")
    private WebElement rightChevron;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.aso_centric.jar.staging:id/tvCurrentWeekTitle\")")
    private WebElement currentWeekTitle;

    @AndroidFindBy(id = "com.aso_centric.jar.staging:id/btnOnBoarding")
    private WebElement btnOnBoarding;

    @AndroidFindBy(id = "com.aso_centric.jar.staging:id/btnSkip")
    private WebElement btnSkip;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(0)")
    private WebElement backNaviateWeekly;

    @AndroidFindBy(id = "com.aso_centric.jar.staging:id/textView")
    private WebElement getMystryCardCta;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"INSTANT SAVING\")")
    private WebElement instantSaveHeader;

}
