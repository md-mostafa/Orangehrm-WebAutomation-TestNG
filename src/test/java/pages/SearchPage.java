package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;
import utils.ConfigReader;
import utils.Logs;
import utils.Waits;
import java.util.List;


public class SearchPage {
    @FindBy(xpath = "//div[@class='oxd-table-filter']//input")
    List<WebElement> srchInputs;

    @FindBy(xpath = "//button[text()=' Search ']")
    WebElement btnSearch;

    @FindBy(xpath = "//div/span[text()]")
    WebElement labelUserFound;

    @FindBy(xpath = "//div[contains(@class, 'oxd-table-cell')]")
    List<WebElement> userRecords;

    WebDriver driver;
    private Waits wait;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = Browser.getWaits(ConfigReader.getTimeOuts());
    }
    public void enterName(String name)  {
        wait.waitToBeVisibleAllElements(srchInputs);
        wait.waitToBeVisible(srchInputs.get(0));
        WebElement inpEmployeeName = srchInputs.get(0);

        wait.waitToBeDisplayed(inpEmployeeName);
        Logs.info("Entering name in the employee name search field");
        inpEmployeeName.sendKeys(name);
    }

    public void enterId(String id)  {
        wait.waitToBeVisibleAllElements(srchInputs);
        wait.waitToBeVisible(srchInputs.get(1));
        WebElement inpEmployeeId = srchInputs.get(1);
        wait.waitToBeDisplayed(inpEmployeeId);
        Logs.info("Entering employee id in the search field");
        inpEmployeeId.sendKeys(id);

    }

    public void clickOnSearchBtn() {
        try{
            Thread.sleep(4000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        Logs.info("Clicking the search button");
        wait.waitToBeDisplayed(btnSearch);
        btnSearch.click();

        try{
            Thread.sleep(4000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String getUserFoundTxt(){
        Logs.info("Getting the 'User Found' label");
        wait.waitToBeVisible(labelUserFound);
        wait.waitToBeDisplayed(labelUserFound);
        return labelUserFound.getText();
    }

    public void clickOnFirstRecord() {
        Logs.info("Clicking on the first record");
        wait.waitToBeVisibleAllElements(userRecords);
        wait.waitToBeDisplayed(userRecords.get(1));
        wait.waitToBeClickable(userRecords.get(1));
        userRecords.get(1).click();
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
