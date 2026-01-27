package pageObjectModel;

import locaters.spinToWinLocators;
import static utilsPackage.waitUtils.*;
import static basePackage.driverFactory.driver;


public class spinToWinPage {
    spinToWinLocators sp = new spinToWinLocators(driver);

    public void jackpotFlow() {
        scrollUntilElementFound(driver, sp.getTitleSpinToWin());
        waitForClick(sp.getTitleSpinToWin()).click();
        waitForVisibility(sp.getSpinToWinBanner());
        pressAndDragFromElement(sp.getActiveDropDownPoint());
    }
}
