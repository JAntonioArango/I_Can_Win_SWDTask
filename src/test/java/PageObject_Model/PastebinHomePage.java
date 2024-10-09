package PageObject_Model;
import Waits.CustomConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class PastebinHomePage extends AbstractPage {
    private static final String HOMEPAGE_URL = "https://pastebin.com";

    @FindBy(id = "postform-text")
    private WebElement pasteBox;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpiration;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement tenMins;

    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxHighlightingDropdown;

    @FindBy(xpath = "//li[text()='Bash']")
    private WebElement bashOption;

    @FindBy(name = "PostForm[name]")
    private WebElement pasteName;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createNewPaste;

    @FindBy(css = "a.btn.-small.h_800")
    private WebElement syntaxLabel;

    @FindBy(xpath = "//textarea[@class='textarea']")
    private WebElement codeBlock;

    protected PastebinHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);}

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(CustomConditions
                .jQueryAJAXsCompleted());
        return this;}

    public PastebinHomePage writeCode(String code, String pasteName) {
        pasteBox.sendKeys(code);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Set expiration to "10 Minutes"
        pasteExpiration.click();
        wait.until(ExpectedConditions.visibilityOf(tenMins)).click();

        // Set syntax highlighting to "Bash"
        syntaxHighlightingDropdown.click();
        wait.until(ExpectedConditions.visibilityOf(bashOption)).click();

        // Set paste name/title
        this.pasteName.sendKeys(pasteName);

        // Click "Create New Paste"
        wait.until(ExpectedConditions.elementToBeClickable(createNewPaste)).click();
        return this;
    }

    public boolean verifyTitle(String title) {
        return driver.getTitle().equals(title);
    }

    public boolean verifySyntax(String syntaxBash) {
        return syntaxLabel.getText().equals(syntaxBash);
    }

    public boolean verifyText(String pasteText) {
        return codeBlock.getText().contains(pasteText);
    }
}
