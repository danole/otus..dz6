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


