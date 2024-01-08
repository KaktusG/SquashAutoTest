package com.sellego;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver =driver;
    }
    /**
     * определение локаторов полей ввода логина, пароля и кнопки Войти
     */
    @FindBy(xpath = "//input[@id='loginform-email']")
    private WebElement loginField;

    @FindBy(xpath = "//*[contains(@id, 'loginform-password')]")
    private WebElement passwdField;

    @FindBy(xpath = "//*[contains(@name, 'login-button')]")
    private WebElement loginBtn;
    /**
     * методы ввода логина и пароля
     */
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }
    public void inputPasswd(String password) {
        passwdField.sendKeys(password);
    }
    /**
     * Метод для нажатия по кнопке
     */
    public void clickLoginBtn() {
        loginBtn.click();
    }
}
