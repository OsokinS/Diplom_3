package tests;

import com.codeborne.selenide.Configuration;
import com.model.FakeUser;
import com.model.User;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPageBurger;
import pages.RegisterPage;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest {

    public static final String url = "https://stellarburgers.nomoreparties.site/";

    @Before
    public void setUp (){
        Configuration.browserSize = "1920x1080";
    }
    @After
    public void tearDown (){
        webdriver().driver().close();
    }

    @DisplayName("Успешная регистрация с паролем 7 символов")
    @Test
    public void successRegistrationWithPass7Char(){
        FakeUser fake = FakeUser.getRandom(7);
        //открывается страница и создаётся экземпляр класса страницы
        MainPageBurger mainPage = open(url, MainPageBurger.class);// перейди на страницу тестового стенда
        mainPage.clickInAcc();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegister();
        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.goRegister(fake.getName(), fake.getEmail(),fake.getPassword());
        LoginPage loginPage1 = page(LoginPage.class);
        loginPage1.login(fake.getEmail(),fake.getPassword());
        MainPageBurger main = page(MainPageBurger.class);
        main.checkHasButtonAndText();
    }

    @DisplayName("Успешная регистрация с паролем 6 символов")
    @Test
    public void successRegistrationWithPass6Char(){
        FakeUser fake = FakeUser.getRandom(6);
        //открывается страница и создаётся экземпляр класса страницы
        MainPageBurger mainPage = open(url, MainPageBurger.class);// перейди на страницу тестового стенда
        mainPage.clickInAcc();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegister();
        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.goRegister(fake.getName(), fake.getEmail(),fake.getPassword());
        LoginPage loginPage1 = page(LoginPage.class);
        loginPage1.login(fake.getEmail(),fake.getPassword());
        MainPageBurger main = page(MainPageBurger.class);
        main.checkHasButtonAndText();
    }

    @DisplayName("Неуспешная регистрация с паролем менее 6 символов")
    @Test
    public void unsuccessRegistrationWithPass5Char(){
        FakeUser fake = FakeUser.getRandom(5);
        MainPageBurger mainPage = open(url, MainPageBurger.class);
        mainPage.clickInAcc();
        LoginPage loginPage = page(LoginPage.class);
        loginPage.clickRegister();
        RegisterPage registerPage = page(RegisterPage.class);
        registerPage.goRegister(fake.getName(), fake.getEmail(),fake.getPassword());
        registerPage.checkErr();
        registerPage.checkHeader();
    }

}
