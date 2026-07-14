package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;



import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests extends TestBase {

    @Test
    void succesfulFillRormTests() {
        open("/automation-practice-form");
        $("#firstName").setValue("Roman");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("roman@ivi.ru");
        $("#userNumber").setValue("8999655666");
        $("#gender-radio-1").click();

        $("#subjectsInput").setValue("E");
        $$("[role='option']").get(0).shouldBe(visible).click();
        $("#subjectsInput").clear();
        $("#subjectsInput").setValue("H");
        $$("[role='option']").get(0).shouldBe(visible).click();
        $("#hobbies-checkbox-3").click();
        $("#uploadPicture").click();
        $("#currentAddress").setValue("Москва, проспект Андропова");

        $("#submit").click();

        $(".modal-content").shouldBe(visible);
        //  $("tbody tr:first-child td:last-child").shouldHave(text("Roman Ivanov"));

    }
}
