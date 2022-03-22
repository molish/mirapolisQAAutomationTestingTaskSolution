package org.example.pages;

import org.example.pages.locators.LoginPageLocator;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = LoginPageLocator.FORGOT_PASSWORD_BUTTON_CSS_SELECTOR)
    private WebElement forgotPasswordButton;

    @FindBy(css = LoginPageLocator.LOGIN_FORM_CSS_SELECTOR)
    private WebElement loginForm;

    @FindBy(css = LoginPageLocator.LOGIN_INPUT_CSS_SELECTOR)
    private WebElement loginInputField;

    @FindBy(css = LoginPageLocator.PASSWORD_INPUT_CSS_SELECTOR)
    private WebElement passwordInputField;

    @FindBy(css = LoginPageLocator.LOGIN_BUTTON_CSS_SELECTOR)
    private WebElement loginButton;

    @FindBy(css = LoginPageLocator.SHOW_PASSWORD_BUTTON_CSS_SELECTOR)
    private WebElement showPasswordButton;

    public LoginPage checkAlertMessagePresence() {
        Assert.assertTrue("На странице не обнаружено никаких всплывающих уведомлений",
                isAlertMessagePresented());
        return this;
    }

    public LoginPage checkLoginFormPresence() {
        Assert.assertTrue("На странице не обнаружена форма логина(Login Form)",
                isElementPresented(By.cssSelector(LoginPageLocator.LOGIN_FORM_CSS_SELECTOR)));
        return this;
    }

    public LoginPage checkInputLoginFieldPresence() {
        Assert.assertTrue("На странице не обнаружена поле ввода логина(Login input)",
                isElementPresented(By.cssSelector(LoginPageLocator.LOGIN_INPUT_CSS_SELECTOR)));
        return this;
    }

    public LoginPage checkInputPasswordFieldPresence() {
        Assert.assertTrue("На странице не обнаружена поле ввода пароля( Password input)",
                isElementPresented(By.cssSelector(LoginPageLocator.PASSWORD_INPUT_CSS_SELECTOR)));
        return this;
    }

    public LoginPage checkLoginButtonPresence() {
        Assert.assertTrue("На странице не обнаружена кнопка входа(Login button)",
                isElementPresented(By.cssSelector(LoginPageLocator.LOGIN_BUTTON_CSS_SELECTOR)));
        return this;
    }

    public LoginPage checkShowPasswordButtonPresence() {
        Assert.assertTrue("На странице не обнаружена кнопка показать пароль(Show password button)",
                isElementPresented(By.cssSelector(LoginPageLocator.SHOW_PASSWORD_BUTTON_CSS_SELECTOR)));
        return this;
    }

    public LoginPage inputLogin(String login) {
        loginInputField.sendKeys(login);
        return this;
    }

    public LoginPage inputPassword(String password) {
        passwordInputField.sendKeys();
        return this;
    }


    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    public LoginPage ckickShowPasswordBtn() {
        showPasswordButton.click();
        return this;
    }

    public LoginPage checkAlertMessageEqualsTo(String message){
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals("Выведенное сообщение: " + alertText +
                "\n не совпадает с ожидаемым сообщением: " + message, message, alertText);
        alert.accept();
        return this;
    }

    public LoginPage checkInputPasswordFieldAttributeTypeBecome(String value){
        Assert.assertEquals("Ожидалось что тип поля password станет:" + value +
                ", но оно оказолось: " + passwordInputField.getAttribute("type")
                ,passwordInputField.getAttribute("type"), value);
        return this;
    }

    public LoginPage checkForgotPasswordButtonPresence(){
        Assert.assertTrue("На странице не обнаружена ссылка восстановления пароля",
                isElementPresented(By.cssSelector(LoginPageLocator.FORGOT_PASSWORD_BUTTON_CSS_SELECTOR)));
        return this;
    }

    public LoginPage clickForgotPasswordButton(){
        forgotPasswordButton.click();
        return this;
    }
}
