package tests;


import helpers.AuthApi;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.AuthApi.authCookieKey;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class EditProfileTest extends TestBase {

    @Test
    void editUserProfileTest(){
        String valueId = "3116110",
                valueFirstName = "John",
                valueLastName = "Ivanov",
                valueEmail = "ivanov@test.ru",
                valueCompany = "Test",
                valueCountryId = "66",
                valueStateProvinceId = "0",
                valueCity = "Moscow",
                valueAddress1 = "Lenina",
                valueAddress2 = "RedSquare",
                valueZipPostalCode = "345",
                valuePhoneNumber = "777888",
                valueFaxNumber = "";

        String authCookieValue = authApi.getAuthCookie(login,password);

        given()
                .contentType("application/x-www-form-urlencoded")
                .cookie(authCookieKey,authCookieValue)
                .formParam("Address.Id", valueId)
                .formParam("Address.FirstName", valueFirstName)
                .formParam("Address.LastName", valueLastName)
                .formParam("Address.Email", valueEmail)
                .formParam("Address.Company", valueCompany)
                .formParam("Address.CountryId", valueCountryId)
                .formParam("Address.StateProvinceId", valueStateProvinceId)
                .formParam("Address.City", valueCity)
                .formParam("Address.Address1", valueAddress1)
                .formParam("Address.Address2", valueAddress2)
                .formParam("Address.ZipPostalCode", valueZipPostalCode)
                .formParam("Address.PhoneNumber", valuePhoneNumber)
                .formParam("Address.FaxNumber", valueFaxNumber)
                .when()
                .post("/customer/addressedit/3116110")
                .then()
                .log().all()
                .statusCode(302);

    }

//    @Test
//    void loginWithUITest() {
//        step("Open login page", () ->
//                open("/login"));
//        step("Fill login form", () -> {
//            $("#Email").setValue(login);
//            $("#Password").setValue(password).pressEnter();
//        });
//        step("Verify successful authorization", () ->
//                $(".account").shouldHave(text(login)));
//    }
//
//    @Test
//    void loginWithApiTest() {
//        step("Get auth cookie by api and set it in browser", () -> {
//                    String authCookieKey = "NOPCOMMERCE.AUTH";
//                    String authCookieValue = given()
//                            .contentType("application/x-www-form-urlencoded")
//                            .formParam("Email", login)
//                            .formParam("Password", password)
//                            .when()
//                            .post("/login")
//                            .then()
//                            .log().all()
//                            .statusCode(302)
//                            .extract()
//                            .cookie(authCookieKey);
//
//                    open("/Content/jquery-ui-themes/smoothness/images/ui-bg_flat_75_ffffff_40x100.png");
//                    Cookie authCookie = new Cookie(authCookieKey, authCookieValue);
//                    getWebDriver().manage().addCookie(authCookie);
//                });
//
//            step("Open main page", ()->
//                    open(""));
//            step("Verify successful authorization",() ->
//                    $(".account").shouldHave(text(login)));
//        }

    }

