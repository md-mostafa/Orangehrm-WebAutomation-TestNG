package pages;

import com.beust.ah.A;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Logs;
import utils.Waits;

import java.util.List;

public class PersonalDetailsPage {
    @FindBy(xpath = "//h6[text()='Personal Details']")
    WebElement labelPersonalDetails;
    @FindBy(xpath = "//input[contains(@class, 'oxd-input')]")
    List<WebElement> inpPersonalDetails;

    @FindBy(xpath = "//button[text() =' Save ']")
    List<WebElement> btnPersonalDetails;

    @FindBy(xpath = "//input[@type='radio']")
    List<WebElement> radioBtns;

    @FindBy(xpath = "//div[@class='oxd-select-text-input']")
    List<WebElement> selectBtns;

    @FindBy(xpath = "//div[@class='oxd-radio-wrapper']//label")
    List<WebElement> btnsRadio;

    @FindBy(xpath = "//a[contains(text(), 'Contact Details')]")
    WebElement btnContactDetails;

    WebDriver driver;
    private Waits wait;

    public PersonalDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new Waits(driver, 20);
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

    public void clickOnPersonalDtlsSaveBtn() {
        WebElement btnPersonalDetail = btnPersonalDetails.get(0);
        wait.waitToBeDisplayed(btnPersonalDetail);
        wait.waitToBeClickable(btnPersonalDetail);
        Logs.info("CLicking on the personal details save button");
        btnPersonalDetail.click();
    }

    public void clickOnCustomFieldsSaveBtn() {
        WebElement btnPersonalDetail = btnPersonalDetails.get(1);
        wait.waitToBeDisplayed(btnPersonalDetail);
        wait.waitToBeClickable(btnPersonalDetail);
        Logs.info("CLicking on the custom fields save button");
        btnPersonalDetail.click();
    }

    public void selectGenderType(String type) throws InterruptedException {
        Actions action = new Actions(driver);

        if(type == "male"){

            Thread.sleep(3000);
            Logs.info("Moving cursor on radio button gender type male");
            action.moveToElement(btnsRadio.get(0)).perform();
            Thread.sleep(3000);
            Logs.info("Clicking on gender type male radio btn");
            btnsRadio.get(0).click();

        }else{
            Thread.sleep(3000);
            Logs.info("Moving cursor on radio button gender type female");
            action.moveToElement(btnsRadio.get(1)).perform();
            Thread.sleep(3000);
            Logs.info("Clicking on gender type female radio btn");
            btnsRadio.get(1).click();
        }
    }

    public void selectBloodType(String type){
        WebElement bloodType = selectBtns.get(2);
        Logs.info("Clicking on blood type select button");
        bloodType.click();
        int count = 0;
        switch (type){
            case "A+":
                count = 1;
                break;
            case "A-":
                count = 2;
                break;
            case "B-":
                count = 4;
                break;
            case "0+":
                count = 5;
                break;
            case "O-":
                count = 6;
                break;
            case "AB+":
                count = 7;
                break;
            case "AB-":
                count = 8;
                break;
            default:
                break;
        }
        for (int i = 0; i<count; i++){
            bloodType.sendKeys(Keys.ARROW_DOWN);
        }
        bloodType.sendKeys(Keys.ENTER);
    }

    public void clickOnContactDetailsBtn(){
        Logs.info("Clicking on Contact details button");
        btnContactDetails.click();
    }
}
