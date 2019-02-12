import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClientChecker {
    private List<Integer> loanIDs = new ArrayList<>();
    private final By LOGIN = By.name("identity");
    private final By PASS = By.name("credential");
    private final By SUBMIT = By.name("submit");
    private final By CLIENT = By.xpath(".//a[contains(@href, '/clients/open/')]");
    private final By TAB = By.xpath(".//ul[@role = 'tablist']/li/a");
    private final By TABLE = By.xpath(".//table[@class = 'table table-hover col1-p10']");
    private final By LABLE = By.xpath(".//span[contains(@class, 'table-label')]");

    WebDriver driver;

    @Test
    public void checkLoans() {
        fillList();

        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://erp.kuki.pl");
        driver.findElement(LOGIN).sendKeys("leonids.geseltins@bino.lv");
        driver.findElement(PASS).sendKeys("Elotouch555");
        driver.findElement(SUBMIT).click();

        for (Integer loanId : loanIDs) {
            String url = "https://erp.kuki.pl/loans/view/" + String.valueOf(loanId);

            driver.get(url);
            String clientLink = driver.findElement(CLIENT).getAttribute("href");
            driver.get(clientLink);

            findTab("Payments").click();

            List<WebElement> payments = driver.findElement(TABLE).findElements(By.tagName("tr"));

            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(LABLE));

            for (int i = 1; i < payments.size(); i++) {
                if (payments.get(i).findElements(By.tagName("td")).get(3).getText().equals("zł1.00")) {
                    if (!payments.get(i).findElement(LABLE).getText().equals("Payment Order not assigned")) {
                        System.out.println("Client with loan ID: " + loanId + " is corrupted!");
                    }
                }
            }
        }
    }

    private WebElement findTab(String name) {
        List<WebElement> tabs = driver.findElements(TAB);

        for (WebElement tab : tabs) {
            if (tab.getText().equals(name)) {
                return tab;
            }
        }

        return null;
    }

    private void fillList() {
        Collections.addAll(loanIDs, 133817, 140093, 140624, 140765, 141912, 144520, 144715, 144752, 144827, 145653, 145801, 146138,
                146172, 147162, 147314, 148006, 148006, 148072, 148317, 148365, 148384, 148568, 148595, 148595, 148652,
                148774, 148831, 148847, 148847, 148883, 149079, 149438, 149439, 149447, 149480, 150318, 150320, 150598,
                150601, 150768, 150885, 150916, 151083, 151083, 151159, 151176, 151404, 151442, 151655, 151669, 151683,
                151688, 151766, 151812, 151874, 151912, 152118, 153064, 153803, 153868, 154157, 154315, 154315, 154412,
                154423, 154455, 154455, 154515, 154583, 154745, 154898, 154910, 154926, 154929, 154978, 154990, 155273,
                155316, 155406, 155409, 155506, 155750, 155779, 155779, 155780, 155945, 155971, 155990, 156780, 156888,
                156914, 156948, 157237, 157237, 157447, 158482, 158624, 158957, 159145, 159176, 159276, 159382, 159614,
                159642, 159665, 159757, 159789, 159881, 159925, 159978, 159978, 159978, 160001, 160104, 160251, 160472,
                160552, 160585, 160693, 161438, 161874, 161882, 161980, 162020, 162096, 162097, 162357, 162458, 162597,
                162706, 162748, 163022, 163072, 163180, 163554, 163650, 163707, 163752, 163831, 163901, 163901, 163901,
                163901, 163979, 164108, 164121, 164185, 164204, 164204, 164208, 164236, 164637, 164677, 164694, 164698,
                164761, 164802, 164813, 164813, 164931, 165404, 165454, 165459, 165472, 165493, 165493, 166091, 166092,
                166103, 166370, 166525, 166611, 166789, 166795, 166816, 167036, 167325, 167684, 167714, 167914, 167974,
                167977, 168048, 168146, 168242, 168243, 168483, 168489, 168516, 168553, 168634, 168844, 168861, 168937,
                169235, 169556, 169776, 170093, 170093, 170163, 170768, 170860, 170884, 170947, 170948, 171157, 171188,
                171479, 171676, 171906, 171980, 172040, 172063, 172342, 172404, 172404, 172548, 172592, 172614, 172638,
                172989, 172993, 173021, 173342, 174201, 174513, 174774, 175211, 175283, 175327, 175421, 175866, 176091,
                176149, 176192, 176526, 176533, 176553, 176571, 176701, 176728, 176815, 176822);
    }
}
