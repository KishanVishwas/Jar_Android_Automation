package basePackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class appiumServerManager {
    private static Process appiumProcess;

    public static void startServer(){
        try
        {
            ProcessBuilder builder = new ProcessBuilder("npx", "appium");
            builder.redirectErrorStream(true);
            appiumProcess = builder.start();

            // Read server logs to confirm it's started
            BufferedReader reader = new BufferedReader(new InputStreamReader(appiumProcess.getInputStream()));
            String line;
            boolean started = false;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if (line.contains("Appium REST http interface listener started")) {
                    started = true;
                    break;
                }
            }

            if (started) {
                System.out.println("✅ Appium server started successfully");
            } else {
                throw new RuntimeException("❌ Appium server failed to start");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void stopServer() {
        if (appiumProcess != null && appiumProcess.isAlive()) {
            appiumProcess.destroy();
            System.out.println("Appium server is stopped");
        }
    }
}
