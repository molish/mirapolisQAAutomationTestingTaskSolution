package org.example.tests;

import org.example.pages.ForgotPasswordPage;
import org.example.util.ConfProperties;
import org.junit.Test;

public class ForgotPasswordTest extends BaseTest {

    @Test
    public void userCanGoToForgotPasswordPageTest() {
        loginPage.checkLoginFormPresence()
                .checkForgotPasswordButtonPresence()
                .clickForgotPasswordButton();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(loginPage.driver);
        forgotPasswordPage.checkInputLoginFormPresence();
    }

    @Test
    public void userInputExistingLoginAndSeeSuccessMessageTest() {
        loginPage.checkLoginFormPresence()
                .checkForgotPasswordButtonPresence()
                .clickForgotPasswordButton();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(loginPage.driver);
        forgotPasswordPage.checkInputLoginFormPresence()
                .checkInputLoginFieldPresence()
                .checkSendButtonPresence()
                .inputLogin(ConfProperties.getProperty("login"))
                .clickSendButton()
                .checkSuccessMessagePresence();
    }

    @Test
    public void userInputNonExistingLoginAndSeeAlertMessage() {
        loginPage.checkLoginFormPresence()
                .checkForgotPasswordButtonPresence()
                .clickForgotPasswordButton();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(loginPage.driver);
        forgotPasswordPage.checkInputLoginFormPresence()
                .checkInputLoginFieldPresence()
                .checkSendButtonPresence()
                .inputLogin(ConfProperties.getProperty("wrongLogin"))
                .clickSendButton()
                .checkAlertMessagePresence();
    }

    @Test
    public void userCanGoBackToLoginPage() {
        loginPage.checkLoginFormPresence()
                .checkForgotPasswordButtonPresence()
                .clickForgotPasswordButton();
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(loginPage.driver);
        forgotPasswordPage.checkInputLoginFormPresence()
                .clickBackToLoginPageButton();
        loginPage.checkLoginFormPresence();
    }

}
