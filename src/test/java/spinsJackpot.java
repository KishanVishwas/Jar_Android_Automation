import org.testng.annotations.Test;
import pageObjectModel.spinToWinPage;

public class spinsJackpot {

    @Test
    public void testSpins() throws InterruptedException {
        spinToWinPage sj=new spinToWinPage();
        sj.jackpotFlow();
    }
}
