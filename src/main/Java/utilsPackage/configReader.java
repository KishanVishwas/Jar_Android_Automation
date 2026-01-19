package utilsPackage;

import java.io.InputStream;
import java.util.Properties;

public class configReader {

    private static final Properties properties = new Properties();

    static {
        try {
            InputStream input = configReader.class.getClassLoader().getResourceAsStream("config.properties");

            if (input == null) {
                throw new RuntimeException("config.properties not found in resources folder");
            }

            properties.load(input);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}

