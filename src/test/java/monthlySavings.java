import basePackage.driverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.monthlySavingsPage;

public class monthlySavings {

    @Test
    public void monthlySavingsTest() {
        monthlySavingsPage mS = new monthlySavingsPage();
        mS.monthlySavingsSetupFlow();
        Assert.assertNotNull(driverFactory.driver, "Driver session lost after monthly savings flow");
    }
}