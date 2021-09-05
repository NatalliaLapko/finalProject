import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.Log;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public static SelenideElement BUZZ_TAB = $("a#menu_buzz_viewBuzz");
    public static SelenideElement MAINTENANCE_TAB = $("a#menu_maintenance_purgeEmployee");
    public static SelenideElement DIRECTORY_TAB = $("a#menu_directory_viewDirectory");
    public static SelenideElement DASHBOARD_TAB = $("a#menu_dashboard_index");
    public static SelenideElement MY_INFO_TAB = $("a#a#menu_pim_viewMyDetails");
    public static SelenideElement TIME_TAB = $("a#menu_time_viewTimeModule");
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
            LOGOUT.click();
            Log.info("User log out successfully.");
        } catch (Exception e) {
            Log.error("User doesn't logout the system. ERROR:", e.getCause());
        }
    }


}
