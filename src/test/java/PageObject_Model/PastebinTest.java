package PageObject_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PastebinTest {

    private WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test (description = "First lonely test")
    public void CreateNewPaste() {

        String pasteContent = "Hello from WebDriver";
        String pasteTitle = "helloweb";

        PastebinHomePage pastebinPage = new PastebinHomePage(driver)
                .openPage()
                .writeCode(pasteContent, pasteTitle);

        boolean isPasteCreated = pastebinPage.verifySucceed(pasteTitle);

        Assert.assertTrue(isPasteCreated, "The paste was not created Succesfully");

    }


}
