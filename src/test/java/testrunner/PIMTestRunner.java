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
    PersonalDetailsPage prsonalDtlsPage;


    @BeforeClass
    public void doLogin() {
        loginPage = new LoginPage(driver);
        loginPage.doLogin("Admin", "admin123");
        pimPage = new PIMPage(driver);
        srchPage = new SearchPage(driver);
        addEmpPage = new AddEmployeePage(driver);
        prsonalDtlsPage = new PersonalDetailsPage(driver);
        logoutPage = new LogoutPage(driver);
    }

    @Test(priority = 1, description = "Adding first employee")
    public void addFirstEmployee() throws InterruptedException {
        prsonalDtlsPage = new PersonalDetailsPage(driver);

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

        String header_actual = prsonalDtlsPage.getPersonalDetailsLabel();
        String header_expected = "Personal Details";

        Assert.assertEquals(header_actual, header_expected);
        Utils.addJsonArray(firstName, lastName, userName, password);

    }
    //@Test(priority = 2, description = "Adding second employee")
    public void addSecondEmployee() throws InterruptedException {
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

        String header_actual = prsonalDtlsPage.getPersonalDetailsLabel();
        String header_expected = "Personal Details";

        Assert.assertEquals(header_actual, header_expected);
        Utils.addJsonArray(firstName, lastName, userName, password);
    }

    @Test(priority = 3, description = "Searching User")
    public void searchUserByName() {
        pimPage.clickOnEmployeeListBtn();

        String userName = Utils.getProperty("./src/test/resources/NewUser.json", 0, "firstname");
        srchPage.enterEmployeeNameInSrchField(userName);
        srchPage.clickOnSearchBtn();

        String isUserFound_actual = srchPage.getUserFoundTxt();
        System.out.println(isUserFound_actual);

        String isUserFound_expected = "Record Found";
        Assert.assertTrue(isUserFound_actual.contains(isUserFound_expected), "Record not found");
    }

    @Test(priority = 4, description = "Update user id")
    public void updateUser() throws InterruptedException {
        srchPage.clickOnFirstRecord();

        String personalDetailsLabel_actual = prsonalDtlsPage.getPersonalDetailsLabel();
        String personalDetailsLabel_expected = "Personal Details";
        Assert.assertTrue(personalDetailsLabel_actual.contains(personalDetailsLabel_expected));

        String id =""+RandomInfoUtils.getUserId();
        prsonalDtlsPage.enterEmployeedId(id);
        prsonalDtlsPage.clickOnSaveBtn();
        Utils.updateProperty("./src/test/resources/NewUser.json", 0, "userid", id);
    }

    @Test(priority = 5, description = "Search user by id")
    public void searchUserById() throws InterruptedException {
        pimPage.clickOnEmployeeListBtn();
        String userId = Utils.getProperty("./src/test/resources/NewUser.json", 0, "userid");
        srchPage.enterEmployeedIdInSrchField(userId);
        srchPage.clickOnSearchBtn();

        String isUserFound_actual = srchPage.getUserFoundTxt();
        String isUserFound_expected = "Record Found";
        Assert.assertTrue(isUserFound_actual.contains(isUserFound_expected), "User not found by id");


    }
    @Test(priority = 6, description = "Logout")
    public void doLogOut(){
        logoutPage.clickOnUserDropdownBtn();
        logoutPage.clickOnLogoutBtn();
        String loginLabel_actual = logoutPage.getLoginLabel();
        String loginLabel_expected = "Login";
        Assert.assertTrue(loginLabel_actual.contains(loginLabel_expected), "Logout unsuccessful");
    }
}
