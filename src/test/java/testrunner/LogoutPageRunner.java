package testrunner;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;
import setup.BaseTest;

public class LogoutPageRunner extends BaseTest {
    LogoutPage logoutPage;
    LoginPage loginPage;

    @BeforeTest
    public void doLogin(){
        loginPage = new LoginPage(driver);
        loginPage.doLogin("Admin", "admin123");
    }

    @Test(priority = 1, description = "Performing Logout")
    public void doLogout()  {
        logoutPage = new LogoutPage(driver);

        logoutPage.clickOnUserDropdownBtn();
        logoutPage.clickOnLogoutBtn();

        String loginLabel_actual = logoutPage.getLoginLabel();
        String loginLabel_expected = "Login";
        Assert.assertTrue(loginLabel_actual.contains(loginLabel_expected), "Login unsuccessful");
    }
}
