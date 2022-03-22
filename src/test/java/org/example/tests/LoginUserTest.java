package org.example.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.LoginPage;
import org.example.pages.UserMainPage;
import org.example.pages.attributesconstants.TypeAttributeValues;
import org.example.util.ConfProperties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginUserTest extends BaseTest{

    @ParameterizedTest
    @CsvSource({"fominaelena, 1P73BP4Z, Фомина Елена Сергеевна"    })
    @Test
    public void userCanLoginTest(String userLogin, String userPassword, String expectedUserName){
        loginPage.checkLoginFormPresence()
                .checkInputLoginFieldPresence()
                .checkInputPasswordFieldPresence()
                .checkLoginButtonPresence()
                .inputLogin(userLogin)
                .inputPassword(userPassword)
                .clickLoginButton();
        UserMainPage userMainPage = new UserMainPage(loginPage.driver);
        userMainPage.checkUserAvatarPresence()
                .checkUserNamePresence()
                .checkUserNameIs(expectedUserName);
    }

    @ParameterizedTest
    @CsvSource({"fominaelena, wjnfiwofq, Неверные данные для авторизации.",
            "wedwedwedqf, 1P73BP4Z, Неверные данные для авторизации."
    })
    @Test
    public void userSeeAlertWhenPasswordOrLoginWrongTest(String userLogin, String userPassword, String expectedAlertMessage){
        loginPage.checkLoginFormPresence()
                .checkInputLoginFieldPresence()
                .checkInputPasswordFieldPresence()
                .checkLoginButtonPresence()
                .inputLogin(userLogin)
                .inputPassword(userPassword)
                .clickLoginButton()
                .checkAlertMessagePresence()
                .checkAlertMessageEqualsTo(expectedAlertMessage);
    }

    @Test
    public void userCanSeeInputingPasswordTest(){
        loginPage.checkLoginFormPresence()
                .checkInputPasswordFieldPresence()
                .checkShowPasswordButtonPresence()
                .ckickShowPasswordBtn()
                .checkInputPasswordFieldAttributeTypeBecome(TypeAttributeValues.TEXT);
    }

    @ParameterizedTest
    @CsvSource({"wjnfiwofq, Неверные данные для авторизации.",
            "1P73BP4Z, Неверные данные для авторизации."
    })
    @Test
    public void userDontInputLoginTest(String password, String expectedAlertMessage){
        loginPage.checkLoginFormPresence()
                .checkInputPasswordFieldPresence()
                .inputPassword(password)
                .clickLoginButton()
                .checkAlertMessagePresence()
                .checkAlertMessageEqualsTo(expectedAlertMessage);
    }

    @ParameterizedTest
    @CsvSource({"fominaelena, Неверные данные для авторизации.",
            "wedwedwedqf, Неверные данные для авторизации."
    })
    @Test
    public void userDontInputPasswordTest(String login, String expectedAlertMessage){
        loginPage.checkLoginFormPresence()
                .checkInputLoginFieldPresence()
                .inputLogin(login)
                .clickLoginButton()
                .checkAlertMessagePresence()
                .checkAlertMessageEqualsTo(expectedAlertMessage);
    }

}
