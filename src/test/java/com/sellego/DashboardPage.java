package com.sellego;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    public WebDriver driver;
    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//h1[@class='dashboard-title']")
    private WebElement dashboardWelcome;

    /**
     * определение локатора кнопки выхода из аккаунта
     */
    @FindBy(xpath = "//header/div[1]/div[2]/div")
    private WebElement userMenu;

    @FindBy(xpath = "//header/div[1]/div[2]/div/div[2]/div[@class='material-dropdown-footer']")
    private WebElement logoutBtn;
    /**
     * метод для получения текста
     */
    public String getDashboardTitle() {
        String welcomeText = dashboardWelcome.getText();
        return welcomeText;
    }

    public void entryMenu() {
        userMenu.click();
    }
    public void userLogout() {
        logoutBtn.click();
    }
}
