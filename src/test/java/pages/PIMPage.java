package pages;

import org.json.simple.JSONObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import setup.Setup;
import utils.Utils;
import utils.Waits;

import java.security.Key;
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

    @FindBy(xpath = "//div[contains(@class, 'oxd-table-cell')]")
    List<WebElement> userRecords;

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
        wait = new Waits(driver, 15);
    }

    public void clickOnPIMFromDashboard() {
        wait.waitToBeDisplayed(btnPIM);
        btnPIM.click();
    }

    public void clickOnAddBtn() throws InterruptedException {
        wait.waitToBeDisplayed(btnAdd);
        btnAdd.click();
        //Thread.sleep(5000);
    }

    public void createEmployee(String firstName, String lastName, String userName, String password) throws InterruptedException {
        wait.waitToBeDisplayed(btnToggle);
        btnToggle.click();
        wait.waitToBeDisplayed(txtInp.get(1));
        WebElement inpFirstName = txtInp.get(1);
        wait.waitToBeDisplayed(txtInp.get(3));
        WebElement inpLastName = txtInp.get(3);
        wait.waitToBeDisplayed(txtInp.get(5));
        WebElement inpUserName = txtInp.get(5);
        wait.waitToBeDisplayed(txtInp.get(6));
        WebElement inpPassword = txtInp.get(6);
        wait.waitToBeDisplayed(txtInp.get(7));
        WebElement inpConfirmPassword = txtInp.get(7);

        inpFirstName.sendKeys(firstName);
        inpLastName.sendKeys(lastName);
        inpUserName.sendKeys(userName);
        inpPassword.sendKeys(password);
        inpConfirmPassword.sendKeys(password);
        //Thread.sleep(5000);
        wait.waitToBeDisplayed(btnSubmit);
        btnSubmit.click();
        //Thread.sleep(5000);
        //Thread.sleep(5000);

    }

    public void clickOnEmployeeListBtn() {
        wait.waitToBeDisplayed(btnEmployedList);
        btnEmployedList.click();
    }

    public void enterUserNameInSearchField(String name) {
       WebElement empNameSearchField =  srchInputs.get(0);
       wait.waitToBeDisplayed(empNameSearchField);
       empNameSearchField.sendKeys(name);
    }

    public void clickOnSearchBtn() {
        wait.waitToBeDisplayed(btnSearch);
        btnSearch.click();
    }

    public String getUserFoundTxt(){
        wait.waitToBeDisplayed(labelUserFound);
        return labelUserFound.getText();
    }

    public void clickOnFirstRecord() {
        wait.waitToBeDisplayed(userRecords.get(1));
        userRecords.get(1).click();
    }

    public String getPersonalDetailsLabel(){
        wait.waitToBeDisplayed(labelPersonalDetails);
        return labelPersonalDetails.getText();
    }

    public void enterEmployeedId(String id){
        WebElement inpEmployeeId = inpPersonalDetails.get(5);
        wait.waitToBeDisplayed(inpEmployeeId);
        inpEmployeeId.click();

        Actions action = new Actions(driver);
        action.doubleClick(inpEmployeeId).perform();
        //action.click(inpEmployeeId).sendKeys(Keys.CONTROL).keyDown(Keys.SHIFT).keyUp(Keys.SHIFT).sendKeys(Keys.BACK_SPACE).perform();
        inpEmployeeId.sendKeys(id);
    }

    public void enterEmployeedIdInSearchField(String id){
        WebElement empNameSearchField =  srchInputs.get(1);
        wait.waitToBeDisplayed(empNameSearchField);
        empNameSearchField.sendKeys(id);
    }


    public void clickOnSaveBtn() {
        WebElement btnPersonalDetail = btnPersonalDetails.get(0);
        wait.waitToBeDisplayed(btnPersonalDetail);
        btnPersonalDetail.click();
    }
}
