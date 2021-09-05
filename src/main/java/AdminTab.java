import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.WaitUntil;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utils.Log;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;


public class AdminTab {

    public static SelenideElement ADD_BTN = $("input#btnAdd");
    public static SelenideElement USER_ROLE = $("#systemUser_userType");
    public static SelenideElement EMPLOYEE_NAME = $("input#systemUser_employeeName_empName");
    public static SelenideElement USERNAME = $("#systemUser_userName");
    public static SelenideElement USER_STATUS = $("#systemUser_status");
    public static SelenideElement PASSWORD = $("input#systemUser_password");
    public static SelenideElement CONFIRM_PASSWORD = $("input#systemUser_confirmPassword");
    public static SelenideElement SAVE_BTN = $("input#btnSave");

    public static SelenideElement JOB_TAB = $("#menu_admin_Job");
    public static SelenideElement ADD_BTN_JOB_TITLE = $("#btnAdd");
    public static SelenideElement JOB_TITLE_TAB = $("#menu_admin_viewJobTitleList");
    public static SelenideElement JOB_TITLE = $("#jobTitle_jobTitle");
    public static SelenideElement JOB_DESCRIPTION = $("#jobTitle_jobDescription");
    public static SelenideElement JOB_SPECIFICATION = $("input#jobTitle_jobSpec");
    public static SelenideElement NOTE = $("#jobTitle_note");
    public static SelenideElement DELETE_BTN = $("#btnDelete");
    public static SelenideElement DELETE_OK = $("#dialogDeleteBtn");

    public static SelenideElement USERNAME_SEARCH = $("#searchSystemUser_userName");
    public static SelenideElement SEARCH_BTN = $("#searchBtn");
    public static SelenideElement RESULT_TABLE = $("#resultTable");


    String pass = "1ghdf[]dlkfcr4562";
    String file = "src/main/resources/Testing file.docx";
    String employeeName = "Jadine Jackie";
    String userName = "Jenifer Stevens";


    @Step("Add new user")
    public void addUser() {
        Log.info("User creation is started");
        try {
            ADD_BTN.shouldBe(Condition.visible).click();
            USER_ROLE.should(Condition.exist).selectOption("ESS");
            EMPLOYEE_NAME.should(Condition.exist).setValue(employeeName);
            USERNAME.should(Condition.exist).setValue(userName);
            USER_STATUS.should(Condition.exist);
            PASSWORD.should(Condition.exist).setValue(pass);
            CONFIRM_PASSWORD.should(Condition.exist).setValue(pass);
            SAVE_BTN.shouldBe(Condition.visible).click();
           // SEARCH_BTN.waitUntil(Condition.appear,8000);

            Log.info("User was successfully created!");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("User wasn't created! ERROR: ", e.getCause());
        }

    }

    @Step("Verify created user")
    public void verifyCreatedUser() {
        Log.info("Verify if the created user with name" + userName + "exists.");
        try {
            SelenideElement createdUser = $(By.xpath("//a[text()='" + userName + "']"));
            createdUser.click();
            EMPLOYEE_NAME.shouldBe(Condition.disabled).shouldHave(Condition.value(employeeName));
            USERNAME.shouldBe(Condition.disabled).shouldHave(Condition.value(userName));
            Log.info("The user with name " + userName + "and employee name " + employeeName + "was created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("The user with name " + userName + " wasn't found! ERROR: ", e.getCause());
        }


    }

    @Step("Find user by search")
    public void createdUserSearch() {
        Log.info("Searching for user with the name " + userName);
        try {
            USERNAME_SEARCH.shouldBe(Condition.visible).setValue(userName);
            SEARCH_BTN.shouldBe(Condition.visible).click();
            Log.info("The user with name " + userName + "was found.");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("The user with the name " + userName + " wasn't found. ERROR:", e.getCause());
        }


    }

    @Step("Get the name of the found user")
    public String getFoundUserName() {
        return USERNAME.getValue();
    }

    @Step("Delete user")
    public void deleteUser() {
        Log.info("Deleting user with the name " + userName);
        try {
            SelenideElement userNameMarker = $(By.xpath("//a[text()='" + userName + "']/../..//input[@name='chkSelectRow[]']"));
            userNameMarker.click();
            DELETE_BTN.shouldBe(Condition.visible).click();
            DELETE_OK.shouldBe(Condition.visible).click();
            Log.info("The user with name " + userName + "was deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("The user with name " + userName + "wasn't deleted! ERROR:", e.getCause());
        }


    }


    @Step("Go to the JobTab")
    public void goToJobTab() {
        Log.info("Go to the Job Tab");
        try {
            JOB_TAB.shouldBe(Condition.visible).click();
            JOB_TITLE_TAB.should(Condition.exist).click();
            Log.info("You are on the Job Tab.");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("You can't go to the Job Tab. ERROR: ", e.getCause());
        }

    }

    @Step("Add Job Title ")
    public void addJobTitle(String jobTitle) {
        Log.info("Add job Title '" + jobTitle + "'.");
        try {
            ADD_BTN_JOB_TITLE.shouldBe(Condition.visible).click();
            JOB_TITLE.should(Condition.exist).setValue(jobTitle);
            JOB_DESCRIPTION.setValue("Test test test test test test test test");
            NOTE.setValue("NoteNoteNoteNote");
            JOB_SPECIFICATION.uploadFile(new File(file));
            SAVE_BTN.click();
            Log.info("Job title '" + jobTitle + "' was created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("Job title '" + jobTitle + "'wasn't created! ERROR: ", e.getCause());
        }
    }

    @Step("Get created job title name")
    public String getCreatedJobValue(String jobTitle) {

        SelenideElement createdJob = $(By.xpath("//a[text() = '" + jobTitle + "']"));
        return createdJob.getText();
    }

    @Step("Find job title")
    public void findJobTitle(String jobTitle) {
        Log.info("Select job with title '" + jobTitle + "'.");
        try {
            String jobTitleLocator = "//a[text()='" + jobTitle + "']/../..//input[@type = 'checkbox']";
            SelenideElement jobTitleMarker = $(By.xpath(jobTitleLocator));
            jobTitleMarker.click();
            Log.info("The job with the title '" + jobTitle + "' was selected.");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("The job with the title '" + jobTitle + "' can't be selected. ERROR:", e.getCause());
        }


    }

    @Step("Delete job title")
    public void deleteJobs() {
        Log.info("Delete selected job title.");
        try {
            DELETE_BTN.shouldBe(Condition.visible).click();
            DELETE_OK.should(Condition.exist).click();
            Log.info("Selected job titles were deleted.");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("Selected job titles weren't deleted. ERROR:", e.getCause());
        }

    }


}
