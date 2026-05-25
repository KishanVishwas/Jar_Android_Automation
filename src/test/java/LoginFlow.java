import basePackage.baseSetup;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.onboardingFlow;
import utilsPackage.configReader;

public class LoginFlow extends baseSetup {

    @Test(description = "Onboarding completes and user logs in to their account")
    public void onboardingVideoScreenFlow() {
        onboardingFlow onboard = new onboardingFlow();
        onboard.languageSelection();
        onboard.onboardingVideo();
        onboard.userLogin(
                configReader.get("phoneNumber"),
                configReader.get("otp")
        );
        onboard.userRedirectionToHome();

        Assert.assertNotNull(driver, "Driver session lost after login flow");
        Assert.assertFalse(driver.getPageSource().isEmpty(), "Page source is empty — home screen may not have loaded");
    }
}