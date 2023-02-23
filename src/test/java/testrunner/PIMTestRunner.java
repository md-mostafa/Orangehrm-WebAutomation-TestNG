package testrunner;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PIMPage;
import setup.Setup;
import utils.RandomInfoUtils;
import utils.Utils;

public class PIMTestRunner extends Setup {
    LoginPage loginPage;
    PIMPage pimPage;

    @BeforeClass
    public void doLogin() {
        loginPage = new LoginPage(driver);
        loginPage.doLogin("Admin", "admin123");
    }

    @Test(priority = 1, description = "Adding first employee")
    public void addFirstEmployee() throws InterruptedException {
        pimPage = new PIMPage(driver);
        pimPage.clickOnPIMFromDashboard();
        Thread.sleep(5000);
        pimPage.clickOnAddBtn();
        Thread.sleep(5000);

        String firstName = RandomInfoUtils.getFirstName();
        String lastName = RandomInfoUtils.getLastName();
        String userName = RandomInfoUtils.getUserName();
        String password = RandomInfoUtils.getPassword();

        pimPage.createEmployee(firstName, lastName, userName, password);
        Thread.sleep(5000);

        Thread.sleep(5000);
        String header_actual = driver.findElement(By.className("orangehrm-main-title")).getText();
        String header_expected = "Personal Details";

        Assert.assertEquals(header_actual, header_expected);
        Utils.addJsonArray(firstName, lastName, userName, password);
        Thread.sleep(5000);
    }
    //@Test(priority = 2, description = "Adding second employee")
    public void addSecondEmployee() throws InterruptedException {
        pimPage = new PIMPage(driver);
        pimPage.clickOnPIMFromDashboard();
        Thread.sleep(5000);
        pimPage.clickOnAddBtn();
        Thread.sleep(5000);

        String firstName = RandomInfoUtils.getFirstName();
        String lastName = RandomInfoUtils.getLastName();
        String userName = RandomInfoUtils.getUserName();
        String password = RandomInfoUtils.getPassword();

        pimPage.createEmployee(firstName, lastName, userName, password);

        Thread.sleep(5000);
        Thread.sleep(5000);

        String header_actual = driver.findElement(By.className("orangehrm-main-title")).getText();
        String header_expected = "Personal Details";

        Assert.assertEquals(header_actual, header_expected);
        Utils.addJsonArray(firstName, lastName, userName, password);
    }

    @Test(priority = 3, description = "Searching User")
    public void searchUser() throws InterruptedException {
        pimPage = new PIMPage(driver);
        pimPage.clickOnEmployeeListBtn();
        Thread.sleep(5000);
        String userName = Utils.getProperty("./src/test/resources/NewUser.json", 0, "firstname");
        Thread.sleep(5000);
        pimPage.enterUserNameInSearchField(userName);
        Thread.sleep(5000);
        pimPage.clickOnSearchBtn();
        Thread.sleep(5000);

        String isUserFound_actual = pimPage.getUserFoundTxt();
        String isUserFound_expected = "Record Found";
        Assert.assertTrue(isUserFound_actual.contains(isUserFound_expected));
    }

    @Test(priority = 4, description = "Update user id")
    public void updateUser() throws InterruptedException {
        pimPage = new PIMPage(driver);
        Thread.sleep(5000);
        pimPage.clickOnFirstRecord();
        Thread.sleep(5000);
        String personalDetailsLabel_actual = pimPage.getPersonalDetailsLabel();
        String personalDetailsLabel_expected = "Personal Details";
        Assert.assertTrue(personalDetailsLabel_actual.contains(personalDetailsLabel_expected));
        Thread.sleep(5000);

        String id =""+RandomInfoUtils.getUserId();
        pimPage.enterEmployeedId(id);
        Thread.sleep(5000);
        pimPage.clickOnSaveBtn();
        Thread.sleep(5000);
        Utils.updateProperty("./src/test/resources/NewUser.json", 0, "userid", id);
    }
    @Test(priority = 5, description = "Search user by id")
    public void searchUserById() throws InterruptedException {
        pimPage = new PIMPage(driver);
        pimPage.clickOnEmployeeListBtn();
        Thread.sleep(5000);
        String userId = Utils.getProperty("./src/test/resources/NewUser.json", 0, "userid");
        Thread.sleep(5000);

        pimPage.enterEmployeedIdInSearchField(userId);
        Thread.sleep(5000);
        pimPage.clickOnSearchBtn();
        Thread.sleep(5000);

        String isUserFound_actual = pimPage.getUserFoundTxt();
        String isUserFound_expected = "Record Found";
        Assert.assertTrue(isUserFound_actual.contains(isUserFound_expected));
    }
}
