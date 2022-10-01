package tests;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.FormPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.qameta.allure.Allure.step;


public class MainTests {




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
            $(FormPage.TITLE_INFO).shouldHave(text("Book services"));
            $(FormPage.TITLE_INFO).shouldHave(text("from anywhere"));
            $(FormPage.COVID_INFO).shouldHave(text("Information from BookedBy regarding Coronavirus (COVID-19)"));
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
            $(FormPage.FILTER_FIELDS).shouldHave(text("Salons"));
            $(FormPage.FILTER_FIELDS).shouldHave(text("Cell Phones"));
            $(FormPage.FILTER_FIELDS).shouldHave(text("Spas"));
            $(FormPage.FILTER_FIELDS).shouldHave(text("Vets"));
            $(FormPage.FILTER_FIELDS).shouldHave(text("Psychologist"));
            $(FormPage.FILTER_FIELDS).shouldHave(text("Dentist"));

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
            $(byText("Cell Phones")).click();
        });
        step("Page with Cell Phones features is opened", () -> {
            webdriver().shouldHave(url("https://www.bookedby.com/features-cellphones"));
        });
        step("Check filter fields", () -> {
            $(FormPage.ALLRECORDS).shouldHave(text("Inventory Management"));
            $(FormPage.ALLRECORDS).shouldHave(text("Security"));
            $(FormPage.ALLRECORDS).shouldHave(text("Sales / POS"));
            $(FormPage.ALLRECORDS).shouldHave(text("Email Marketing"));

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
            $(FormPage.PSYCHOLOGIST).click();
        });
        step("Page with Psychologist features is opened", () -> {
            webdriver().shouldHave(url("https://www.bookedby.com/features-psychologist"));
        });
        step("Check filter fields", () -> {
            $(FormPage.ALLRECORDS).shouldNotHave(text("Inventory Management"));
            $(FormPage.ALLRECORDS).shouldHave(text("Security"));
            $(FormPage.ALLRECORDS).shouldHave(text("Sales / POS"));
            $(FormPage.ALLRECORDS).shouldHave(text("Email Marketing"));


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

        $(byXpath(FormPage.BUTTON_DEMO)).
                shouldBe(Condition.and("clickable", visible, enabled));

        step("Click button 'schedule a demo'", () -> {
            $(byXpath(FormPage.BUTTON_DEMO)).click();
        });
        step("Check form is opened", () -> {
            $(FormPage.DEMO_TITLE).shouldHave(text("Get a Demo"));
            $(FormPage.DEMO_TEXT).shouldHave(text("Get to know our software"));
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

        $(byXpath(FormPage.BUTTON_DEMO)).
                shouldBe(Condition.and("clickable", visible, enabled));

        step("Click button 'schedule a demo'", () -> {
            $(byXpath(FormPage.BUTTON_DEMO)).click();
        });
        step("Click submit", () -> {
            $(FormPage.SUBMIT).click();
        });
        step("Check error message", () -> {
            $(FormPage.ERROR).isDisplayed();
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
            $(byXpath(FormPage.BUTTON_DEMO)).click();
        });
        step("input name on 'get a demo'", () -> {
            $(byXpath(FormPage.FORM_NAME_FIELD)).setValue("Rick Morty");
        });
        step("input email on 'get a demo'", () -> {
            $(byXpath(FormPage.FORM_EMAIL_FIELD)).setValue("RickMorty10987443@mail.com");
        });
        step("input business name on 'get a demo'", () -> {
            $(byXpath(FormPage.FORM_SALON_NAME_FIELD)).setValue("RickMorty10987443@mail.com");
        });
        step("input current software on 'get a demo'", () -> {
            $(byXpath(FormPage.FORM_INPUT_FIELD)).setValue("10 times ago");
        });
        step("Click submit", () -> {
            $(FormPage.SUBMIT).click();
        });
        step("Check error message", () -> {
            $(FormPage.ERROR).isDisplayed();
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
            $(byXpath(FormPage.BUTTON_DEMO)).click();
        });
        step("input Phone on 'get a demo'", () -> {
            $(byXpath(FormPage.FORM_PHONE_FIELD)).setValue("1234567890");
        });
        step("input name on 'get a demo'", () -> {
            $(byXpath(FormPage.FORM_EMAIL_FIELD)).setValue("RickMorty10987443@mail.com");
        });
        step("input business name on 'get a demo'", () -> {
            $(byXpath(FormPage.FORM_SALON_NAME_FIELD)).setValue("RickHair");
        });
        step("input current software on 'get a demo'", () -> {
            $(byXpath(FormPage.FORM_INPUT_FIELD)).setValue("10 times ago");
        });
        step("Click submit", () -> {
            $(FormPage.SUBMIT).click();
        });
        step("Check error message", () -> {
            $(FormPage.ERROR).isDisplayed();
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
            $(byXpath(FormPage.BUTTON_DEMO)).click();
        });

        $(byXpath("//*[@id=\"form130869567\"]//*[@name=\"Name\"]")).
                shouldBe(Condition.and("clickable", visible, enabled));

        step("input name on 'get a demo'", () -> {
            $(byXpath(FormPage.FORM_NAME_FIELD)).setValue("Rick Morty");
        });
        step("input Phone on 'get a demo'", () -> {
            $(byXpath(FormPage.FORM_PHONE_FIELD)).setValue("1234567890");
        });
        step("input business name on 'get a demo'", () -> {
            $(byXpath(FormPage.FORM_SALON_NAME_FIELD)).setValue("RickHair");
        });
        step("input current software on 'get a demo'", () -> {
            $(byXpath(FormPage.FORM_INPUT_FIELD)).setValue("10 times ago");
        });
        step("Click submit", () -> {
            $(FormPage.SUBMIT).click();
        });
        step("Check error message", () -> {
            $(FormPage.ERROR).isDisplayed();
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
            $(byXpath(FormPage.BUTTON_DEMO)).click();
        });

        $(byXpath(FormPage.FORM_NAME_FIELD)).
                shouldBe(Condition.and("clickable", visible, enabled));

        step("input name on 'get a demo'", () -> {
            $(byXpath(FormPage.FORM_NAME_FIELD)).setValue("Rick Morty");
        });
        step("input Phone on 'get a demo'", () -> {
            $(byXpath(FormPage.FORM_PHONE_FIELD)).setValue("1234567890");
        });
        step("input business name on 'get a demo'", () -> {
            $(byXpath(FormPage.FORM_EMAIL_FIELD)).setValue("RickHair");
        });
        step("Click submit", () -> {
            $(FormPage.SUBMIT).click();
        });
        step("Check error message", () -> {
            $(FormPage.ERROR).isDisplayed();
        });
    }

    @AfterEach
    public void afterEach() {
        closeWebDriver();
    }


}