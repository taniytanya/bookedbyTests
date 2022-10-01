package tests;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
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


        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page", () -> {

            open("https://www.bookedby.com");
        });
        step("Check information", () -> {
            $(".t396__elem .tn-atom").shouldHave(text("Book services"));
            $(".t396__elem .tn-atom").shouldHave(text("from anywhere"));
            $(".t059__text-impact").shouldHave(text("Information from BookedBy regarding Coronavirus (COVID-19)"));
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


        SelenideLogger.addListener("allure", new AllureSelenide());

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
            $("#rec130438009.r.t-rec.r_showed.r_anim").shouldHave(text("Salons"));
            $("#rec130438009.r.t-rec.r_showed.r_anim").shouldHave(text("Cell Phones"));
            $("#rec130438009.r.t-rec.r_showed.r_anim").shouldHave(text("Spas"));
            $("#rec130438009.r.t-rec.r_showed.r_anim").shouldHave(text("Vets"));
            $("#rec130438009.r.t-rec.r_showed.r_anim").shouldHave(text("Psychologist"));
            $("#rec130438009.r.t-rec.r_showed.r_anim").shouldHave(text("Dentist"));

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


        SelenideLogger.addListener("allure", new AllureSelenide());

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
            $("#allrecords").shouldHave(text("Inventory Management"));
            $("#allrecords").shouldHave(text("Security"));
            $("#allrecords").shouldHave(text("Sales / POS"));
            $("#allrecords").shouldHave(text("Email Marketing"));

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


        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open features page", () -> {

            open("https://www.bookedby.com/features");
        });
        step("Open Psychologist features", () -> {
            $(".tn-elem__1304380091569901594620").click();
        });
        step("Page with Psychologist features is opened", () -> {
            webdriver().shouldHave(url("https://www.bookedby.com/features-psychologist"));
        });
        step("Check filter fields", () -> {
            $("#allrecords").shouldNotHave(text("Inventory Management"));
            $("#allrecords").shouldHave(text("Security"));
            $("#allrecords").shouldHave(text("Sales / POS"));
            $("#allrecords").shouldHave(text("Email Marketing"));


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
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open features page", () -> {
            open("https://www.bookedby.com/features");
        });
        step("Click button 'schedule a demo'", () -> {
            $(byXpath("//*[@data-elem-id=\"1562685805088\"]//*[@class=\"tn-atom\"]")).click();
        });
        step("Check form is opened", () -> {
            $("#rec130869567 .t702__title").shouldHave(text("Get a Demo"));
            $("#rec130869567 .t702__descr").shouldHave(text("Get to know our software"));
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
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open features page", () -> {
            open("https://www.bookedby.com/features");
        });
        step("Click button 'schedule a demo'", () -> {
            $(byXpath("//*[@data-elem-id=\"1562685805088\"]//*[@class=\"tn-atom\"]")).click();
        });
        step("Click submit", () -> {
            $("#rec130869567 .t-form__submit").click();
        });
        step("Check error message", () -> {
            $("#rec130869567 .t-form__errorbox-middle").isDisplayed();
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
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open features page", () -> {
            open("https://www.bookedby.com/features");
        });
        step("Click button 'schedule a demo'", () -> {
            $(byXpath("//*[@data-elem-id=\"1562685805088\"]//*[@class=\"tn-atom\"]")).click();
        });
        step("input name on 'get a demo'", () -> {
            $(byXpath("//*[@id=\"form130869567\"]//*[@name=\"Name\"]")).setValue("Rick Morty");
        });
        step("input email on 'get a demo'", () -> {
            $(byXpath("//*[@id=\"form130869567\"]//*[@name=\"Email\"]")).setValue("RickMorty10987443@mail.com");
        });
        step("input business name on 'get a demo'", () -> {
            $(byXpath("//*[@id=\"form130869567\"]//*[@name=\"Salon Name\"]")).setValue("RickMorty10987443@mail.com");
        });
        step("input current software on 'get a demo'", () -> {
            $(byXpath("//*[@id=\"form130869567\"]//*[@name=\"Input\"]")).setValue("10 times ago");
        });
        step("Click submit", () -> {
            $("#rec130869567 .t-form__submit").click();
        });
        step("Check error message", () -> {
            $("#rec130869567 .t-form__errorbox-middle").isDisplayed();
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
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open features page", () -> {
            open("https://www.bookedby.com/features");
        });
        step("Click button 'schedule a demo'", () -> {
            $(byXpath("//*[@data-elem-id=\"1562685805088\"]//*[@class=\"tn-atom\"]")).click();
        });
        step("input Phone on 'get a demo'", () -> {
            $(byXpath("//*[@id=\"form130869567\"]//*[@name=\"Phone\"]")).setValue("1234567890");
        });
        step("input name on 'get a demo'", () -> {
            $(byXpath("//*[@id=\"form130869567\"]//*[@name=\"Email\"]")).setValue("RickMorty10987443@mail.com");
        });
        step("input business name on 'get a demo'", () -> {
            $(byXpath("//*[@id=\"form130869567\"]//*[@name=\"Salon Name\"]")).setValue("RickHair");
        });
        step("input current software on 'get a demo'", () -> {
            $(byXpath("//*[@id=\"form130869567\"]//*[@name=\"Input\"]")).setValue("10 times ago");
        });
        step("Click submit", () -> {
            $("#rec130869567 .t-form__submit").click();
        });
        step("Check error message", () -> {
            $("#rec130869567 .t-form__errorbox-middle").isDisplayed();
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
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open features page", () -> {
            open("https://www.bookedby.com/features");
        });
        step("Click button 'schedule a demo'", () -> {
            $(byXpath("//*[@data-elem-id=\"1562685805088\"]//*[@class=\"tn-atom\"]")).click();
        });
        step("input name on 'get a demo'", () -> {
            $(byXpath("//*[@id=\"form130869567\"]//*[@name=\"Name\"]")).setValue("Rick Morty");
        });
        step("input Phone on 'get a demo'", () -> {
            $(byXpath("//*[@id=\"form130869567\"]//*[@name=\"Phone\"]")).setValue("1234567890");
        });
        step("input business name on 'get a demo'", () -> {
            $(byXpath("//*[@id=\"form130869567\"]//*[@name=\"Salon Name\"]")).setValue("RickHair");
        });
        step("input current software on 'get a demo'", () -> {
            $(byXpath("//*[@id=\"form130869567\"]//*[@name=\"Input\"]")).setValue("10 times ago");
        });
        step("Click submit", () -> {
            $("#rec130869567 .t-form__submit").click();
        });
        step("Check error message", () -> {
            $("#rec130869567 .t-form__errorbox-middle").isDisplayed();
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
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open features page", () -> {
            open("https://www.bookedby.com/features");
        });
        step("Click button 'schedule a demo'", () -> {
            $(byXpath("//*[@data-elem-id=\"1562685805088\"]//*[@class=\"tn-atom\"]")).click();
        });
        step("input name on 'get a demo'", () -> {
            $(byXpath("//*[@id=\"form130869567\"]//*[@name=\"Name\"]")).setValue("Rick Morty");
        });
        step("input Phone on 'get a demo'", () -> {
            $(byXpath("//*[@id=\"form130869567\"]//*[@name=\"Phone\"]")).setValue("1234567890");
        });
        step("input business name on 'get a demo'", () -> {
            $(byXpath("//*[@id=\"form130869567\"]//*[@name=\"Email\"]")).setValue("RickHair");
        });
        step("Click submit", () -> {
            $("#rec130869567 .t-form__submit").click();
        });
        step("Check error message", () -> {
            $("#rec130869567 .t-form__errorbox-middle").isDisplayed();
        });
    }


}