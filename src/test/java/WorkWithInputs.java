import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BaseFunc;
import pages.HomePage;
import pages.RegistrationPage;

public class WorkWithInputs {
    private BaseFunc baseFunc = new BaseFunc();

    private final String IIN = "123456789012";
    private final String EMAIL = "test@test.kz";
    private final String PHONE = "496123456";
    private final String PASSWORD = "Toropishka2019";
    private final String URL = "staging.koke.kz";

    @Test
    public void useInputsWithoutAttributes() {
        baseFunc.goToUrl(URL);

        HomePage homePage = new HomePage(baseFunc);

        RegistrationPage registrationPage = homePage.clickGetLoan();
        registrationPage.fillPersonalData(IIN, EMAIL);
//        registrationPage.fillPhoneData(PHONE);
//        registrationPage.fillPassword(PASSWORD);
        registrationPage.agreeRules();
//        registrationPage.pressNextStepBtn();
//
//        WebElement inputField = getInputField(IIN);

//        Assertions.assertNotNull(inputField, IIN + " field not found!");
//
//        inputField.sendKeys("000000000");
    }
}
