import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.Log;

import static com.codeborne.selenide.Selenide.$;

public class PimTab {

    public static SelenideElement ODIS = $("[href $='/empNumber/2']");
    public static SelenideElement FIRST_NAME = $("#personal_txtEmpFirstName");
    public static SelenideElement LAST_NAME = $("#personal_txtEmpLastName");
    public static SelenideElement EMPLOYEE_ID = $("#personal_txtEmployeeId");
    public static SelenideElement DATE_OF_BIRTH = $("#personal_DOB");
    public static SelenideElement MALE_RADIO = $("#personal_optGender_1");
    public static SelenideElement FEMALE_RADIO = $("#personal_optGender_2");
    public static SelenideElement DRIVER_LICENSE_NUMBER = $("#personal_txtLicenNo");
    public static SelenideElement LICENSE_EXPIRY_DATE = $("#personal_txtLicExpDate");
    public static SelenideElement NATIONALITY = $("#personal_cmbNation");
    public static SelenideElement MARITAL_STATUS = $("#personal_cmbMarital");
    public static SelenideElement EMPLOYEE_PHOTO = $("#empPic");
    public static SelenideElement SMOKER_FLAG = $("#personal_chkSmokeFlag");


    @Step("Verify user")
    public void verifyUser() {
        Log.info("Verify user form");
        try {
            FIRST_NAME.shouldBe(Condition.visible).shouldNotBe(Condition.empty);
            LAST_NAME.shouldBe(Condition.visible).shouldNotBe(Condition.empty);
            EMPLOYEE_ID.shouldBe(Condition.visible).shouldNotBe(Condition.empty);
            EMPLOYEE_PHOTO.shouldBe(Condition.image);
            MALE_RADIO.shouldBe(Condition.checked);
            FEMALE_RADIO.shouldBe(Condition.disabled);
            Log.info("The form was verified and meet the requirements.");
        } catch (Exception e) {
            e.printStackTrace();
            Log.error(e.getMessage());
        }
    }

    @Step("Go to the PIM tab")
    public void goToPimTab() {
        MainPage.PIM_TAB.click();

    }

    @Step("Open Odis profile page")
    public void openOdisPage() {
        ODIS.click();
    }

    @Step("Verify firstname")
    public String getFirstName() {
        return FIRST_NAME.getValue();
    }

    @Step("Verify lastname")
    public String getLastName() {
        return LAST_NAME.getValue();
    }

    @Step("Verify employee ID")
    public String getEmployeeID() {
        return EMPLOYEE_ID.getValue();
    }

    @Step("Verify the date of birth")
    public String getDateOfBirth() {
        return DATE_OF_BIRTH.getValue();
    }

    @Step("Verify driver license number")
    public String getDriverLicenseNumber() {
        return DRIVER_LICENSE_NUMBER.getValue();
    }

    @Step("Verify license expiry date")
    public String getLicenseExpiryDate() {
        return LICENSE_EXPIRY_DATE.getValue();
    }

    @Step("Verify nationality")
    public String getNationality() {
        return NATIONALITY.getSelectedText();
    }

    @Step("Verify marital status")
    public String getMaritalStatus() {
        return MARITAL_STATUS.getSelectedText();
    }


}
