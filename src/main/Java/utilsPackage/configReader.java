package utilsPackage;

import java.io.FileInputStream;
import java.util.Properties;

public class configReader {
    private static final Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("/Users/hkkarthik/IdeaProjects/Jar_Android_Automation/src/main/resources/config.properties");
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

}
