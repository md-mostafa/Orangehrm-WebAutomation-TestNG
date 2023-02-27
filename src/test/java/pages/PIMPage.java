package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;
import utils.ConfigReader;
import utils.Logs;
import utils.Waits;

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
        wait = Browser.getWaits(ConfigReader.getTimeOuts());
    }

    public void clickOnPIMFromDashboard() {
        wait.waitToBeDisplayed(btnPIM);
        wait.waitToBeClickable(btnPIM);
        Logs.info("Clicking on PIM button");
        btnPIM.click();
    }

    public void clickOnAddBtn() {
        Logs.info("Clicking on add button");
        wait.waitToBeDisplayed(btnAdd);
        wait.waitToBeClickable(btnAdd);
        btnAdd.click();
    }

    public void clickOnEmployeeListBtn() {
        Logs.info("Clicking on Employee List button");
        wait.waitToBeDisplayed(btnEmployedList);
        btnEmployedList.click();
    }

}
