ДЗ 6

Цель:
В результате выполнения дз вы реализуете автоматический тест, используя Java + Selenium

Шаги теста:

Открыть https://otus.ru
Авторизоваться на сайте
Войти в личный кабинет
В разделе "О себе" заполнить все поля "Личные данные" и добавить не менее двух контактов
Нажать сохранить
Открыть https://otus.ru в "чистом браузере"
Авторизоваться на сайе
Войти в личный кабинет

Запуск через
mvn clean test -Dlogin="login" -Dpassword="password"
