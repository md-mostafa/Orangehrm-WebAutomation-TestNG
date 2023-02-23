package pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.Setup;
import utils.Utils;

import java.util.List;

public class PIMPage {
    @FindBy(xpath = "//span[text()='PIM']")
    WebElement  btnPIM;
    @FindBy(xpath = "//li/a[contains(text(), 'Add Employee')]")
    WebElement btnAdd;
    @FindBy(xpath="//input[contains(@class, 'oxd-input')]")
    List<WebElement> txtInp;
    @FindBy(className = "oxd-switch-input")
    WebElement btnToggle;
    @FindBy(css="[type=submit]")
    WebElement btnSubmit;
    @FindBy(xpath = "//a[text()='Employee List']")
    WebElement btnEmployedList;
    @FindBy(xpath = "//div[@class='oxd-table-filter']//input")
    List<WebElement> srchInputs;
    @FindBy(xpath = "//button[text()=' Search ']")
    WebElement btnSearch;
    @FindBy(xpath = "//div[@class='orangehrm-paper-container']//span")
    WebElement labelUserFound;

    @FindBy(xpath = "//div[contains(@class, 'oxd-table-card')]")
    List<WebElement> userRecords;

    @FindBy(xpath = "//h6[text()='Personal Details']")
    WebElement labelPersonalDetails;


    public PIMPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOnPIMFromDashboard() {
        btnPIM.click();
    }

    public void clickOnAddBtn() throws InterruptedException {
        btnAdd.click();
        Thread.sleep(5000);
    }

    public void createEmployee(String firstName, String lastName, String userName, String password) throws InterruptedException {
        btnToggle.click();
        WebElement inpFirstName = txtInp.get(1);
        WebElement inpLastName = txtInp.get(3);
        WebElement inpUserName = txtInp.get(5);
        WebElement inpPassword = txtInp.get(6);
        WebElement inpConfirmPassword = txtInp.get(7);

        inpFirstName.sendKeys(firstName);
        inpLastName.sendKeys(lastName);
        inpUserName.sendKeys(userName);
        inpPassword.sendKeys(password);
        inpConfirmPassword.sendKeys(password);
        Thread.sleep(5000);
        btnSubmit.click();
        Thread.sleep(5000);
        Thread.sleep(5000);

    }

    public void clickOnEmployeeListBtn() {
        btnEmployedList.click();
    }

    public void enterUserNameInSearchField(String name) {
       WebElement empNameSearchField =  srchInputs.get(0);
       empNameSearchField.sendKeys(name);
    }

    public void clickOnSearchBtn() {
        btnSearch.click();
    }

    public String getUserFoundTxt(){
        return labelUserFound.getText();
    }

    public void clickOnFirstRecord() {
        userRecords.get(1).click();
    }

    public String getPersonalDetailsLabel(){
        return labelPersonalDetails.getText();
    }
}
