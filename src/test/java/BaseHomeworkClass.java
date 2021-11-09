import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseHomeworkClass {

    protected Logger logger = LogManager.getLogger(HomeworkTest.class.getName());
    protected static WebDriver driver;

    protected void signUp(){
        driver.get("https://otus.ru");
        logger.info("Открылся браузер, перешли на сайт");

        WebElement registrationModalWindow = waitToClickableButton("//button[@class='header2__auth js-open-modal']");
        registrationModalWindow.click();
        logger.info("Открылось модальное окно для регистрации ");

        WebElement email = waitToVisibleElement("//input[@type='text' and @name='email' and @autocomplete='off']");
        WebElement password = waitToVisibleElement("//input[@name='password']");
        WebElement submit = waitToClickableButton("//button[@class='new-button new-button_full new-button_blue new-button_md']");
        String passwordProp = System.getProperty("password");
        String loginProp = System.getProperty("login");
        email.sendKeys(loginProp);
        password.sendKeys(passwordProp);
        submit.submit();
        logger.info("Вошли в личный кабинет");
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

    @AfterEach
    protected void end() {
        if (driver != null) {
            driver.quit();
        }
    }
}


