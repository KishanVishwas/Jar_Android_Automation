package utilsPackage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class configReader {

    private static final Properties properties = new Properties();

    static {
        String configFile = "config.properties";
        try (InputStream input = configReader.class.getClassLoader().getResourceAsStream(configFile)) {
            if (input == null) {
                throw new IllegalStateException(
                    "'" + configFile + "' not found on classpath. " +
                    "Ensure it exists under src/main/resources/."
                );
            }
            properties.load(input);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load " + configFile + ": " + e.getMessage(), e);
        }
    }

    public static String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new IllegalArgumentException("Config key '" + key + "' not found in config.properties");
        }
        return value;
    }

    public static String getOrDefault(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}