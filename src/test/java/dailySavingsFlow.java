import basePackage.driverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.dailySavingsPOM;

public class dailySavingsFlow {

    @Test(dependsOnMethods = "LoginFlow.onboardingVideoScreenFlow")
    public void dailySavings() {
        dailySavingsPOM ds = new dailySavingsPOM();
        ds.stopDailySaving();
        Assert.assertNotNull(driverFactory.driver, "Driver session lost after daily savings flow");
    }
}