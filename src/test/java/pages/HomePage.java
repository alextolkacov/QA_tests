package pages;

import org.openqa.selenium.By;

public class HomePage {
    private BaseFunc baseFunc;

    private final By REGISTRATION_BTN = By.xpath(".//button[@data-qa-selector = 'home_page_approve']");

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public RegistrationPage clickGetLoan() {
        baseFunc.getElement(REGISTRATION_BTN).click();
        return new RegistrationPage(baseFunc);
    }
}
