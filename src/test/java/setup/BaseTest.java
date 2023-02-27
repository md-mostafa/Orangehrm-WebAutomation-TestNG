package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Browser;
import utils.ConfigReader;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    @BeforeTest
    public void setup() {
        driver = Browser.getDriver();
        driver.get(ConfigReader.getUrl());
        driver.manage().window().maximize();
    }

    @AfterTest
    public void closeDriver() {
        Browser.closeDriver();
    }

}
