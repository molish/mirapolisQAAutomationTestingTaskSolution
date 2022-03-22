# Mirapolis QA Automation Test task solution

Задача:

* Написать ui тесты на проверку работы функциональности страницы входа в систему.
* Страница входа расположена по адресу
  https://lmslite47vr.demo.mirapolis.ru/mira

Требования:

* Реализовать нужно на языке Java. Версию можно использовать любую.
* Для сборки проекта можно использовать maven или gradle.
* Нужно использовать библиотеку selenium-api или selenide или selenidejava.
* Количество тестов вы должны определить сами.
* Тесты должны запускаться через junit или testng, не через main.

Использованные инструменты:

* Junit 5
* selenium web driver 4.0.0
* WebDriverManager https://github.com/bonigarcia/webdrivermanager

Структура проекта:

* основной пакет: org.example
    * pages - содержит пакеты и классы описания страниц необходимых при выполнении тестирования страниц
      * attributesconstants - пакет содержит файлы с константами которые описывают возможные значения веб элементов страниц
        * TypeAttributesValues - класс, который содержит константы значений аттрибута веб "type" вею элементов
      * locators - содержит классы с константами локаторов для поиска вэб элементов на страницах
        * ForgotPasswordPageLocator - локаторы для поиска элементов на странице восстановления пароля
        * LoginPageLocator - локаторы для поиска элемента на странице входа
        * UserMainPageLocator - локаторы для поиска элементов на странице авторизованного пользователя
      * LoginPage - класс описание страницы входа
      * UserMainPage - класс описание главной страницы авторизованного пользователя
      * ForgotPasswordPage - класс описание страницы восстановления пароля
      * BasePage - супер класс описания страниц, содержащий методы общие для большинства страниц
    * tests - содержит непосредственно классы тестов
        * BaseTest - базовый класс содержащий в себе поля и методы необходимые для запуска тестов из классов
          ForgotPasswordTest и LoginUserTest
        * ForgotPasswordTest - тестовый класс, наследующийся от класса BaseTest, содержит в себе следующие тест кейсы:
            * userCanGoToForgotPasswordPageTest - пользователь может перейти на страницу восстановления пароля
            * userInputExistingLoginAndSeeSuccessMessageTest - пользователь вводит логин существующего пользователя и
              получает сообщение об успешной отправке на его почту ссылки для восстановления пароля
            * userInputNonExistingLoginAndSeeAlertMessage - пользователь вводит логин не существующего пользователя и
              получает сообщение о том что такого пользователя не существует
            * userCanGoBackToLoginPage - пользователь может вернуться на страницу входа со страницы восстановления
              пароля
        * LoginUserTest - тестовый класс, наследующийся от BaseTest, содержит в себе следующие тест кейсы:
            * userCanLoginTest - пользователь вводит логин и пароль и успешно авторизуется на сайте
            * userSeeAlertWhenPasswordWrongTest - пользователь вводит неправильный пароль и видит всплывающее сообщение о том что его данные для авторизации неверны
            * userCanSeeInputingPasswordTest - пользователь нажимает на кнопку (показать пароль) и может видеть вводимые им в поле пароля символы
            * userDontInputLoginTest - пользователь вводит только пароль и видит всплывающее собщение о том что его данные для авторизации неверны
            * userDontInputPasswordTest - пользователь вводит только логи и видит сообщение о том что его данные для авторизации неверны
    * util - содержит вспомогательные классы для выполнения тестов
        * ConfProperties - класс для считывания данных из файла conf.properties
* resources 
  * conf.properties - файл содержащий необходимые данные для запуска тестов, такие как:
    * ссылка стартовой страницы
    * верный логин
    * верный пароль
    * неверный логин
    * неверный пароль