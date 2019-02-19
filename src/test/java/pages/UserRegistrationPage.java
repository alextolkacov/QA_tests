package pages;

import model.User;
import org.openqa.selenium.By;

public class UserRegistrationPage {
    private final By PK = By.id("pk");
    private final By NAME = By.id("name");
    private final By SURNAME = By.id("surname");
    private final By PHONE = By.id("phone");
    private final By EMAIL = By.id("email");
    private final By SUBMIT_BTN = By.xpath(".//input[@class = 'btn']");

    private BaseFunc baseFunc;

    public UserRegistrationPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void fillInRegistrationForm(User user) {
        baseFunc.getElement(PK).sendKeys(user.getPk());
        baseFunc.getElement(NAME).sendKeys(user.getName());
        baseFunc.getElement(SURNAME).sendKeys(user.getSurname());
        baseFunc.getElement(PHONE).sendKeys(user.getPhone());
        baseFunc.getElement(EMAIL).sendKeys(user.getEmail());

        baseFunc.getElement(SUBMIT_BTN).click();
    }
}
