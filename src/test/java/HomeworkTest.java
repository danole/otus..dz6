import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeworkTest extends BaseHomeworkClass {

    @Test
    public void writeAboutMeTest() {

        signUp();

        WebElement headerRight = waitToClickableButton("//div[@class='header2-menu__item" +
                " header2-menu__item_small" +
                " header2-menu__item_dropdown" +
                " header2-menu__item_dropdown_no-border']");
        headerRight.click();
        logger.info("Открыли меню профиля");

        WebElement myProfile = waitToVisibleElement("//a[@href='/lk/biography/personal/']");
        myProfile.click();
        logger.info("Нажали на кнопку \"Мой профиль\"");

        WebElement name = waitToVisibleElement("//input[@name='fname']");
        name.clear();
        name.sendKeys("Тест");
        logger.info("Очистили меню \"Имя\" и ввели значение заново");

        WebElement nameEng = waitToVisibleElement("//input[@name='fname_latin']");
        nameEng.clear();
        nameEng.sendKeys("Test");
        logger.info("Очистили меню \"Имя на латинице\" и ввели значение заново");

        WebElement surname = waitToVisibleElement("//input[@name='lname']");
        surname.clear();
        surname.sendKeys("Тестович");
        logger.info("Очистили меню \"Фамилия\" и ввели значение заново");

        WebElement surnameEng = waitToVisibleElement("//input[@name='lname_latin']");
        surnameEng.clear();
        surnameEng.sendKeys("Testovich");
        logger.info("Очистили меню \"Фамилия на латинице\" и ввели значение заново");

        WebElement blogName = waitToVisibleElement("//input[@name='blog_name']");
        blogName.clear();
        blogName.sendKeys("Test");
        logger.info("Очистили меню \"Имя в блоге\" и ввели значение заново");

        WebElement dateOfBirth = waitToVisibleElement("//input[@name='date_of_birth']");
        dateOfBirth.clear();
        dateOfBirth.sendKeys("11.09.1990");
        logger.info("Очистили меню \"Дата рождения\" и ввели значение заново");

        WebElement country = waitToVisibleElement("//div[@class='select" +
                " lk-cv-block__input " +
                "lk-cv-block__input_full " +
                "js-lk-cv-dependent-master" +
                " js-lk-cv-custom-select']/*/*[2]");
        country.click();
        logger.info("Нажали на кнопку \"Страна\" ");

        WebElement countryButton = waitToClickableButton("//button[@title='Россия']");
        countryButton.click();
        logger.info("Выбрали страну");

        WebElement city = waitToClickableButton("//div[@class='select" +
                " lk-cv-block__input" +
                " lk-cv-block__input_full " +
                "js-lk-cv-dependent-slave-city" +
                " js-lk-cv-custom-select']/*[1]/*[2]");
        city.click();
        logger.info("Нажали на кнопку \"Город\"");

        WebElement cityButton = waitToVisibleElement("//button[@title='Санкт-Петербург']");
        cityButton.click();
        logger.info("Выбрали город");

        WebElement engLevel = waitToVisibleElement("//div[@class='select" +
                " lk-cv-block__input" +
                " lk-cv-block__input_full" +
                " js-lk-cv-custom-select']");
        engLevel.click();
        logger.info("Нажали на кнопку \"Уровень английского\"");

        WebElement engLevelButton = waitToClickableButton("//button[@title='Элементарный уровень (Elementary)']");
        engLevelButton.click();
        logger.info("Выбрали уровень английского");

        WebElement readyToMovingFirst = waitToVisibleElement("//label[@class='radio" +
                " radio_light4" +
                " radio_size-sm" +
                " radio_vertical-center" +
                " lk-cv-block__radio'][1]");
        readyToMovingFirst.click();
        logger.info("Нажали на кнопку \"Готовность к переезду - нет\"");

        WebElement readyToMovingSecond = waitToVisibleElement("//label[@class='radio" +
                " radio_light4" +
                " radio_size-sm" +
                " radio_vertical-center" +
                " lk-cv-block__radio'][2]");
        readyToMovingSecond.click();
        logger.info("Нажали на кнопку \"Готовность к переезду - да\"");

        WebElement workFormat = waitToVisibleElement("//input[@title='Полный день']/..");
        WebElement workFormatHide = driver.findElement(By.xpath("//input[@title='Полный день']"));
        boolean workFormatSelect = workFormatHide.isSelected();
        movingTheCheckboxToThePressedPosition(workFormatSelect, workFormat);
        logger.info("Выключили и включили кнопку \"Формат работы - полный день\"");

        WebElement FlexibleSchedule = waitToVisibleElement("//input[@title='Гибкий график']/..");
        WebElement FlexibleScheduleHide = driver.findElement(By.xpath("//input[@title='Гибкий график']"));
        boolean FlexibleScheduleSelect = FlexibleScheduleHide.isSelected();
        movingTheCheckboxToThePressedPosition(FlexibleScheduleSelect, FlexibleSchedule);
        logger.info("Выключили и включили кнопку \"Формат работы - гибкий график\"");

        WebElement remotely = waitToVisibleElement("//input[@title='Удаленно']/..");
        WebElement remotelyHide = driver.findElement(By.xpath("//input[@title='Удаленно']"));
        boolean remotelySelect = remotelyHide.isSelected();
        movingTheCheckboxToThePressedPosition(remotelySelect, remotely);
        logger.info("Выключили и включили кнопку \"Формат работы - удаленно\"");

        List<WebElement> communicationMethod = driver.findElements(By.xpath("//div[@class='container__col container__col_12 container__col_middle']"));
        WebElement communicationMethodButton = waitToVisibleElement("//button[@class='lk-cv-block__action " +
                "lk-cv-block__action_md-no-spacing js-formset-add" +
                " js-lk-cv-custom-select-add']");

        if (communicationMethod.size() < 2) {   //Если полей "Способ связи" меньше двух, то добавляет еще одно
            communicationMethodButton.click();
        }

        List<WebElement> communicationMethodInputs = driver.findElements(By.xpath("//div[@class='input " +
                "input_full" +
                " lk-cv-block__input " +
                "input_straight-bottom-right" +
                " input_straight-top-right" +
                " input_no-border-right " +
                "lk-cv-block__input_fake" +
                " lk-cv-block__input_select-fake" +
                " js-custom-select-presentation']"));

        WebElement communicationMethodInputFirst = communicationMethodInputs.get(0);
        communicationMethodInputFirst.click();
        logger.info("Нажали на первую кнопку \"Способ связи\"");

        List<WebElement> vkButton = driver.findElements(By.xpath("//button[@title='VK']"));
        WebElement vkButtonFirst = vkButton.get(0);
        vkButtonFirst.click();
        logger.info("Выбрали ВК в первой кнопке \"Способ связи\"");

        WebElement communicationMethodTextFirst = driver.findElement(By.xpath("//input[@id='id_contact-0-value']"));
        communicationMethodTextFirst.clear();
        communicationMethodTextFirst.sendKeys("https://vk.com/id1");
        logger.info("Очистили первое поле ввода \"Способ связи\" и заполнили данные ");

        WebElement communicationMethodInputSecond = communicationMethodInputs.get(1);
        communicationMethodInputSecond.click();
        List<WebElement> whatsappButton = driver.findElements(By.xpath("//button[@title='WhatsApp']"));
        WebElement whatsappButtonSecond = whatsappButton.get(1);
        whatsappButtonSecond.click();
        logger.info("Выбрали whatsapp во второй кнопке \"Способ связи\"");

        WebElement communicationMethodTextSecond = driver.findElement(By.xpath("//input[@id='id_contact-1-value']"));
        communicationMethodTextSecond.clear();
        communicationMethodTextSecond.sendKeys("whatsappContact");
        logger.info("Очистили второе поле ввода \"Способ связи\" и заполнили данные ");

        WebElement gender = waitToClickableButton("//select[@name='gender']");
        gender.click();
        logger.info("Нажали на кнопку \"Пол\"");

        WebElement genderM = waitToClickableButton("//option[@value='m']");
        genderM.click();
        logger.info("Выбрали мужской пол");

        WebElement company = waitToVisibleElement("//input[@name='company']");
        company.clear();
        company.sendKeys("Otus");
        logger.info("Очистили поле ввода \"Компания\" и заполнили данные ");


        WebElement position = waitToVisibleElement("//input[@name='work']");
        position.clear();
        position.sendKeys("qa engineer");
        logger.info("Очистили поле ввода \"Должность\" и заполнили данные ");

        WebElement developmentAdd = waitToClickableButton("//a[@title='Добавить']");
        developmentAdd.click();
        logger.info("Добавили поле \"Опыт разработки\" ");

        List<WebElement> experienceRow = driver.findElements(By.xpath("//div[@class='experience-row js-formset-row']"));

        if (experienceRow.size() > 1) {                        //Если строк "Опыт разработки больше 1ой, то удаляет лишнее"
            List<WebElement> deleteExpRow = driver.findElements(By.xpath("//div[@class='experience-row__remove ic-close js-formset-delete']"));
            WebElement deleteExpRowSecond = deleteExpRow.get(1);
            deleteExpRowSecond.click();
        }


        WebElement expSelect = waitToClickableButton("//select[@name='experience-0-experience']");
        expSelect.click();

        WebElement phpSelect = waitToClickableButton("//option[@value='11']");
        phpSelect.click();
        logger.info("Выбрали PHP в \"Опыт разработки\" ");

        WebElement expLevel = waitToClickableButton("//select[@name='experience-0-level']");
        expLevel.click();

        WebElement expLevelSelect = waitToClickableButton("//select[@name='experience-0-level']/*[2]");
        expLevelSelect.click();
        logger.info("Выбрали 1 год в \"Опыт разработки\" ");

        Assert.assertEquals("Имя не совпадает!", "Тест", name.getAttribute("value"));
        Assert.assertEquals("Имя на латинице не совпадает!", "Test", nameEng.getAttribute("value"));
        Assert.assertEquals("Фамилия не совпадает!", "Тестович", surname.getAttribute("value"));
        Assert.assertEquals("Фамилия на латинице не совпадает!", "Testovich", surnameEng.getAttribute("value"));
        Assert.assertEquals("Дата рождения не совпадает!", "11.09.1990", dateOfBirth.getAttribute("value"));
        Assert.assertEquals("Страна не совпадает!", "Россия", country.getText());
        Assert.assertEquals("Город не совпадает!", "Санкт-Петербург", city.getText());
        Assert.assertEquals("Готовность к переезду- не нажато да", true, readyToMovingSecond.isEnabled());
        Assert.assertEquals("Формат работы - полный день, не включена", true, workFormatSelect);
        Assert.assertEquals("Формат работы - гибкий график, не включена", true, FlexibleScheduleSelect);
        Assert.assertEquals("Формат работы - удаленно, не включена", true, remotelySelect);
        Assert.assertEquals("Контакт ВК не совпадает!", "https://vk.com/id1", communicationMethodTextFirst.getAttribute("value"));
        Assert.assertEquals("Контакт WhatsApp не совпадает!", "whatsappContact", communicationMethodTextSecond.getAttribute("value"));
        Assert.assertEquals("Пол мужской не выбран!", true, genderM.isSelected());
        Assert.assertEquals("Компания не совпадает!", "Otus", company.getAttribute("value"));
        Assert.assertEquals("Должность не совпадает!", "qa engineer", position.getAttribute("value"));
        Assert.assertEquals("Опыт разработки- PHP, не выбран!", true, phpSelect.isSelected());
        Assert.assertEquals("Опыт разработки- 1 год, не выбран!", true, expLevelSelect.isSelected());
        logger.info("Все Assert'ы совпали ");

        WebElement saveAndContinue = waitToClickableButton("//button[@title='Сохранить и продолжить']");
        saveAndContinue.click();
        logger.info("Сохранили ");

        end();

        startUp();

        signUp();

    }
}
