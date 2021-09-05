import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.Log;

import static com.codeborne.selenide.Selenide.$;

public class Dashboard {
    public static SelenideElement QUICK_LAUNCH_PANEL = $("#panel_resizable_0_0");
    public static SelenideElement EMPLOYEE_DISTRIBUTION_PANEL = $("#panel_resizable_1_0");
    public static SelenideElement LEGEND_PANEL = $("#panel_resizable_1_1");
    public static SelenideElement PENDING_LEAVE_REQUESTS_PANEL = $("#panel_resizable_1_2");

    public static SelenideElement ASSIGN_LEAVE_LINK = $(By.xpath("//span[text()='Assign Leave']"));
    public static SelenideElement LEAVE_LIST_LINK = $(By.xpath("//span[text()='Leave List']"));
    public static SelenideElement TIMESHEETS_LINK = $(By.xpath("//span[text()='Timesheets']"));
    public static SelenideElement APPLY_LEAVE_LINK = $(By.xpath("//span[text()='Apply Leave']"));
    public static SelenideElement MY_LEAVE_LINK = $(By.xpath("//span[text()='My Leave']"));
    public static SelenideElement MY_TIMESHEET_LINK = $(By.xpath("//span[text()='My Timesheet']"));


    @Step("Verify if Quick Launch Panel exists")
    public void isElementsExist1() {
        Log.info("Check if the Quick Launch Panel exists.");
        try {
            QUICK_LAUNCH_PANEL.shouldBe(Condition.visible);
            Log.info("Quick Launch Panel exists.");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("Quick Launch Panel doesn't exist. ERROR:", e.getCause());
        }

    }

    @Step("Verify if Employee Distribution Panel exists")
    public void isElementsExist2() {
        Log.info("Check if the Employee Distribution Panel exists.");
        try {
            EMPLOYEE_DISTRIBUTION_PANEL.shouldBe(Condition.visible);
            Log.info("Employee Distribution Panel exists.");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("Employee Distribution Panel doesn't exist. ERROR:", e.getCause());
        }
    }

    @Step("Verify if Pending Leave Requests Panel exists")
    public void isElementsExist3() {
        Log.info("Check if the Pending Leave Requests Panel exists.");
        try {
            PENDING_LEAVE_REQUESTS_PANEL.shouldBe(Condition.visible);
            Log.info("Pending Leave Requests Panel exists.");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("Pending Leave Requests Panel doesn't exist. ERROR:", e.getCause());

        }
    }

    @Step("Verify if Legend Panel exists")
    public void isElementsExist4() {
        Log.info("Check if theLegend Panel exists.");
        try {
            LEGEND_PANEL.shouldBe(Condition.visible);
            Log.info("Legend Panel exists.");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("Pending Legend Panel doesn't exist. ERROR:", e.getCause());

        }

    }

    @Step("Verify Employee Distribution Panel name")
    public String getDashPanelName() {
        return EMPLOYEE_DISTRIBUTION_PANEL.find(By.xpath("./legend")).getText();
    }

    @Step("Verify Pending Leave Request Panel name")
    public String getPendingLeaveRequestPanelName() {
        return PENDING_LEAVE_REQUESTS_PANEL.find(By.xpath("./legend")).getText();
    }

    @Step("Verify Legend Panel name")
    public String getLegendPanelName() {
        return LEGEND_PANEL.find(By.xpath("./legend")).getText();
    }

    @Step("Verify Quick Launch Panel name")
    public String getQuickLaunchPanelName() {
        return QUICK_LAUNCH_PANEL.find(By.xpath("./legend")).getText();
    }

    @Step("Verify if Assign Leave quick link works")
    public void verifyAssignLeaveLink() {
        Log.info("Follow the  Assign Leave link");
        try {
            ASSIGN_LEAVE_LINK.shouldBe(Condition.visible).click();
            Log.info("The Assign Leave link works well");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("The Assign Leave link doesn't work. ERROR:", e.getCause());
        }


    }

    @Step("Verify if Leave List quick link works")
    public void verifyLeaveListLink() {
        Log.info("Follow the Leave List link.");
        try {
            LEAVE_LIST_LINK.shouldBe(Condition.visible).click();
            Log.info("The Leave List link works well.");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("The Leave List link doesn't work. ERROR:", e.getCause());
        }


    }

    @Step("Verify if Timesheets quick link works")
    public void verifyTimesheetsLink() {
        Log.info("Follow the Timesheets link.");
        try {
            TIMESHEETS_LINK.shouldBe(Condition.visible).click();
            Log.info("The Timesheets link works well.");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("The Timesheets link doesn't work. ERROR:", e.getCause());
        }

    }

    @Step("Verify if Apply Leave quick link works")
    public void verifyApplyLeaveLink() {
        Log.info("Follow the Apply Leave link.");
        try {
            APPLY_LEAVE_LINK.shouldBe(Condition.visible).click();
            Log.info("The Apply Leave link works well.");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("The Apply Leave link doesn't work. ERROR:", e.getCause());
        }

    }

    @Step("Verify if My Leave quick link works")
    public void verifyMyLeaveLink() {
        Log.info("Follow the My Leave link.");
        try {
            MY_LEAVE_LINK.shouldBe(Condition.visible).click();
            Log.info("The My Leave link works well.");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("The Apply My link doesn't work. ERROR:", e.getCause());
        }
    }

    @Step("Verify if My Timesheet quick link works")
    public void verifyMyTimesheetLink() {
        Log.info("Follow the My Timesheet link.");
        try {
            MY_TIMESHEET_LINK.should(Condition.exist).click();
            Log.info("The My Timesheet link works well.");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("The Apply My Timesheet doesn't work. ERROR:", e.getCause());
        }
    }
}