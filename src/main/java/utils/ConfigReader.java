package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file");
        }
    }

    public static String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Key not found in config.properties: " + key);
        }
        return value;
    }

    public static String getUrl() {
        return get("url");
    }

    public static String getPaymentUrl() {
        return get("paymenturl");
    }

    public static String getProductUrl() {
        return get("producturl");
    }

    public static String getBrowser() {
        return get("browser");
    }
}
