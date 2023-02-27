package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {
    public static WebDriver getBrowser(String name){
        WebDriver driver = null;
        String browser_mode = ConfigReader.getBrowserMode();
        switch (name.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                if(browser_mode.equalsIgnoreCase("incognito"))
                    chromeOptions.addArguments("--incognito");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions fireFoxOptions = new FirefoxOptions();
                if(browser_mode.equalsIgnoreCase("incognito"))
                    fireFoxOptions.addArguments("--incognito");
                driver = new FirefoxDriver(fireFoxOptions);
                break;
            default:
                new RuntimeException("Invalid browser name " + name);
                break;
        }
        return driver;
    }


}
