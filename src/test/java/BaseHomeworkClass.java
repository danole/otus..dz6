import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class BaseHomeworkClass {

    protected Logger logger = LogManager.getLogger(HomeworkTest.class.getName());
    protected static WebDriver driver;

    protected void signUp(WebElement element1, WebElement element2, WebElement element3) {
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/test/resources/config.properties");
            property.load(fis);

            String login = property.getProperty("login");
            String password = property.getProperty("password");

            System.out.println("LOGIN: " + login
                    + ", PASSWORD: " + password);

            element1.sendKeys(login);
            element2.sendKeys(password);
            element3.submit();

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }
    }



    @BeforeEach
    protected void startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }

    //Создает WebElement c явным ожиданием на кликабельность
    protected WebElement waitToClickableButton(String xpath) {
        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        return element;
    }

    //Создает WebElement c явным ожиданием на видимость элемента в DOM дереве
    protected WebElement waitToVisibleElement(String xpath) {
        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }

    //Функция, которая проверяет, нажата ли кнопка, если нажата - кликает по ней 2 раза, если нет- 1 раз.
    protected void movingTheCheckboxToThePressedPosition(boolean select, WebElement element) {
        if (select == true) {
            element.click();
            element.click();
        } else {
            element.click();
        }
    }

//    @AfterEach
//    protected void end(){
//        if (driver!=null) {
//            driver.quit();
//        }
//    }
}
