package org.example.pages;

import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public WebDriver driver;
    private static final int DEFAULT_TIMEOUT = 4;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * Метод проверки наличия alert на странице
     *
     * @param timeout - время ожидания появления элемента
     */

    protected boolean isAlertMessagePresented(int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (NoAlertPresentException noAlertPresentException) {
            return false;
        } catch (TimeoutException timeoutException){
            return false;
        }
    }


    /**
     * Метод проверки наличия alert на странице
     */
    protected boolean isAlertMessagePresented(){
        return isAlertMessagePresented(DEFAULT_TIMEOUT);
    }


    /**
     * Метод проверки наличия элемента на странице
     *
     * @param locator - локатор элемента
     * @param timeout - время ожидания появления элемента
     */
    protected boolean isElementPresented(By locator, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (NoSuchElementException noSuchElementException) {
            return false;
        } catch (TimeoutException timeoutException) {
            return false;
        }
    }

    /**
     * Метод проверки наличия элемента на странице с таймаутом по умолчанию равным 4 секундам
     *
     * @param locator - локатор элемента
     */
    protected boolean isElementPresented(By locator) {
        return isElementPresented(locator, DEFAULT_TIMEOUT);
    }
}
