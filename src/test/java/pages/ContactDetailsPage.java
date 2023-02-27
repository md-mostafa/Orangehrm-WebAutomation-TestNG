package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;
import utils.ConfigReader;
import utils.Logs;
import utils.Waits;

import java.util.List;

public class ContactDetailsPage {
    @FindBy(xpath = "//button[text()=' Save ']")
    WebElement btnSave;

    @FindBy(xpath = "//i[contains(@class, 'arrow')]")
    WebElement arrwBtnCountry;
    @FindBy(xpath = "//div[contains(@class, 'oxd-select-text-input')]")
    WebElement inpCountryTxt;

    @FindBy(xpath = "//input[contains(@class, 'oxd-input')]")
    List<WebElement> inputs;
    private WebDriver driver;
    private Waits wait;

    public ContactDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = Browser.getWaits(ConfigReader.getTimeOuts());
    }

    public void enterStreet1(String street){
        wait.waitToBeVisibleAllElements(inputs);
        Logs.info("Entering street");
        WebElement inpStreet1 = inputs.get(1);
        inpStreet1.sendKeys(street);
    }

    public void enterCity(String city){
        wait.waitToBeVisibleAllElements(inputs);
        Logs.info("Entering state");
        WebElement inpCity = inputs.get(3);
        inpCity.sendKeys(city);
    }

    public void enterStateProvince(String state){
        wait.waitToBeVisibleAllElements(inputs);
        Logs.info("Entering state");
        WebElement stateProvince = inputs.get(4);
        stateProvince.sendKeys(state);
    }

    public void enterZipCode(String zip){
        wait.waitToBeVisibleAllElements(inputs);
        Logs.info("Enter zip code");
        WebElement zipCode = inputs.get(5);
        zipCode.sendKeys(zip);
    }

    public void selectCountry(String country) {
        wait.waitToBeVisible(arrwBtnCountry);
        wait.waitToBeVisible(inpCountryTxt);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", arrwBtnCountry);
        arrwBtnCountry.click();
        String countryName ="";
        while(!countryName.contains(country)){
            inpCountryTxt.sendKeys(Keys.ARROW_DOWN);
            countryName = inpCountryTxt.getText();
        }
        arrwBtnCountry.click();
    }

    public void enterEmail(String email){
        wait.waitToBeVisibleAllElements(inputs);
        WebElement inpEmail = inputs.get(9);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inpEmail);
        Logs.info("CLicking on email input field");
        inpEmail.click();
        Logs.info("Clearing the input field");
        inpEmail.clear();
        Logs.info("Entering email address int he input field");
        inpEmail.sendKeys(email);

    }

    public void clickOnSaveBtn(){
        wait.waitToBeVisible(btnSave);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnSave);
        Logs.info("Clicking on save button");
        btnSave.click();
    }

}
