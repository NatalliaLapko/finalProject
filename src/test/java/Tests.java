import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Tests {


    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    AdminTab adminTab = new AdminTab();
    RecruitmentTab recruitmentTab = new RecruitmentTab();
    LeaveTab leaveTab = new LeaveTab();
    Dashboard dashboard = new Dashboard();
    PimTab pim = new PimTab();



    @BeforeEach
    @DisplayName("LogIn")
    public void loginTest() {
        
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        loginPage.openLoginPage();
        loginPage.login();
        assertEquals(Links.DASHBOARD_URL, url(), "The page wou need wasn't opened!");
    }

    @AfterEach
    @DisplayName("LogOut")
    public void logoutTest() {
        mainPage.logout();
    }


    @Epic(value = "AdminTab feature")
    @Feature("Manipulations with user")
    @DisplayName("Add new user with verification")
    @Description(value = "New user creation with verification of form")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @Order(1)
    @Flaky
    public void addUserTest() {
        mainPage.goToAdminTab();
        adminTab.addUser();

        adminTab.createdUserSearch();
        adminTab.verifyCreatedUser();
        assertEquals(adminTab.userName, adminTab.getFoundUserName());
    }


    @Epic(value = "AdminTab")
    @Feature(value = "Manipulations with user")
    @DisplayName("Delete created user")
    @Description(value = "Finding created user by search and deleting him")
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Order(2)
    @Flaky
    public void deleteUserTest() {
        mainPage.goToAdminTab();
        adminTab.createdUserSearch();
        adminTab.deleteUser();
        AdminTab.RESULT_TABLE.find(By.linkText(adminTab.userName)).shouldNot(Condition.exist);

    }


    @Epic(value = "AdminTab")
    @Feature(value = "Manipulations with job")
    @Story(value = "adding jobTitle")
    @DisplayName("Create  jobTitle")
    @Description(value = "Create 3 job titles ")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @Order(3)

    public void addJobTitleTest() {
        mainPage.goToAdminTab();
        adminTab.goToJobTab();
        assertEquals(Links.VIEV_JOB_TITLES_LIST, url());
        adminTab.addJobTitle("QA");
        adminTab.addJobTitle("Java-developer");
        adminTab.addJobTitle("Manager");
        Assertions.assertAll(
                () -> assertEquals("QA", adminTab.getCreatedJobValue("QA")),
                () -> assertEquals("Java-developer", adminTab.getCreatedJobValue("Java-developer")),
                () -> assertEquals("Manager", adminTab.getCreatedJobValue("Manager"))
        );


    }


    @Epic(value = "AdminTab")
    @Feature(value = "Manipulations with job")
    @Story(value = "deleting jobTitle")
    @DisplayName("Delete job title")
    @Description(value = "Delete 3 job titles ")
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Order(4)

    public void deleteJobTitleTest() {
        mainPage.goToAdminTab();
        adminTab.goToJobTab();
        adminTab.findJobTitle("QA");
        adminTab.findJobTitle("Java-developer");
        adminTab.findJobTitle("Manager");

        adminTab.deleteJobs();
        AdminTab.RESULT_TABLE.find(By.linkText("QA")).shouldNot(Condition.exist);
        AdminTab.RESULT_TABLE.find(By.linkText("Java-developer")).shouldNot(Condition.exist);
        AdminTab.RESULT_TABLE.find(By.linkText("Manager")).shouldNot(Condition.exist);


    }


    @Epic(value = "Recruitment")
    @Feature(value = "Manipulations with candidates")
    @Story(value = "add candidate")
    @DisplayName("add candidate without verification")
    @Description(value = "Add candidate without  form verification")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @Order(5)
    public void addCandidateTest() {

        recruitmentTab.goToRecruitmentTab();
        recruitmentTab.goToCandidateTab();
        recruitmentTab.addCandidate();

        Assertions.assertAll(
                () -> assertEquals("John", recruitmentTab.getFirstNameValue()),
                () -> assertEquals("Jefferson", recruitmentTab.getLastNameValue())
        );


    }


    @Epic(value = "Leave")
    @Feature(value = "Manipulation with the leaves")
    @Story(value = "Assign Leave")
    @DisplayName("Assign Leave")
    @Description(value = "Assign leave with the form verification")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @Order(6)
    public void assignLeaveTest() {
        leaveTab.goToLeaveTab();
        leaveTab.assignLeave();
        leaveTab.fillLeaveForm();
        leaveTab.goToLeaveList();
        leaveTab.checkLeave();
        assertEquals(leaveTab.employeeName, leaveTab.checkLeave());
    }


    @Epic(value = "Dashboard")
    @DisplayName("Verify if all elements on the dashboard exist")
    @Description(value = "Check the elements on the Dashboard visibility")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @Order(7)
    public void doDashboardElementsExistTest() {

        dashboard.isElementsExist1();
        dashboard.isElementsExist2();
        dashboard.isElementsExist3();
        dashboard.isElementsExist4();
        Assertions.assertAll(
                () -> assertEquals("Employee Distribution by Subunit", dashboard.getDashPanelName()),
                () -> assertEquals("Legend", dashboard.getLegendPanelName()),
                () -> assertEquals("Pending Leave Requests", dashboard.getPendingLeaveRequestPanelName()),
                () -> assertEquals("Quick Launch", dashboard.getQuickLaunchPanelName())
        );

    }


    @Epic(value = "Dashboard")
    @DisplayName("Verify if all the quick links on the Quick Launch panel exist")
    @Description(value = "Check the accessibility of the links on the Quick Launch Panel")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    @Order(8)
    public void dashLinksVerificationTest() {
        dashboard.isElementsExist1();
        dashboard.verifyAssignLeaveLink();
        assertEquals(Links.ASSIGN_LEAVE, url());

        mainPage.goToDashboard();
        dashboard.verifyLeaveListLink();
        assertEquals(Links.LEAVE_LIST, url());

        mainPage.goToDashboard();
        dashboard.verifyTimesheetsLink();
        assertEquals(Links.TIMESHEETS, url());

        mainPage.goToDashboard();
        dashboard.verifyApplyLeaveLink();
        assertEquals(Links.APPLY_LEAVE, url());

        mainPage.goToDashboard();
        dashboard.verifyMyLeaveLink();
        assertEquals(Links.MY_LEAVE, url());

        mainPage.goToDashboard();
        dashboard.verifyMyTimesheetLink();
        assertEquals(Links.MY_TIMESHEET, url());

    }


    @Epic(value = "PIM")
    @DisplayName("Verify  data in the Odis's account")
    @Description(value = "Verify the form fields and the data of the Odis's account")
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Order(9)
    public void testOdisProfileTest() {

        pim.goToPimTab();
        pim.openOdisPage();
        pim.verifyUser();
        Assertions.assertAll(
                () -> assertEquals("Odis", pim.getFirstName()),
                () -> assertEquals("Adalwin", pim.getLastName()),
                () -> assertEquals("0002", pim.getEmployeeID()),
                () -> assertEquals("QZ45232222", pim.getDriverLicenseNumber()),
                () -> assertEquals("2016-02-01", pim.getLicenseExpiryDate()),
                () -> assertEquals("Married", pim.getMaritalStatus()),
                () -> assertEquals("American", pim.getNationality()),
                () -> assertEquals("1980-05-05", pim.getDateOfBirth()),
                () -> assertEquals(true, PimTab.MALE_RADIO.isSelected()),
                () -> assertEquals(false, PimTab.FEMALE_RADIO.isSelected()),
                () -> assertEquals(false, PimTab.SMOKER_FLAG.isSelected())
        );


    }


}
