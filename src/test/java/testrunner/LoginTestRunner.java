package testrunner;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import setup.BaseTest;
import utils.Utils;

public class LoginTestRunner extends BaseTest {
    LoginPage loginPage;

    @Test(priority = 1, description = "User can not do login if provides wrong username")
    public void doLoginWithInvalidUserName() {
        loginPage = new LoginPage(driver);
        String msg_actual = loginPage.doLoginWithInvalidCreds("wrongusername", "admin123");
        String msg_expected ="Invalid credentials";
        Assert.assertTrue(msg_actual.contains(msg_expected), "Invalid credential msg didn't show");
    }

    @Test(priority = 2, description = "User can not do login if provides wrong password")
    public void doLoginWithInvalidPass() {
        loginPage = new LoginPage(driver);
        String msg_actual = loginPage.doLoginWithInvalidCreds("admin", "wrongpassword");
        String msg_expected ="Invalid credentials";
        Assert.assertTrue(msg_actual.contains(msg_expected), "Invalid credentials msg didn't show");
    }


    @Test(priority = 3, description = "User can do login successfully")
    public void doLogin() {
        loginPage = new LoginPage(driver);

        String userName;
        String passWord;

        if(System.getProperty("username") != null && System.getProperty("password") != null){
            userName = System.getProperty("username");
            passWord = System.getProperty("password");
        }else {
            JSONObject jsonObject = Utils.loadJsonFile("./src/test/resources/user.json");
            userName = (String) jsonObject.get("username");
            passWord = (String) jsonObject.get("password");
        }
        loginPage.doLogin(userName, passWord);

        String header_actual = loginPage.getHeaderTxt();
        String header_expected = "Dashboard";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(header_actual, header_expected, "Login unsuccessful");

        softAssert.assertTrue(loginPage.profileImageIsDisplayed());
        softAssert.assertAll();
    }
}
