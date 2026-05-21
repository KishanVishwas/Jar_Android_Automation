import basePackage.driverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.WeeklySaving;

public class weeklySavingsFlow {

    @Test(dependsOnMethods = "LoginFlow.onboardingVideoScreenFlow")
    public void weeklySavings() {
        WeeklySaving ws = new WeeklySaving();
        ws.setWeeklySaving("100");
        ws.pauseWeeklySaving();
        ws.resumeWeeklySaving();
        ws.stopWeeklySaving();
        Assert.assertNotNull(driverFactory.driver, "Driver session lost after weekly savings flow");
    }
}