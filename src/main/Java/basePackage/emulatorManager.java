package basePackage;

import java.io.IOException;

public class emulatorManager {
    private static Process emulatorProcess;

    public static void openAndroidEmulator(){
        try {
            String emulatorName="Pixel 9 Pro API 35";
            emulatorProcess = Runtime.getRuntime().exec(new String[]{
                    "/bin/bash", "-c", "emulator -avd " + emulatorName
            });
        }
        catch (IOException e){
            throw new RuntimeException("Failed to start Android emulator", e);
        }
    }

    public static void closeAndroidEmulator(){
        try {
            emulatorProcess = Runtime.getRuntime().exec(new String[]{
                    "/bin/bash", "-c", "adb emu kill"
            });
            emulatorProcess.waitFor();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Failed to close Android emulator", e);
        }
    }
}
