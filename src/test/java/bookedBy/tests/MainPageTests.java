package bookedBy.tests;

import bookedBy.pages.FormPage;
import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class MainPageTests extends TestBase {
    @Test
    @DisplayName("Page should have main text")
    @Owner("Tanya")
    @Story("Main page is working")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://www.bookedby.com")
    @Tag("all")
    @Tag("smoke")
    public void checkTitleTest() {

        step("Open main page", () -> {

            open("https://www.bookedby.com");
        });
        step("Check information", () -> {
            $(FormPage.titleInfo).shouldHave(text("Book services"));
            $(FormPage.titleInfo).shouldHave(text("from anywhere"));
            $(FormPage.covidInfo).shouldHave(text("Information from BookedBy regarding Coronavirus (COVID-19)"));
        });

    }

    @Test
    @DisplayName("Page with features should be opened by button 'Learn more'")
    @Owner("Tanya")
    @Story("Main page is working")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://www.bookedby.com")
    @Tag("all")
    @Tag("smoke")
    public void featurePageIsOpenedTest() {

        step("Open main page", () -> {

            open("https://www.bookedby.com");
        });
        step("Click button 'learn more'", () -> {
            $(".tn-elem__1306442671569498562442").click();
        });
        step("Page with features is opened", () -> {
            webdriver().shouldHave(url("https://www.bookedby.com/features"));
        });
        step("Check filter fields", () -> {
            $(FormPage.filterFields).shouldHave(text("Salons"));
            $(FormPage.filterFields).shouldHave(text("Cell Phones"));
            $(FormPage.filterFields).shouldHave(text("Spas"));
            $(FormPage.filterFields).shouldHave(text("Vets"));
            $(FormPage.filterFields).shouldHave(text("Psychologist"));
            $(FormPage.filterFields).shouldHave(text("Dentist"));

        });
    }

    @Test
    @DisplayName("Check feature's list for Cell Phones")
    @Owner("Tanya")
    @Story("Main page is working")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://www.bookedby.com")
    @Tag("all")
    public void checkCellPhonesFeaturesTest() {


        step("Open features page", () -> {
            open("https://www.bookedby.com/features");
        });
        step("Open Cell Phones features", () -> {
            $(byText("Cell Phones")).
                    shouldBe(Condition.and("clickable", visible, enabled));
            $(byText("Cell Phones")).click();
        });
        step("Page with Cell Phones features is opened", () -> {
            webdriver().shouldHave(url("https://www.bookedby.com/features-cellphones"));
        });
        step("Check filter fields", () -> {
            $(FormPage.allrecords).shouldHave(text("Inventory Management"));
            $(FormPage.allrecords).shouldHave(text("Security"));
            $(FormPage.allrecords).shouldHave(text("Sales / POS"));
            $(FormPage.allrecords).shouldHave(text("Email Marketing"));

        });
    }

    @Test
    @DisplayName("Check feature's list for Psychologist")
    @Owner("Tanya")
    @Story("Main page is working")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://www.bookedby.com")
    @Tag("all")
    public void checkPsychologistFeaturesTest() {


        step("Open features page", () -> {

            open("https://www.bookedby.com/features");
        });
        step("Open Psychologist features", () -> {
            $(FormPage.psychologist).shouldBe(Condition.and("clickable", visible, enabled));
            $(FormPage.psychologist).click();
        });
        step("Page with Psychologist features is opened", () -> {
            webdriver().shouldHave(url("https://www.bookedby.com/features-psychologist"));
        });
        step("Check filter fields", () -> {
            $(FormPage.allrecords).shouldNotHave(text("Inventory Management"));
            $(FormPage.allrecords).shouldHave(text("Security"));
            $(FormPage.allrecords).shouldHave(text("Sales / POS"));
            $(FormPage.allrecords).shouldHave(text("Email Marketing"));


        });
    }

    @Test
    @DisplayName("Open form for demo request")
    @Owner("Tanya")
    @Story("Main page is working")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://www.bookedby.com")
    @Tag("all")
    @Tag("smoke")
    public void checkGetADemoFormIsOpenedTest() {


        step("Open features page", () -> {
            open("https://www.bookedby.com/features");
        });

        $(byXpath(FormPage.buttonDemo)).
                shouldBe(Condition.and("clickable", visible, enabled));

        step("Click button 'schedule a demo'", () -> {
            $(byXpath(FormPage.buttonDemo)).click();
        });
        step("Check form is opened", () -> {
            $(FormPage.demoTitle).shouldHave(text("Get a Demo"));
            $(FormPage.demoText).shouldHave(text("Get to know our software"));
        });
    }

    @Test
    @DisplayName("Submit isn't available without all completed required fields")
    @Owner("Tanya")
    @Story("Main page is working")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://www.bookedby.com")
    @Tag("all")
    @Tag("smoke")
    public void checkSubmitIsNotAvailableWithoutALLRequiredFieldsOnDemoFormTest() {

        step("Open features page", () -> {
            open("https://www.bookedby.com/features");
        });

        $(byXpath(FormPage.buttonDemo)).
                shouldBe(Condition.and("clickable", visible, enabled));

        step("Click button 'schedule a demo'", () -> {
            $(byXpath(FormPage.buttonDemo)).click();
        });
        step("Click submit", () -> {
            $(FormPage.submit).click();
        });
        step("Check error message", () -> {
            $(FormPage.error).isDisplayed();
        });
    }

    @Test
    @DisplayName("Submit  isn't available without Phone")
    @Owner("Tanya")
    @Story("Main page is working")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://www.bookedby.com")
    @Tag("all")
    public void checkSubmitIsNotAvailableWithoutPhoneOnDemoFormTest() {

        step("Open features page", () -> {
            open("https://www.bookedby.com/features");
        });
        step("Click button 'schedule a demo'", () -> {
            $(byXpath(FormPage.buttonDemo)).click();
        });
        step("input name on 'get a demo'", () -> {
            $(byXpath(FormPage.formNameField)).setValue("Rick Morty");
        });
        step("input email on 'get a demo'", () -> {
            $(byXpath(FormPage.formEmailField)).setValue("RickMorty10987443@mail.com");
        });
        step("input business name on 'get a demo'", () -> {
            $(byXpath(FormPage.formSalonNameField)).setValue("RickMorty10987443@mail.com");
        });
        step("input current software on 'get a demo'", () -> {
            $(byXpath(FormPage.formInputField)).setValue("10 times ago");
        });
        step("Click submit", () -> {
            $(FormPage.submit).click();
        });
        step("Check error message", () -> {
            $(FormPage.error).isDisplayed();
        });
    }

    @Test
    @DisplayName("Submit isn't available without Name")
    @Owner("Tanya")
    @Story("Main page is working")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://www.bookedby.com")
    @Tag("all")
    public void checkSubmitIsNotAvailableWithoutNameOnDemoFormTest() {

        step("Open features page", () -> {
            open("https://www.bookedby.com/features");
        });
        step("Click button 'schedule a demo'", () -> {
            $(byXpath(FormPage.buttonDemo)).click();
        });
        step("input Phone on 'get a demo'", () -> {
            $(byXpath(FormPage.formPhoneField)).setValue("1234567890");
        });
        step("input name on 'get a demo'", () -> {
            $(byXpath(FormPage.formEmailField)).setValue("RickMorty10987443@mail.com");
        });
        step("input business name on 'get a demo'", () -> {
            $(byXpath(FormPage.formSalonNameField)).setValue("RickHair");
        });
        step("input current software on 'get a demo'", () -> {
            $(byXpath(FormPage.formInputField)).setValue("10 times ago");
        });
        step("Click submit", () -> {
            $(FormPage.submit).click();
        });
        step("Check error message", () -> {
            $(FormPage.error).isDisplayed();
        });
    }

    @Test
    @DisplayName("Submit button isn't available without E-mail")
    @Owner("Tanya")
    @Story("Main page is working")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://www.bookedby.com")
    @Tag("all")
    public void checkSubmitIsNotAvailableWithoutEmailOnDemoFormTest() {

        step("Open features page", () -> {
            open("https://www.bookedby.com/features");
        });
        step("Click button 'schedule a demo'", () -> {
            $(byXpath(FormPage.buttonDemo)).click();
        });

        $(byXpath("//*[@id=\"form130869567\"]//*[@name=\"Name\"]")).
                shouldBe(Condition.and("clickable", visible, enabled));

        step("input name on 'get a demo'", () -> {
            $(byXpath(FormPage.formNameField)).setValue("Rick Morty");
        });
        step("input Phone on 'get a demo'", () -> {
            $(byXpath(FormPage.formPhoneField)).setValue("1234567890");
        });
        step("input business name on 'get a demo'", () -> {
            $(byXpath(FormPage.formSalonNameField)).setValue("RickHair");
        });
        step("input current software on 'get a demo'", () -> {
            $(byXpath(FormPage.formInputField)).setValue("10 times ago");
        });
        step("Click submit", () -> {
            $(FormPage.submit).click();
        });
        step("Check error message", () -> {
            $(FormPage.error).isDisplayed();
        });
    }

    @Test
    @DisplayName("Submit isn't available with incorrect E-mail")
    @Owner("Tanya")
    @Story("Main page is working")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://www.bookedby.com")
    @Tag("all")
    public void checkSubmitIsNotAvailableWithIncorrectEmailTest() {

        step("Open features page", () -> {
            open("https://www.bookedby.com/features");
        });
        step("Click button 'schedule a demo'", () -> {
            $(byXpath(FormPage.buttonDemo)).
                    shouldBe(Condition.and("clickable", visible, enabled));
            $(byXpath(FormPage.buttonDemo)).click();
        });

        $(byXpath(FormPage.formNameField)).
                shouldBe(Condition.and("clickable", visible, enabled));

        step("input name on 'get a demo'", () -> {
            $(byXpath(FormPage.formNameField)).setValue("Rick Morty");
        });
        step("input Phone on 'get a demo'", () -> {
            $(byXpath(FormPage.formPhoneField)).setValue("1234567890");
        });
        step("input business name on 'get a demo'", () -> {
            $(byXpath(FormPage.formEmailField)).setValue("RickHair");
        });
        step("Click submit", () -> {
            $(FormPage.submit).click();
        });
        step("Check error message", () -> {
            $(FormPage.error).isDisplayed();
        });
    }

    @AfterEach
    public void afterEach() {
        closeWebDriver();
    }
}