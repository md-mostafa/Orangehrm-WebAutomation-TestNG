package pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String doLoginWithInvalidCreds(String username, String password) {
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();
        return labelInvalidCreds.getText();
    }
    public void doLogin(String username, String password) {
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();
    }

    public String getHeaderTxt() {
        return headerTxt.getText();
    }

    public Boolean profileImageIsDisplayed() {
        return profileImageElement.isDisplayed();
    }
}
