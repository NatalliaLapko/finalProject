import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.Log;

import static com.codeborne.selenide.Selenide.$;

public class RecruitmentTab {

    public static SelenideElement CANDIDATE = $("#menu_recruitment_viewCandidates");
    public static SelenideElement VACANCY = $("#candidateSearch_jobVacancy");
    public static SelenideElement ADD_BTN = $("#btnAdd");
    public static SelenideElement FIRSTNAME = $("#addCandidate_firstName");
    public static SelenideElement MIDDLE_NAME = $("#addCandidate_middleName");
    public static SelenideElement LASTNAME = $("#addCandidate_lastName");
    public static SelenideElement EMAIL = $("#addCandidate_email");
    public static SelenideElement CONTACT_NO = $("#addCandidate_contactNo");
    public static SelenideElement JOB_VACANCY = $("#addCandidate_vacancy");
    public static SelenideElement RESUME = $("#addCandidate_resume");
    public static SelenideElement KEYWORDS = $("#addCandidate_keyWords");
    public static SelenideElement COMMENT = $("#addCandidate_comment");
    public static SelenideElement DATE_OF_APP = $("#addCandidate_appliedDate");
    public static SelenideElement CONSENT_TO_KEEP_DATA_CHB = $("#addCandidate_consentToKeepData");
    public static SelenideElement HEAD = $("div.head");
    public static SelenideElement SAVE_BTN = $("#btnSave");

    String firstName = "John";
    String middleName = "Paul";
    String lastName = "Jefferson";
    String vacancy = "Senior QA Lead";
    String candidateName = firstName + " " + lastName;
    String file = "C:\\Users\\USER\\finalProject\\src\\main\\resources\\Testing file.docx";  // по возможности вынести в отдельный класс или проперти

    public void goToRecruitmentTab() {
        MainPage.RECRUITMENT_TAB.click();
    }

    public void goToCandidateTab() {
        CANDIDATE.click();
    }

    @Step("Add new candidate")
    public void addCandidate() {
        Log.info("Add candidate via Recruitments Tab");
        try{
            ADD_BTN.shouldBe(Condition.visible).click();
            FIRSTNAME.should(Condition.exist).setValue(firstName);
            MIDDLE_NAME.setValue(middleName);
            LASTNAME.should(Condition.exist).setValue(lastName);
            EMAIL.should(Condition.exist).setValue("email@email.com");
            CONTACT_NO.setValue("123456789");
            JOB_VACANCY.selectOptionContainingText(vacancy);
            RESUME.sendKeys(file);
            KEYWORDS.setValue("QA");
            COMMENT.setValue("TestTestTest TestTestTest");
            DATE_OF_APP.setValue("2021-02-03");
            CONSENT_TO_KEEP_DATA_CHB.click();
            SAVE_BTN.click();
            Log.info("The candidate was added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error("The candidate wasn't added. ERROR: ", e.getCause());
        }

    }

    @Step("Verify firstname of the candidate")
    public String getFirstNameValue() {
        return FIRSTNAME.getValue();
    }

    @Step("Verify lastname of the candidate")
    public String getLastNameValue() {
        return LASTNAME.getValue();

    }


}
