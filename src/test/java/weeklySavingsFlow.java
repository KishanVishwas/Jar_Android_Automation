import pageObjectModel.WeeklySaving;

public class weeklySavingsFlow {
    public void weeklySavings() throws InterruptedException{
        WeeklySaving WS=new WeeklySaving();
        WS.setWeeklySaving("100");
        WS.stopWeeklySaving();
    }
}
