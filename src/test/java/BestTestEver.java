import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BestTestEver {
    private final By GET_LOAN_BTN = By.xpath(".//div[@class = 'button secondary']");
    private final By EMAIL_FIELD = By.xpath(".//input[@type = 'email']");
    private final By TITLE = By.xpath(".//h1[@class = 'title']");
    private WebDriver browser;


    @Test
    public void openDelfiPage() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        browser = new ChromeDriver();
        browser.manage().window().maximize();
        browser.get("https://staging.koke.kz/");

        browser.findElement(GET_LOAN_BTN).click();

        Assertions.assertEquals("Заявка на получение займа", browser.findElement(TITLE).getText(), "Wrong Page Title");

        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.elementToBeClickable(EMAIL_FIELD));

        browser.findElement(EMAIL_FIELD).sendKeys("test@test.lv");
    }

    @AfterEach
    public void closeBrowser() {
        browser.quit();
    }
}
