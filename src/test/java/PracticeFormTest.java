import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest extends TestBase {

    @Test
    void succesfulFormTests() {
        open("/automation-practice-form");
        $("#firstName").setValue("Roman");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("roman@ivi.ru");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("8999655666");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("2027");
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__day--019").click();
        $("#subjectsInput").setValue("E");
        $$("[role='option']").get(0).shouldBe(visible).click();
        $("#subjectsInput").clear();
        $("#subjectsInput").setValue("H");
        $$("[role='option']").get(0).shouldBe(visible).click();
        $("#hobbies-checkbox-3").click();
        $("#uploadPicture").uploadFromClasspath("photo.jpg");
        $("#currentAddress").setValue("Москва, проспект Андропова");
        $("#state").click();
        $("#react-select-3-option-1").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();

        $(".modal-content").shouldBe(visible);
        $x("//tr[td[text()='Student Name']]/td[2]").shouldHave(text("Roman Ivanov"));
        $x("//tr[td[text()='Student Email']]/td[2]").shouldHave(text("roman@ivi.ru"));
        $x("//tr[td[text()='Gender']]/td[2]").shouldHave(text("Male"));
        $x("//tr[td[text()='Mobile']]/td[2]").shouldHave(text("8999655666"));
        $x("//tr[td[text()='Date of Birth']]/td[2]").shouldHave(text("19 May,2027"));
        $x("//tr[td[text()='Subjects']]/td[2]").shouldHave(text("English, Hindi"));
        $x("//tr[td[text()='Hobbies']]/td[2]").shouldHave(text("Music"));
        $x("//tr[td[text()='Picture']]/td[2]").shouldHave(text("photo.jpg"));
        $x("//tr[td[text()='Address']]/td[2]").shouldHave(text("Москва, проспект Андропова"));
        $x("//tr[td[text()='State and City']]/td[2]").shouldHave(text("Uttar Pradesh Lucknow"));

    }
        @Test
        void succesfulRequiredFieldsTests() {
            open("/automation-practice-form");
            $("#firstName").setValue("Roman");
            $("#lastName").setValue("Ivanov");
          //  $("#userEmail").setValue("roman@ivi.ru");
            $("#gender-radio-2").click();
            $("#userNumber").setValue("8999655666");
            $("#submit").click();

            $(".modal-content").shouldBe(visible);
            $x("//tr[td[text()='Student Name']]/td[2]").shouldHave(text("Roman Ivanov"));
           // $x("//tr[td[text()='Student Email']]/td[2]").shouldHave(text("roman@ivi.ru"));
            $x("//tr[td[text()='Gender']]/td[2]").shouldHave(text("Female"));
            $x("//tr[td[text()='Mobile']]/td[2]").shouldHave(text("8999655666"));


    }





}
