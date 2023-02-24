package pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.Setup;
import utils.Logs;
import utils.Utils;
import utils.Waits;

import java.security.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PIMPage {
    @FindBy(xpath = "//span[text()='PIM']")
    WebElement  btnPIM;
    @FindBy(xpath = "//li/a[contains(text(), 'Add Employee')]")
    WebElement btnAdd;

    @FindBy(xpath = "//a[text()='Employee List']")
    WebElement btnEmployedList;

    WebDriver driver;
    private Waits wait;


    public PIMPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new Waits(driver, 20);
    }

    public void clickOnPIMFromDashboard() {
        wait.waitToBeDisplayed(btnPIM);
        wait.waitToBeClickable(btnPIM);
        Logs.info("Clicking on PIM button");
        btnPIM.click();
    }

    public void clickOnAddBtn() throws InterruptedException {
        Logs.info("Clicking on add button");
        wait.waitToBeDisplayed(btnAdd);
        wait.waitToBeClickable(btnAdd);
        btnAdd.click();
        //Thread.sleep(5000);
    }

    public void clickOnEmployeeListBtn() {
        Logs.info("Clicking on Employee List button");
        wait.waitToBeDisplayed(btnEmployedList);
        btnEmployedList.click();
    }

}
