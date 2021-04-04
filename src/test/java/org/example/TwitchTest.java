package org.example;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
public class TwitchTest {
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;


    @BeforeClass
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        //создание экземпляра драйвера
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        //окно разворачивается на полный экран
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //получение ссылки на страницу входа из файла настроек
        driver.get(ConfProperties.getProperty("loginpage"));
    }


    @Test
    public void loginTest() throws InterruptedException {

        loginPage.goToLogin();
        loginPage.inputLogin("123");
        Thread.sleep(3000);
        String error = loginPage.getError();

        String expectedErrorMessage = "*Имя пользователя должно содержать от 4 до 25 символов.";
        Assert.assertEquals(expectedErrorMessage, error);
    }


    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}