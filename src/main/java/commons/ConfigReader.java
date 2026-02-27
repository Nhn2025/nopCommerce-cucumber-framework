package commons;

import java.io.InputStream;
import java.util.Properties;

import static java.lang.System.getProperty;

public final class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        String env = getProperty("env", "dev"); // default = dev
        String fileName = "config-" + env + ".properties";

        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream(fileName)) {

            if (input == null) {
                throw new RuntimeException("❌ " + fileName + " not found in classpath");
            }

            properties.load(input);
            System.out.println("🔧 Loaded config: " + fileName);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config file: " + e.getMessage());
        }
    }

    /* ================= CORE GET ================= */

    public static String get(String key) {

        // Ưu tiên System Property (CI/CD override)
        String value = getProperty(key);

        if (value == null) {
            value = properties.getProperty(key);
        }

        if (value == null) {
            throw new RuntimeException("Property '" + key + "' not found");
        }

        return value.trim();
    }

    public static String get(String key, String defaultValue) {
        try {
            return get(key);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /* ================= COMMON KEYS ================= */

    public static String getBaseUrl() {
        return get("baseUrl");
    }

    public static String getBrowser() {
        return get("browser", "chrome");
    }

    public static long getTimeout() {
        return Long.parseLong(get("timeout", "30"));
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(get("headless", "false"));
    }

    public static String getTestDataFile() {
        return get("testdata.file");
    }

}
