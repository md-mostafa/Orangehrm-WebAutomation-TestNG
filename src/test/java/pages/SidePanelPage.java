package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;
import utils.ConfigReader;
import utils.Logs;
import utils.Waits;

public class SidePanelPage {
    @FindBy (xpath = "//a//span[text()='My Info']")
    WebElement btnMyInfo;
    private Waits wait;

    public SidePanelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = Browser.getWaits(ConfigReader.getTimeOuts());
    }

    public void clickOnMyInfoBtn(){
        Logs.info("Clicking on My Info from side panel");
        wait.waitToBeDisplayed(btnMyInfo);
        btnMyInfo.click();
    }
}
