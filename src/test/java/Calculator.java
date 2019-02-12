import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Calculator {
    private final By DOT = By.xpath("(.//div[@class = 'vue-slider-dot-handle'])[1]");
    private final By AMOUNT = By.xpath(".//div[@class = 'value-label amount']");
    WebDriver driver;

    @Test
    public void calculator() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://staging.koke.kz/");

        moveTo(5000);
    }

    private void moveTo(int amount) {
        Actions action = new Actions(driver);

        Actions actionDot = action.clickAndHold(driver.findElement(DOT));
        int currentAmount = Integer.valueOf(driver.findElement(AMOUNT).getText().replaceAll("[^\\d.]", ""));

        if (amount < currentAmount) {
            while (Integer.valueOf(driver.findElement(AMOUNT).getText().replaceAll("[^\\d.]", "")) != amount) {
                actionDot.moveByOffset(-1, 0).build().perform();
            }
        } else {
            while (Integer.valueOf(driver.findElement(AMOUNT).getText().replaceAll("[^\\d.]", "")) != amount) {
                actionDot.moveByOffset(1, 0).build().perform();
            }
        }

        actionDot.release().build().perform();
    }
}
