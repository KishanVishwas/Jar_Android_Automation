import org.testng.annotations.Test;
import pageObjectModel.weeklyMagicPage;

public class weeklyMagicFlow {

    @Test
    public void weeklyMagic(){
        weeklyMagicPage we=new weeklyMagicPage();
        we.weeklyMagicSetup();
    }
}
