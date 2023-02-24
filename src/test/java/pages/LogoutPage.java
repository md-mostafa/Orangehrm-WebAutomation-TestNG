package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Logs;
import utils.Waits;

public class LogoutPage {
    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    private WebElement btnUserDropdown;
    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement btnLogout;
    @FindBy(xpath = "//h5[contains(@class, 'orangehrm-login-title')]")
    private WebElement labelLogin;


    private Waits wait;


    public LogoutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        wait = new Waits(driver, 15);
    }


    public void clickOnUserDropdownBtn(){
        wait.waitToBeDisplayed(btnUserDropdown);
        Logs.info("Clicking Userdropdown btn");
        btnUserDropdown.click();
    }

    public void clickOnLogoutBtn() {
        wait.waitToBeDisplayed(btnLogout);
        Logs.info("Clicking logout btn");
        btnLogout.click();
    }

    public String getLoginLabel() {
        wait.waitToBeDisplayed(labelLogin);
        Logs.info("Getting Login label");
        return labelLogin.getText();
    }

}
