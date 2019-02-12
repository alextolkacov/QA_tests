import org.junit.jupiter.api.Test;
import pages.BaseFunc;

public class RegistrationTest {
    private BaseFunc baseFunc = new BaseFunc();
    private final String URL = "staging.koke.kz";

    @Test
    public void checkEmailField() {
        baseFunc.goToUrl(URL);
    }
}
