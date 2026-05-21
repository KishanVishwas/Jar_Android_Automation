import basePackage.driverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.weeklyMagicPage;

public class weeklyMagicFlow {

    @Test
    public void weeklyMagic() {
        weeklyMagicPage we = new weeklyMagicPage();
        we.weeklyMagicSetup();
        Assert.assertNotNull(driverFactory.driver, "Driver session lost after weekly magic flow");
    }
}