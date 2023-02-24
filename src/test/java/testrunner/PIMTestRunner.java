package testrunner;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import setup.Setup;
import utils.RandomInfoUtils;
import utils.Utils;

public class PIMTestRunner extends Setup {
    LoginPage loginPage;
    PIMPage pimPage;
    LogoutPage logoutPage;
    SearchPage srchPage;
    AddEmployeePage addEmpPage;


    @BeforeClass
    public void doLogin() {
        loginPage = new LoginPage(driver);
        loginPage.doLogin("Admin", "admin123");
    }

    @Test(priority = 1, description = "Adding first employee")
    public void addFirstEmployee() throws InterruptedException {
        pimPage = new PIMPage(driver);
        addEmpPage = new AddEmployeePage(driver);
        pimPage.clickOnPIMFromDashboard();
        pimPage.clickOnAddBtn();

        addEmpPage.clickOnLoginDetailsToggleBtn();
        String firstName = RandomInfoUtils.getFirstName();
        addEmpPage.inputFirstName(firstName);
        String lastName = RandomInfoUtils.getLastName();
        addEmpPage.inputLastName(lastName);
        String userName = RandomInfoUtils.getUserName();
        addEmpPage.inputUserName(userName);
        String password = RandomInfoUtils.getPassword();
        addEmpPage.inputPassword(password);
        addEmpPage.inputConfirmPassword(password);
        addEmpPage.clickOnSaveBtn();

        String header_actual = pimPage.getPersonalDetailsLabel();
        String header_expected = "Personal Details";

        Assert.assertEquals(header_actual, header_expected);
        Utils.addJsonArray(firstName, lastName, userName, password);

    }
    //@Test(priority = 2, description = "Adding second employee")
    public void addSecondEmployee() throws InterruptedException {
        pimPage = new PIMPage(driver);
        addEmpPage = new AddEmployeePage(driver);
        pimPage.clickOnPIMFromDashboard();
        pimPage.clickOnAddBtn();

        addEmpPage.clickOnLoginDetailsToggleBtn();
        String firstName = RandomInfoUtils.getFirstName();
        addEmpPage.inputFirstName(firstName);
        String lastName = RandomInfoUtils.getLastName();
        addEmpPage.inputLastName(lastName);
        String userName = RandomInfoUtils.getUserName();
        addEmpPage.inputUserName(userName);
        String password = RandomInfoUtils.getPassword();
        addEmpPage.inputPassword(password);
        addEmpPage.inputConfirmPassword(password);
        addEmpPage.clickOnSaveBtn();

        String header_actual = pimPage.getPersonalDetailsLabel();
        String header_expected = "Personal Details";

        Assert.assertEquals(header_actual, header_expected);
        Utils.addJsonArray(firstName, lastName, userName, password);
    }

    @Test(priority = 3, description = "Searching User")
    public void searchUser() {
        pimPage = new PIMPage(driver);
        srchPage = new SearchPage(driver);
        pimPage.clickOnEmployeeListBtn();

        String userName = Utils.getProperty("./src/test/resources/NewUser.json", 0, "firstname");
        srchPage.enterEmployeeNameInSrchField(userName);
        srchPage.clickOnSearchBtn();

        String isUserFound_actual = srchPage.getUserFoundTxt();
        System.out.println(isUserFound_actual);

        String isUserFound_expected = "Record Found";
        Assert.assertTrue(isUserFound_actual.contains(isUserFound_expected), "Record not found");
    }

    //@Test(priority = 4, description = "Update user id")
    public void updateUser() throws InterruptedException {
        pimPage = new PIMPage(driver);
        srchPage = new SearchPage(driver);

        srchPage.clickOnFirstRecord();

        String personalDetailsLabel_actual = pimPage.getPersonalDetailsLabel();
        String personalDetailsLabel_expected = "Personal Details";
        Assert.assertTrue(personalDetailsLabel_actual.contains(personalDetailsLabel_expected));
       // Thread.sleep(5000);

        String id =""+RandomInfoUtils.getUserId();
        pimPage.enterEmployeedId(id);
       // Thread.sleep(5000);
        pimPage.clickOnSaveBtn();
       // Thread.sleep(5000);
        Utils.updateProperty("./src/test/resources/NewUser.json", 0, "userid", id);
    }
    //@Test(priority = 5, description = "Search user by id")
    public void searchUserById() throws InterruptedException {
        pimPage = new PIMPage(driver);
        logoutPage = new LogoutPage(driver);

        pimPage.clickOnEmployeeListBtn();
       // Thread.sleep(5000);
        String userId = Utils.getProperty("./src/test/resources/NewUser.json", 0, "userid");
      //  Thread.sleep(5000);

     //   pimPage.enterEmployeedIdInSearchField(userId);
       // Thread.sleep(5000);
      //  pimPage.clickOnSearchBtn();
       // Thread.sleep(5000);

       // String isUserFound_actual = pimPage.getUserFoundTxt();
        String isUserFound_expected = "Record Found";
        //Assert.assertTrue(isUserFound_actual.contains(isUserFound_expected), "User not found by id");

        logoutPage.clickOnLogoutBtn();
        logoutPage.clickOnLogoutBtn();
        String loginLabel_actual = logoutPage.getLoginLabel();
        String loginLabel_expected = "Login";
        Assert.assertTrue(loginLabel_actual.contains(loginLabel_expected), "Logout unsuccessful");
    }
}
