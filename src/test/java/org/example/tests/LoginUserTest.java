package org.example.tests;

import org.example.pages.UserMainPage;
import org.example.pages.attributesconstants.TypeAttributeValues;
import org.example.util.ConfProperties;
import org.junit.Test;

public class LoginUserTest extends BaseTest {

    private static final String WRONG_DATA_FOR_AUTH_MESSAGE = "Неверные данные для авторизации.";
    private static final String TESTED_USER_NAME = "Фомина Елена Сергеевна";

    @Test
    public void userCanLoginTest() {
        loginPage.checkLoginFormPresence()
                .checkInputLoginFieldPresence()
                .checkInputPasswordFieldPresence()
                .checkLoginButtonPresence()
                .inputLogin(ConfProperties.getProperty("login"))
                .inputPassword(ConfProperties.getProperty("password"))
                .clickLoginButton();
        UserMainPage userMainPage = new UserMainPage(loginPage.driver);
        userMainPage.checkUserAvatarPresence()
                .checkUserNamePresence()
                .checkUserNameIs(TESTED_USER_NAME);
    }

    @Test
    public void userSeeAlertWhenPasswordWrongTest() {
        loginPage.checkLoginFormPresence()
                .checkInputLoginFieldPresence()
                .checkInputPasswordFieldPresence()
                .checkLoginButtonPresence()
                .inputLogin(ConfProperties.getProperty("login"))
                .inputPassword(ConfProperties.getProperty("wrongPassword"))
                .clickLoginButton()
                .checkAlertMessagePresence()
                .checkAlertMessageEqualsTo(WRONG_DATA_FOR_AUTH_MESSAGE);
    }

    @Test
    public void userCanSeeInputingPasswordTest() {
        loginPage.checkLoginFormPresence()
                .checkInputPasswordFieldPresence()
                .checkShowPasswordButtonPresence()
                .ckickShowPasswordBtn()
                .checkInputPasswordFieldAttributeTypeBecome(TypeAttributeValues.TEXT);
    }

    @Test
    public void userDontInputLoginTest() {
        loginPage.checkLoginFormPresence()
                .checkInputPasswordFieldPresence()
                .inputPassword(ConfProperties.getProperty("password"))
                .clickLoginButton()
                .checkAlertMessagePresence()
                .checkAlertMessageEqualsTo(WRONG_DATA_FOR_AUTH_MESSAGE);
    }

    @Test
    public void userDontInputPasswordTest() {
        loginPage.checkLoginFormPresence()
                .checkInputLoginFieldPresence()
                .inputLogin(ConfProperties.getProperty("login"))
                .clickLoginButton()
                .checkAlertMessagePresence()
                .checkAlertMessageEqualsTo(WRONG_DATA_FOR_AUTH_MESSAGE);
    }

}
