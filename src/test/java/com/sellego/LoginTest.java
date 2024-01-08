package com.sellego;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    public static LoginPage loginPage;
    public static DashboardPage dashboardPage;
    public static WebDriver driver;

    /**
     * осуществление первоначальной настройки
     */

    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройки
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        //окно разворачивани на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу Login
        driver.get(ConfProperties.getProperty("loginpage"));
    }
    /**
     * тестовый метод для осуществления аутентификации
     */
    @Test
    public void loginTest() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        String welcomeTxt = dashboardPage.getDashboardTitle();
        Assert.assertEquals("Дашборд Sellego", welcomeTxt);
    }
    /**
     * осуществление выхода из аккаунта с последующим закрытием окна браузера
     */
    @AfterClass
    public static void tearDown() {
        dashboardPage.entryMenu();
        dashboardPage.userLogout();
        driver.quit();
    }
}
