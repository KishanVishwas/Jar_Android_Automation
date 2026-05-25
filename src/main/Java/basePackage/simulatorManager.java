package basePackage;

import java.io.IOException;

public class simulatorManager {
    private static Process simulatorProcess;

    public static void openSimulator() {
        try {
            simulatorProcess = Runtime.getRuntime().exec(new String[]{"/bin/bash", "-c", "open -a simulator"});
            simulatorProcess.waitFor();
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Failed to open iOS Simulator", e);
        }
    }

    public static void closingSimulator() {
        try {
            simulatorProcess = Runtime.getRuntime().exec(new String[]{"/bin/bash", "-c", "xcrun simctl shutdown all"});
            simulatorProcess.waitFor();
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Failed to close iOS Simulator", e);
        }
    }
}