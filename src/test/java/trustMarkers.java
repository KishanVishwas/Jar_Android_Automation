import basePackage.driverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.trustMarkersPage;

public class trustMarkers {

    @Test(description = "Trust markers flow from the HomeScreen")
    public void idVerification() {
        trustMarkersPage trust = new trustMarkersPage();
        trust.kycCompletion();
        Assert.assertNotNull(driverFactory.driver, "Driver session lost after KYC flow");
    }
}