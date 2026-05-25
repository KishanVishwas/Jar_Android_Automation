import basePackage.driverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjectModel.spinToWinPage;

public class spinsJackpot {

    @Test
    public void testSpins() {
        spinToWinPage sj = new spinToWinPage();
        sj.jackpotFlow();
        Assert.assertNotNull(driverFactory.driver, "Driver session lost after spins jackpot flow");
    }
}