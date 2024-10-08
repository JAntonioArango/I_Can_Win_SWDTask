package PageObject_Model;

import Waits.CustomConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import static java.lang.System.out;

public class PastebinHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://pastebin.com";

    @FindBy(id = "postform-text")
    private WebElement pasteBox;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement pasteExpiration;

    @FindBy(xpath = "//li[text()='10 Minutes']")
    private WebElement tenMins;

    @FindBy(name = "PostForm[name]")
    private WebElement pasteName;

    @FindBy(xpath = "//button[text()='Create New Paste']")
    private WebElement createNewPaste;

    @FindBy(name = "text")
    private WebElement succeed;

    protected PastebinHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(CustomConditions
                .jQueryAJAXsCompleted());
        return this;
    }

    public PastebinHomePage writeCode(String code, String pasteName) {
        pasteBox.sendKeys(code);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        pasteExpiration.click();
        wait.until(ExpectedConditions.visibilityOf(tenMins));
        tenMins.click();
        this.pasteName.sendKeys(pasteName);

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.elementToBeClickable(createNewPaste));
        createNewPaste.click();
        return this;
    }

    public boolean verifySucceed(String pasteName) {

        WebElement pasteHeader = driver.findElement(By.xpath("//h1[text()='" + pasteName + "']"));

        return pasteHeader.isDisplayed();
    }

}
