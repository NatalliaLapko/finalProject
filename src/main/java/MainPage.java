import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.Log;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public static SelenideElement DASHBOARD_TAB = $("a#menu_dashboard_index");
    public static SelenideElement LEAVE_TAB = $("a#menu_leave_viewLeaveModule");
    public static SelenideElement PIM_TAB = $("a#menu_pim_viewPimModule");
    public static SelenideElement ADMIN_TAB = $("a#menu_admin_viewAdminModule");
    public static SelenideElement RECRUITMENT_TAB = $("#menu_recruitment_viewRecruitmentModule");
    public static SelenideElement WELCOME_MENU = $("a#welcome");
    public static SelenideElement LOGOUT = $("[href$='logout']");


    @Step("Go to the Admin Tab")
    public void goToAdminTab() {
        try {
            ADMIN_TAB.click();
            Log.info("Go to the Admin Tab.");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error(e.getMessage());
        }
    }

    @Step("Go to the Dashboard")
    public void goToDashboard() {
        try {
            DASHBOARD_TAB.click();
            Log.info("Go to the Dashboard");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error(e.getMessage());
        }
    }

    @Step("Log out")
    public void logout() {
        Log.info("Log out the system");
        try {
            WELCOME_MENU.click();
            LOGOUT.should(Condition.appear).click();
            Log.info("User log out successfully.");
        } catch (Exception e) {
            Log.error("User doesn't logout the system. ERROR:", e.getCause());
        }
    }


}
