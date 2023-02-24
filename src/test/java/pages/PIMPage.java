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

    @FindBy(xpath = "//h6[text()='Personal Details']")
    WebElement labelPersonalDetails;

    @FindBy(xpath = "//input[contains(@class, 'oxd-input')]")
    List<WebElement> inpPersonalDetails;

    @FindBy(xpath = "//button[text() =' Save ']")
    List<WebElement> btnPersonalDetails;


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


    public String getPersonalDetailsLabel(){
        Logs.info("Getting the 'Personal Details' label");
        wait.waitToBeDisplayed(labelPersonalDetails);
        return labelPersonalDetails.getText();
    }

    public void enterEmployeedId(String id){
        WebElement inpEmployeeId = inpPersonalDetails.get(5);
        wait.waitToBeDisplayed(inpEmployeeId);
        wait.waitToBeClickable(inpEmployeeId);
        Logs.info("Clicking on the Employee id input field");
        inpEmployeeId.click();

        Actions action = new Actions(driver);
        action.doubleClick(inpEmployeeId).perform();
        Logs.info("Entering employee id in the input field");
        inpEmployeeId.sendKeys(id);
    }

    public void clickOnSaveBtn() {
        WebElement btnPersonalDetail = btnPersonalDetails.get(0);
        wait.waitToBeDisplayed(btnPersonalDetail);
        wait.waitToBeClickable(btnPersonalDetail);
        Logs.info("CLicking ont he save button");
        btnPersonalDetail.click();
    }
}
