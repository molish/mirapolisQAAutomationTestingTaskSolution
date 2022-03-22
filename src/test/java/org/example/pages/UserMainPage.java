package org.example.pages;

import org.example.pages.locators.UserMainPageLocator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserMainPage extends BasePage {

    public UserMainPage(WebDriver driver) {
        super(driver);
    }

    private static final int BASE_LOADING_TIMEOUT = 10;

    @FindBy(css = UserMainPageLocator.USER_AVATAR_CSS_SELECTOR)
    private WebElement userAvatar;

    @FindBy(css = UserMainPageLocator.USER_NAME_CSS_SELECTOR)
    private WebElement userName;

    public UserMainPage checkUserAvatarPresence() {
        Assert.assertTrue("На странице не обнаружен аватар пользователя",
                isElementPresented(By.cssSelector(UserMainPageLocator.USER_AVATAR_CSS_SELECTOR), BASE_LOADING_TIMEOUT));
        return this;
    }

    public UserMainPage checkUserNamePresence() {
        Assert.assertTrue("На странице не обнаружено поле с именем пользователя",
                isElementPresented(By.cssSelector(UserMainPageLocator.USER_NAME_CSS_SELECTOR), BASE_LOADING_TIMEOUT));
        return this;

    }

    public UserMainPage checkUserNameIs(String userName) {
        Assert.assertEquals("Отображаемое имя не совпадает с ожидаемым", userName, this.userName.getText());
        return this;
    }

}
