package PageObject_Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PastebinTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "First lonely test")
    public void createNewPaste() {
        String pasteContent = "git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force";

        String pasteTitle = "how to gain dominance among developers";
        String syntaxBash = "Bash";

        PastebinHomePage pastebinPage = new PastebinHomePage(driver)
                .openPage()
                .writeCode(pasteContent, pasteTitle);

        boolean browserPageTitleMatches = pastebinPage.verifyTitle(pasteTitle);
        boolean syntaxSuspended = pastebinPage.verifySyntax(syntaxBash);
        boolean textMatches = pastebinPage.verifyText(pasteContent);

        Assert.assertTrue(browserPageTitleMatches, "Browser title doesn't match");
        Assert.assertTrue(syntaxSuspended, "Syntax is not set to Bash");
        Assert.assertTrue(textMatches, "Text does not match");
    }
}
