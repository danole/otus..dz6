import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeworkTest extends BaseHomeworkClass {

    @Test
    public void writeAboutMeTest() throws InterruptedException {

        driver.get("https://otus.ru");
        logger.info("�������� �������, ������� �� ����");

        WebElement registrationModalWindow = waitToClickableButton("//button[@class='header2__auth js-open-modal']");
        registrationModalWindow.click();
        logger.info("��������� ��������� ���� ��� ����������� ");

        WebElement email = waitToVisibleElement("//input[@type='text' and @name='email' and @autocomplete='off']");
        WebElement password = waitToVisibleElement("//input[@name='password']");
        WebElement submit = waitToClickableButton("//button[@class='new-button new-button_full new-button_blue new-button_md']");
        String passwordProp=System.getProperty("password");
        String emailProp=System.getProperty("email");
        email.sendKeys(emailProp);
        password.sendKeys(passwordProp);
        submit.submit();

//        signUp(email, password, submit);
        logger.info("����� � ������ �������");

        WebElement headerRight = waitToClickableButton("//div[@class='header2-menu__item" +
                " header2-menu__item_small" +
                " header2-menu__item_dropdown" +
                " header2-menu__item_dropdown_no-border']");
        headerRight.click();
        logger.info("������� ���� �������");

        WebElement myProfile = waitToVisibleElement("//a[@href='/lk/biography/personal/']");
        myProfile.click();
        logger.info("������ �� ������ \"��� �������\"");

        WebElement name = waitToVisibleElement("//input[@name='fname']");
        name.clear();
        name.sendKeys("����");
        logger.info("�������� ���� \"���\" � ����� �������� ������");

        WebElement nameEng = waitToVisibleElement("//input[@name='fname_latin']");
        nameEng.clear();
        nameEng.sendKeys("Test");
        logger.info("�������� ���� \"��� �� ��������\" � ����� �������� ������");

        WebElement surname = waitToVisibleElement("//input[@name='lname']");
        surname.clear();
        surname.sendKeys("��������");
        logger.info("�������� ���� \"�������\" � ����� �������� ������");

        WebElement surnameEng = waitToVisibleElement("//input[@name='lname_latin']");
        surnameEng.clear();
        surnameEng.sendKeys("Testovich");
        logger.info("�������� ���� \"������� �� ��������\" � ����� �������� ������");

        WebElement blogName = waitToVisibleElement("//input[@name='blog_name']");
        blogName.clear();
        blogName.sendKeys("Test");
        logger.info("�������� ���� \"��� � �����\" � ����� �������� ������");

        WebElement dateOfBirth = waitToVisibleElement("//input[@name='date_of_birth']");
        dateOfBirth.clear();
        dateOfBirth.sendKeys("11.09.1990");
        logger.info("�������� ���� \"���� ��������\" � ����� �������� ������");

        WebElement country = waitToVisibleElement("//div[@class='select" +
                " lk-cv-block__input " +
                "lk-cv-block__input_full " +
                "js-lk-cv-dependent-master" +
                " js-lk-cv-custom-select']/*/*[2]");
        country.click();
        logger.info("������ �� ������ \"������\" ");

        WebElement countryButton = waitToClickableButton("//button[@title='������']");
        countryButton.click();
        logger.info("������� ������");

        WebElement city = waitToClickableButton("//div[@class='select" +
                " lk-cv-block__input" +
                " lk-cv-block__input_full " +
                "js-lk-cv-dependent-slave-city" +
                " js-lk-cv-custom-select']/*[1]/*[2]");
        city.click();
        logger.info("������ �� ������ \"�����\"");

        WebElement cityButton = waitToVisibleElement("//button[@title='�����-���������']");
        cityButton.click();
        logger.info("������� �����");

        WebElement engLevel = waitToVisibleElement("//div[@class='select" +
                " lk-cv-block__input" +
                " lk-cv-block__input_full" +
                " js-lk-cv-custom-select']");
        engLevel.click();
        logger.info("������ �� ������ \"������� �����������\"");

        WebElement engLevelButton = waitToClickableButton("//button[@title='������������ ������� (Elementary)']");
        engLevelButton.click();
        logger.info("������� ������� �����������");

        WebElement readyToMovingFirst = waitToVisibleElement("//label[@class='radio" +
                " radio_light4" +
                " radio_size-sm" +
                " radio_vertical-center" +
                " lk-cv-block__radio'][1]");
        readyToMovingFirst.click();
        logger.info("������ �� ������ \"���������� � �������� - ���\"");

        WebElement readyToMovingSecond = waitToVisibleElement("//label[@class='radio" +
                " radio_light4" +
                " radio_size-sm" +
                " radio_vertical-center" +
                " lk-cv-block__radio'][2]");
        readyToMovingSecond.click();
        logger.info("������ �� ������ \"���������� � �������� - ��\"");

        WebElement workFormat = waitToVisibleElement("//input[@title='������ ����']/..");
        WebElement workFormatHide = driver.findElement(By.xpath("//input[@title='������ ����']"));
        boolean workFormatSelect = workFormatHide.isSelected();
        movingTheCheckboxToThePressedPosition(workFormatSelect, workFormat);
        logger.info("��������� � �������� ������ \"������ ������ - ������ ����\"");

        WebElement FlexibleSchedule = waitToVisibleElement("//input[@title='������ ������']/..");
        WebElement FlexibleScheduleHide = driver.findElement(By.xpath("//input[@title='������ ������']"));
        boolean FlexibleScheduleSelect = FlexibleScheduleHide.isSelected();
        movingTheCheckboxToThePressedPosition(FlexibleScheduleSelect, FlexibleSchedule);
        logger.info("��������� � �������� ������ \"������ ������ - ������ ������\"");

        WebElement remotely = waitToVisibleElement("//input[@title='��������']/..");
        WebElement remotelyHide = driver.findElement(By.xpath("//input[@title='��������']"));
        boolean remotelySelect = remotelyHide.isSelected();
        movingTheCheckboxToThePressedPosition(remotelySelect, remotely);
        logger.info("��������� � �������� ������ \"������ ������ - ��������\"");

        List<WebElement> communicationMethod = driver.findElements(By.xpath("//div[@class='container__col container__col_12 container__col_middle']"));
        WebElement communicationMethodButton = waitToVisibleElement("//button[@class='lk-cv-block__action " +
                "lk-cv-block__action_md-no-spacing js-formset-add" +
                " js-lk-cv-custom-select-add']");

        if (communicationMethod.size() < 2) {   //���� ����� "������ �����" ������ ����, �� ��������� ��� ����
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
        logger.info("������ �� ������ ������ \"������ �����\"");

        List<WebElement> vkButton = driver.findElements(By.xpath("//button[@title='VK']"));
        WebElement vkButtonFirst = vkButton.get(0);
        vkButtonFirst.click();
        logger.info("������� �� � ������ ������ \"������ �����\"");

        WebElement communicationMethodTextFirst = driver.findElement(By.xpath("//input[@id='id_contact-0-value']"));
        communicationMethodTextFirst.clear();
        communicationMethodTextFirst.sendKeys("https://vk.com/id1");
        logger.info("�������� ������ ���� ����� \"������ �����\" � ��������� ������ ");

        WebElement communicationMethodInputSecond = communicationMethodInputs.get(1);
        communicationMethodInputSecond.click();
        List<WebElement> whatsappButton = driver.findElements(By.xpath("//button[@title='WhatsApp']"));
        WebElement whatsappButtonSecond = whatsappButton.get(1);
        whatsappButtonSecond.click();
        logger.info("������� whatsapp �� ������ ������ \"������ �����\"");

        WebElement communicationMethodTextSecond = driver.findElement(By.xpath("//input[@id='id_contact-1-value']"));
        communicationMethodTextSecond.clear();
        communicationMethodTextSecond.sendKeys("whatsappContact");
        logger.info("�������� ������ ���� ����� \"������ �����\" � ��������� ������ ");

        WebElement gender = waitToClickableButton("//select[@name='gender']");
        gender.click();
        logger.info("������ �� ������ \"���\"");

        WebElement genderM = waitToClickableButton("//option[@value='m']");
        genderM.click();
        logger.info("������� ������� ���");

        WebElement company = waitToVisibleElement("//input[@name='company']");
        company.clear();
        company.sendKeys("Otus");
        logger.info("�������� ���� ����� \"��������\" � ��������� ������ ");


        WebElement position = waitToVisibleElement("//input[@name='work']");
        position.clear();
        position.sendKeys("qa engineer");
        logger.info("�������� ���� ����� \"���������\" � ��������� ������ ");

        WebElement developmentAdd = waitToClickableButton("//a[@title='��������']");
        developmentAdd.click();
        logger.info("�������� ���� \"���� ����������\" ");

        List<WebElement> experienceRow = driver.findElements(By.xpath("//div[@class='experience-row js-formset-row']"));

        if (experienceRow.size() > 1) {                        //���� ����� "���� ���������� ������ 1��, �� ������� ������"
            List<WebElement> deleteExpRow = driver.findElements(By.xpath("//div[@class='experience-row__remove ic-close js-formset-delete']"));
            WebElement deleteExpRowSecond = deleteExpRow.get(1);
            deleteExpRowSecond.click();
        }


        WebElement expSelect = waitToClickableButton("//select[@name='experience-0-experience']");
        expSelect.click();

        WebElement phpSelect = waitToClickableButton("//option[@value='11']");
        phpSelect.click();
        logger.info("������� PHP � \"���� ����������\" ");

        WebElement expLevel = waitToClickableButton("//select[@name='experience-0-level']");
        expLevel.click();

        WebElement expLevelSelect = waitToClickableButton("//select[@name='experience-0-level']/*[2]");
        expLevelSelect.click();
        logger.info("������� 1 ��� � \"���� ����������\" ");

        Assert.assertEquals("��� �� ���������!","����",name.getAttribute("value"));
        Assert.assertEquals("��� �� �������� �� ���������!","Test",nameEng.getAttribute("value"));
        Assert.assertEquals("������� �� ���������!","��������",surname.getAttribute("value"));
        Assert.assertEquals("������� �� �������� �� ���������!","Testovich",surnameEng.getAttribute("value"));
        Assert.assertEquals("���� �������� �� ���������!","11.09.1990",dateOfBirth.getAttribute("value"));
        Assert.assertEquals("������ �� ���������!","������",country.getText());
        Assert.assertEquals("����� �� ���������!","�����-���������",city.getText());
        Assert.assertEquals("���������� � ��������- �� ������ ��",true,readyToMovingSecond.isEnabled());
        Assert.assertEquals("������ ������ - ������ ����, �� ��������",true,workFormatSelect);
        Assert.assertEquals("������ ������ - ������ ������, �� ��������",true,FlexibleScheduleSelect);
        Assert.assertEquals("������ ������ - ��������, �� ��������",true,remotelySelect);
        Assert.assertEquals("������� �� �� ���������!","https://vk.com/id1",communicationMethodTextFirst.getAttribute("value"));
        Assert.assertEquals("������� WhatsApp �� ���������!","whatsappContact",communicationMethodTextSecond.getAttribute("value"));
        Assert.assertEquals("��� ������� �� ������!",true,genderM.isSelected());
        Assert.assertEquals("�������� �� ���������!","Otus",company.getAttribute("value"));
        Assert.assertEquals("��������� �� ���������!","qa engineer",position.getAttribute("value"));
        Assert.assertEquals("���� ����������- PHP, �� ������!",true,phpSelect.isSelected());
        Assert.assertEquals("���� ����������- 1 ���, �� ������!",true,expLevelSelect.isSelected());
        logger.info("��� Assert'� ������� ");

        WebElement saveAndContinue = waitToClickableButton("//button[@title='��������� � ����������']");
        saveAndContinue.click();
        logger.info("��������� ");

    }


}
