import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.Log;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    String userName = "Admin";
    String password = "admin123";

    public static SelenideElement USERNAME = $("input#txtUsername");
    public static SelenideElement PASSWORD = $("input#txtPassword");
    public static SelenideElement LOGIN_BTN = $("input#btnLogin");

    @Step("Open Login Page")
    public void openLoginPage() {
        Log.info("Open Login Page");
        try {
            open(Links.LOGIN_PAGE_URL);
            Log.info("The login page ws opened successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("The login page wasn't opened! ERROR: ", e.getCause());
        }
    }

    @Step("Log in")
    public void login() {
        Log.info("Login the site");
        try {
            USERNAME.setValue(userName);
            PASSWORD.setValue(password);
            LOGIN_BTN.click();
            Log.info("The user login succesfully.");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("The user doesn't login. ERROR:", e.getCause());
        }

    }
}
