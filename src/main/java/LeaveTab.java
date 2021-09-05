import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.Log;

import static com.codeborne.selenide.Selenide.$;


public class LeaveTab {

    public static SelenideElement ASSIGN_LEAVE = $("#menu_leave_assignLeave");
    public static SelenideElement LEAVE_LIST = $("#menu_leave_viewLeaveList");

    public static SelenideElement EMPLOYEE_NAME = $("#assignleave_txtEmployee_empName");
    public static SelenideElement LEAVE_TYPE = $("#assignleave_txtLeaveType");
    public static SelenideElement FROM_DATE = $("input#assignleave_txtFromDate");
    public static SelenideElement TO_DATE = $("input#assignleave_txtToDate");
    public static SelenideElement COMMENT = $("#assignleave_txtComment");
    public static SelenideElement ASSIGN_BTN = $("#assignBtn");
    public static SelenideElement PARTIAL_DAYS = $("#assignleave_partialDays");
    public static SelenideElement START_DAY_DAY = $("#assignleave_firstDuration_duration");
    public static SelenideElement START_DAY_TIME = $("#assignleave_firstDuration_ampm");
    public static SelenideElement ALL_CHKBX = $("#leaveList_chkSearchFilter_checkboxgroup_allcheck");
    public static SelenideElement OK_BTN = $("input#confirmOkButton");
    public static SelenideElement SEARCH_BTN = $("#btnSearch");
    public static SelenideElement EMPLOYEE = $("input#leaveList_txtEmployee_empName");

    String employeeName = "Lisa Andrews";

    @Step("Go to Leave Tab")
    public void goToLeaveTab() {
        Log.info("Go to the Leave Tab");
        MainPage.LEAVE_TAB.click();
    }

    @Step("go to the Assign Leave form")
    public void assignLeave() {
        Log.info("Go to the Assign Leave form");
        ASSIGN_LEAVE.click();
    }

    @Step("Fill the Assign Leave form")
    public void fillLeaveForm() {
        Log.info("Assign leave for the user " + employeeName);
        try {
            EMPLOYEE_NAME.should(Condition.exist).setValue(employeeName);
            LEAVE_TYPE.should(Condition.exist).selectOptionContainingText("CAN - Vacation");
            FROM_DATE.should(Condition.exist).setValue("10-09-2021");
            TO_DATE.should(Condition.exist).setValue("10-10-2021");
            COMMENT.setValue("Happy vacation!");
            PARTIAL_DAYS.selectOptionContainingText("Start Day Only");
            START_DAY_DAY.should(Condition.appear).selectOptionContainingText("Half Day");
            START_DAY_TIME.should(Condition.appear).selectOptionContainingText("Afternoon");
            ASSIGN_BTN.shouldBe(Condition.visible).click();
            OK_BTN.click();
            Log.info("The leave was successfully assigned.");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("The leave for employee " + employeeName + " wasn't assigned. ERROR:", e.getCause());
        }

    }

    @Step("Go to the Leave List")
    public void goToLeaveList() {
        LEAVE_LIST.click();
        Log.info("Go to the Leave List Tab.");
    }

    @Step("Check assigned Leave")
    public String checkLeave() {
        Log.info("Check if the assigned leave for the employee " + employeeName + " exists.");

        ALL_CHKBX.click();
        SEARCH_BTN.click();
        EMPLOYEE.setValue(employeeName);
        SelenideElement employeeLeave = $(By.xpath("//a[text() = '" + employeeName + "']"));
        try {
            employeeLeave.should(Condition.exist);
            Log.info("The Leave for the employee " + employeeName + "is assigned.");

        } catch (Exception e) {
            e.printStackTrace();
            Log.error("The Leave for the employee " + employeeName + " wasn't assigned! ERROR: ", e.getCause());
        }

        return employeeLeave.getText();


    }
}