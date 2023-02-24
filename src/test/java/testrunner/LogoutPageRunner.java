package testrunner;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.LogoutPage;
import setup.Setup;

public class LogoutPageRunner extends Setup {

    LogoutPage logoutPage;
    LoginPage loginPage;

    @BeforeClass
    public void doLogin(){
        loginPage = new LoginPage(driver);
        loginPage.doLogin("Admin", "admin123");
    }

    @Test(priority = 1, description = "Performing Logout")
    public void doLogout() throws InterruptedException {
        logoutPage = new LogoutPage(driver);
        logoutPage.clickOnUserDropdownBtn();
        Thread.sleep(5000);
        logoutPage.clickOnLogoutBtn();
        Thread.sleep(5000);

        String loginLabel_actual = logoutPage.getLoginLabel();
        String loginLabel_expected = "Login";
        Assert.assertTrue(loginLabel_actual.contains(loginLabel_expected), "Login unsuccessful");
    }

}
