package org.example.pages;

import org.example.pages.locators.ForgotPasswordPageLocator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPasswordPage extends BasePage {

    private final static int TIMEOUT = 5;

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ForgotPasswordPageLocator.BACK_TO_LOGIN_PAGE_LINK_CSS_SELECTOR)
    private WebElement backToLoginPageButton;

    @FindBy(css = ForgotPasswordPageLocator.INPUT_LOGIN_FIELD_CSS_SELECTOR)
    private WebElement inputLoginField;

    @FindBy(css = ForgotPasswordPageLocator.INPUT_LOGIN_FORM_CSS_SELECTOR)
    private WebElement inputLoginForm;

    @FindBy(css = ForgotPasswordPageLocator.SEND_BUTTON_CSS_SELECTOR)
    private WebElement sendButton;

    @FindBy(css = ForgotPasswordPageLocator.ALERT_MESSAGE_CSS_SELECTOR)
    private WebElement alertMessage;

    @FindBy(css = ForgotPasswordPageLocator.SUCCESS_MESSAGE_CSS_LOCATOR)
    private WebElement successMessage;

    public ForgotPasswordPage inputLogin(String login) {
        inputLoginField.sendKeys(login);
        return this;
    }

    public ForgotPasswordPage clickSendButton(){
        sendButton.click();
        return this;
    }

    public ForgotPasswordPage clickBackToLoginPageButton(){
        backToLoginPageButton.click();
        return this;
    }

    public ForgotPasswordPage checkInputLoginFormPresence() {
        Assert.assertTrue("На странице отсутствует форма для ввода и отправки логина",
                isElementPresented(By.cssSelector(ForgotPasswordPageLocator.INPUT_LOGIN_FORM_CSS_SELECTOR),
                        TIMEOUT));
        return this;
    }

    public ForgotPasswordPage checkInputLoginFieldPresence() {
        Assert.assertTrue("На странице отсутствует форма для ввода логина",
                isElementPresented(By.cssSelector(ForgotPasswordPageLocator.INPUT_LOGIN_FIELD_CSS_SELECTOR),
                        TIMEOUT));
        return this;
    }

    public ForgotPasswordPage checkBackToLoginPagePresence() {
        Assert.assertTrue("На странице отсутствует ссылка для перехода на страницу входа",
                isElementPresented(By.cssSelector(ForgotPasswordPageLocator.BACK_TO_LOGIN_PAGE_LINK_CSS_SELECTOR),
                        TIMEOUT));
        return this;
    }

    public ForgotPasswordPage checkSendButtonPresence() {
        Assert.assertTrue("На странице отсутствует кнопка для отправки",
                isElementPresented(By.cssSelector(ForgotPasswordPageLocator.SEND_BUTTON_CSS_SELECTOR),
                        TIMEOUT));
        return this;
    }

    public ForgotPasswordPage checkAlertMessagePresence() {
        Assert.assertTrue("На странице отсутствует сообщение о том что такой пользователь не найден",
                isElementPresented(By.cssSelector(ForgotPasswordPageLocator.ALERT_MESSAGE_CSS_SELECTOR),
                        TIMEOUT));
        return this;
    }

    public ForgotPasswordPage checkSuccessMessagePresence() {
        Assert.assertTrue("На странице отсутствует уведомление о том," +
                        " что письмо для восстановления успешно отправлено",
                isElementPresented(By.cssSelector(ForgotPasswordPageLocator.SUCCESS_MESSAGE_CSS_LOCATOR),
                        TIMEOUT));
        return this;
    }


}
