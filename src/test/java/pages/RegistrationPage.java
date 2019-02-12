package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegistrationPage {
    private final By INPUT_FIELD = By.xpath(".//div[@class = 'sf-input__container']");
    private final By LABEL = By.xpath(".//div[@class = 'sf-input__label']");
    private final By AGREE_CHECKBOX = By.xpath(".//i[@class = 'sf-checkbox__mark sf-checkmark']");

    private BaseFunc baseFunc;

    public RegistrationPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        baseFunc.waitForElement(INPUT_FIELD);
    }

    public void fillPersonalData(String iin, String email) {
        WebElement iinField = getInputField("Введите Ваш ИИН");
        iinField.sendKeys(iin);

        WebElement emailField = getInputField("Адрес эл.почты");
        emailField.sendKeys(email);
    }

    public void agreeRules() {
        baseFunc.getElement(AGREE_CHECKBOX).click();
    }

    private WebElement getInputField(String label) {
        List<WebElement> inputFields = baseFunc.getAllElements(INPUT_FIELD);

        for (int i = 0; i < inputFields.size(); i++) {
            if (inputFields.get(i).findElement(LABEL).getText().equals(label)) {
                return inputFields.get(i).findElement(By.tagName("input"));
            }
        }

        return null;
    }
}
