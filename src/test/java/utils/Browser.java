package utils;

import org.openqa.selenium.WebDriver;


public class Browser {
    private static WebDriver driver;

    private Browser() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = BrowserFactory.getBrowser(ConfigReader.getBrowser());
        }
        return driver;
    }

    public static void goToUrl(String url){
        getDriver().get(url);
    }

    public static Waits getWaits(int seconds) {
       return new Waits(getDriver(), seconds);
    }
    public static void closeDriver() {
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

}
