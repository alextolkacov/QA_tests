package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseFunc {
    private WebDriver driver;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void goToUrl(String url) {
        if (!url.contains("http://") && !url.contains("https://")) {
            url = "http://" + url;
        }
        driver.get(url);
        Cookie cookie = new Cookie("qa-mode", "true");
        driver.manage().addCookie(cookie);
        driver.get(url);
    }

    public WebElement getElement(By locator) {
        Assertions.assertFalse(getAllElements(locator).isEmpty(), "There is not such element");
        return driver.findElement(locator);
    }

    public List<WebElement> getAllElements(By locator) {
        return driver.findElements(locator);
    }

    public void waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

    }
}
