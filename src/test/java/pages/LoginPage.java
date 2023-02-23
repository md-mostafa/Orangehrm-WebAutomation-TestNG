package pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Logs;
import utils.Waits;

public class LoginPage {
    @FindBy(name="username")
    WebElement txtUsername;
    @FindBy(name="password")
    WebElement txtPassword;
    @FindBy(css="[type=submit]")
    WebElement btnLogin;
    @FindBy(tagName = "p")
    WebElement labelInvalidCreds;
    @FindBy(tagName = "h6")
    WebElement headerTxt;
    @FindBy(className = "oxd-userdropdown-img")
    WebElement profileImageElement;
    Waits wait;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new Waits(driver, 15);
    }



    public String doLoginWithInvalidCreds(String username, String password) {
        Logs.info("Inserting username in the txt field");
        wait.waitToBeDisplayed(txtUsername);
        txtUsername.sendKeys(username);
        wait.waitToBeDisplayed(txtPassword);
        Logs.info("Inserting password in the txt field");
        txtPassword.sendKeys(password);
        wait.waitToBeDisplayed(btnLogin);
        Logs.info("Clicking on the login button");
        btnLogin.click();
        Logs.info("Getting the invalid creds label");
        return labelInvalidCreds.getText();
    }
    public void doLogin(String username, String password) {
        Logs.info("Inserting username in the txt field");
        txtUsername.sendKeys(username);
        Logs.info("Inserting password in the txt field");
        txtPassword.sendKeys(password);
        Logs.info("Clicking on the login button");
        btnLogin.click();
    }

    public String getHeaderTxt() {
        wait.waitToBeDisplayed(headerTxt);
        Logs.info("Getting the header text");
        return headerTxt.getText();
    }

    public Boolean profileImageIsDisplayed() {
        wait.waitToBeDisplayed(profileImageElement);
        Logs.info("Proflie image element is displayed or not");
        return profileImageElement.isDisplayed();
    }
}
