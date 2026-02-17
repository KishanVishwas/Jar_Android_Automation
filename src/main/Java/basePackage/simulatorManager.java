package basePackage;

import org.testng.annotations.Test;

import java.io.IOException;

public class simulatorManager {
    public static Process appiumProcess;

    public static void openSimulator(){
        try {
            appiumProcess=Runtime.getRuntime().exec(new String[]
                    {"/bin/bash","-c","open -a simulator"});
            appiumProcess.waitFor();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void closingSimulator(){
        try {
            appiumProcess=Runtime.getRuntime().exec(new String[]{"/bin/bash","-c","xcrun simctl shutdown all"});
            appiumProcess.waitFor();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
