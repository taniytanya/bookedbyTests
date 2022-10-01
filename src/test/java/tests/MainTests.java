package tests;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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



}