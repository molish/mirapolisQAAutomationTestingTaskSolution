package org.example.tests;

import org.example.pages.ForgotPasswordPage;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ForgotPasswordTest extends BaseTest{

    @Test
    public void userCanGoToForgotPasswordPageTest(){
        loginPage.checkLoginFormPresence()
                .checkForgotPasswordButtonPresence()
                .clickForgotPasswordButton();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(loginPage.driver);
        forgotPasswordPage.checkInputLoginFormPresence();
    }

    @ParameterizedTest
    @CsvSource({"fominaelena"})
    @Test
    public void userInputExistingLoginAndSeeSuccessMessageTest(String login){
        loginPage.checkLoginFormPresence()
                .checkForgotPasswordButtonPresence()
                .clickForgotPasswordButton();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(loginPage.driver);
        forgotPasswordPage.checkInputLoginFormPresence()
                .checkInputLoginFieldPresence()
                .checkSendButtonPresence()
                .inputLogin(login)
                .clickSendButton()
                .checkSuccessMessagePresence();
    }

    @ParameterizedTest
    @CsvSource({"invalidlogin"})
    @Test
    public void userInputNonExistingLoginAndSeeAlertMessage(String login){
        loginPage.checkLoginFormPresence()
                .checkForgotPasswordButtonPresence()
                .clickForgotPasswordButton();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(loginPage.driver);
        forgotPasswordPage.checkInputLoginFormPresence()
                .checkInputLoginFieldPresence()
                .checkSendButtonPresence()
                .inputLogin(login)
                .clickSendButton()
                .checkAlertMessagePresence();
    }

    @Test
    public void userCanGoBackToLoginPage(){
        loginPage.checkLoginFormPresence()
                .checkForgotPasswordButtonPresence()
                .clickForgotPasswordButton();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(loginPage.driver);
        forgotPasswordPage.checkInputLoginFormPresence()
                .clickBackToLoginPageButton();
        loginPage.checkLoginFormPresence();
    }

}
