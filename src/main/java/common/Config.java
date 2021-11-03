package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {


    public static String PLATFORM_AND_BROWSER;

    static {
        try {
            PLATFORM_AND_BROWSER = getPlatformAndBrowser();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String getPlatformAndBrowser() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("src/main/java/common/properties");
        properties.load(fileInputStream);
        String browser = properties.getProperty("BROWSER");
        return browser;
    }


    public static final Boolean CLEAR_COOKIES_AND_STORAGE = true;
    public static final Boolean HOLD_BROWSER_OPEN = true;
}
