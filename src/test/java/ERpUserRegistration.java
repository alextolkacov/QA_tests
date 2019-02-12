import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ERpUserRegistration {
    private final By EMAIL = By.name("identity");
    private final By PASSWORD = By.xpath(".//input[contains(@placeholder,'Password')]");
    private final By SIGN_BTN = By.xpath(".//button[contains(@name, 'submit')]");
    private final By NAME = By.id("name");
    private final By SURNAME = By.id("surname");
    private final By EMAIL_NEW_USER = By.id("email");
//    private final By LOCALE = By.xpath(".//button[contains(@class,'selectpicker btn-default')]");

    private final By FORM_GROUP = By.xpath(".//div[@class = 'form-group ']");
    private final By LOCALE_TEXT = By.xpath(".//span[@class = 'text']");

//    private final By LOCALE_COUNTRY = By.xpath("//*[@id='AddUser']/div/div[4]/div[2]/div[2]/div[2]/div/div/div/div/ul/li[2]");
    private final By GROUPS = By.xpath("//*[@id='AddUser']/div/div[4]/div[2]/div[4]/div[1]/div/div/div/button");
    private final By GROUPS_STATUS = By.xpath("//*[@id='AddUser']/div/div[4]/div[2]/div[4]/div[1]/div/div/div/div/ul/li[10]");
    private final By OPTIONS = By.id("superAdmin");
    private final By NEW_PASSWORD = By.id("password");
    private final By CONFIRM_PASSWORD = By.id("passwordConfirm");
    private final By SAVE = By.id("btnSave");
    private String email  = "jekaterina.landiseva@bino.lv";
    private String password = "Test12345678";
    private String name = "TEST";
    private String surname = "TESTOVICH";
    private String email_new_user = "test@bino.lv";
    private String new_password = "Test1234";
    private String confirm_password = "Test1234";
    private WebDriver driver;

    @Test
    public void ourFistTryTest() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/jekaterina.landiseva/Desktop/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stage.erp.finbo.pl/");
        driver.findElement(EMAIL).sendKeys(String.valueOf(email));
        driver.findElement(PASSWORD).sendKeys(String.valueOf(password));
        driver.findElement(SIGN_BTN).click();
        driver.findElement(By.linkText("Users")).click();
        driver.findElement(By.linkText("Add User")).click();
        driver.findElement(NAME).sendKeys(String.valueOf(name));
        driver.findElement(SURNAME).sendKeys(String.valueOf(surname));
        driver.findElement(EMAIL_NEW_USER).sendKeys(String.valueOf(email_new_user));
//        driver.findElement(LOCALE).click();
//        driver.findElement(LOCALE_COUNTRY).click();
        selectLocale("PL");
        driver.findElement(GROUPS).click();
        driver.findElement(GROUPS_STATUS).click();
        driver.findElement(OPTIONS).click();
        driver.findElement(NEW_PASSWORD).sendKeys(String.valueOf(new_password));
        driver.findElement(CONFIRM_PASSWORD).sendKeys(String.valueOf(confirm_password));
        driver.findElement(SAVE).click();
    }

    private void selectLocale(String locale) {
//        driver.findElement(LOCALE).click();
        WebElement localeDropDown = getDropDown("locale");
        localeDropDown.click();
        List<WebElement> locales = localeDropDown.findElements(By.tagName("li"));

        for (WebElement we : locales) {
            if (we.findElement(LOCALE_TEXT).getText().equals(locale)) {
                we.click();
                break;
            }
        }
    }

    private WebElement getDropDown(String label) {
        List<WebElement> groups = driver.findElements(FORM_GROUP);

        for (WebElement we : groups) {
            if (we.findElement(By.tagName("label")).getAttribute("for").equals(label)) {
                return we;
            }
        }

        return null;
    }
}
