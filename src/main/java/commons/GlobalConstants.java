package commons;

import java.io.File;

public class GlobalConstants {

    /* ================= SYSTEM INFO ================= */

    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String JAVA_VERSION = System.getProperty("java.version");

    /* ================= ENVIRONMENT ================= */

    public static final String ENV = System.getProperty("env", "dev");
    public static final String BASE_URL = ConfigReader.getBaseUrl();

    /* ================= TIMEOUT ================= */

    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 15;
    public static final long RETRY_INTERVAL = 500;

    /* ================= BROWSER CONFIG ================= */

    public static final int BROWSER_WIDTH = 1920;
    public static final int BROWSER_HEIGHT = 1080;

    /* ================= PATH ================= */

    public static final String UPLOAD_PATH =
            PROJECT_PATH + File.separator + "uploadFiles" + File.separator;

    public static final String DOWNLOAD_PATH =
            PROJECT_PATH + File.separator + "downloadFiles" + File.separator;

    public static final String SCREENSHOT_PATH =
            PROJECT_PATH + File.separator + "screenshots" + File.separator;

    public static final String REPORT_PATH =
            PROJECT_PATH + File.separator + "reports" + File.separator;

    public static final String LOG_PATH =
            PROJECT_PATH + File.separator + "logs" + File.separator;

    /* ================= TEST DATA ================= */

    public static final String TESTDATA_PATH =
            PROJECT_PATH + File.separator + "testdata" + File.separator;

    /* ================= FRAMEWORK INFO ================= */

    public static final String FRAMEWORK_NAME = "HYBRID TEST AUTOMATION FRAMEWORK";
}
