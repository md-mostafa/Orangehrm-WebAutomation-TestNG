package pages;

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

    public void clickOnSaveBtn() {
        WebElement btnPersonalDetail = btnPersonalDetails.get(0);
        wait.waitToBeDisplayed(btnPersonalDetail);
        wait.waitToBeClickable(btnPersonalDetail);
        Logs.info("CLicking ont he save button");
        btnPersonalDetail.click();
    }
}
