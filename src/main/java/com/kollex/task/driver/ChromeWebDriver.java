package com.kollex.task.driver;

public class ChromeWebDriver {

    private static final String DRIVER_PATH_LINUX = "src/main/resources/chromedrivers/linux/chromedriver";
    private static final String DRIVER_PATH_WIN = "src\\main\\resources\\chromedrivers\\win\\chromedriver.exe";
    private static final String DRIVER_PATH_MAC = "src/main/resources/chromedrivers/mac/chromedriver";
    private static final String OS = "os.name";
    private static final String OS_TYPE = "os.arch";
    private static final String DRIVER = "webdriver.chrome.com.kollex.task.article.driver";

    public static void setDriver() {
        if (System.getProperty(OS).contains("Linux")
                && System.getProperty(OS_TYPE).contains("64")) {
            System.setProperty(DRIVER, DRIVER_PATH_LINUX);
        } else if (System.getProperty(OS).contains("Mac")) {
            System.setProperty(DRIVER, DRIVER_PATH_MAC);
        } else if (System.getProperty(OS).contains("Windows")) {
            System.setProperty(DRIVER, DRIVER_PATH_WIN);
        }
    }
}
