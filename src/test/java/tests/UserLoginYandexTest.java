package tests;

import com.UserOperations;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.ForgotPassPage;
import pages.LoginPage;
import pages.MainPageBurger;
import pages.RegisterPage;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class UserLoginYandexTest {

    public static final String url = "https://stellarburgers.nomoreparties.site/";

    public UserOperations userOperations = new UserOperations();
    public Map<String, String> responseData = new HashMap<>();


    @Before
    public void setUp (){
        responseData = userOperations.register();
        System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
        Configuration.browserSize = "1920x1080";
    }

    @After
    public void tearDown (){
        userOperations.delete();
    }

    @DisplayName("Успешный логин при попадании на страницу логина через кнопку Войти в аккаунт")
    @Test
    public void successLoginMainPageWithInButton(){
        MainPageBurger mainPage = open(url, MainPageBurger.class);
        mainPage.clickInAcc();//переход к логину через кнопку Войти в аккаунт
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(responseData.get("email"),responseData.get("password"));
        MainPageBurger main = page(MainPageBurger.class);
        main.checkHasButtonAndText();

    }

    @DisplayName("Успешный логин при попадании на страницу логина через кнопку Личный кабинет")
    @Test
    public void successLoginMainPageWithPersAccButton(){
        MainPageBurger mainPage = open(url, MainPageBurger.class);
        mainPage.clickPersAcc();//переход к логину через кнопку Личный кабинет
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(responseData.get("email"),responseData.get("password"));
        MainPageBurger main = page(MainPageBurger.class);
        main.checkHasButtonAndText();

    }

    @DisplayName("Успешный логин при попадании на страницу логина из формы регистрации")
    @Test
    public void successLoginMainPageFromRegisterForm(){
        String regUrl = "https://stellarburgers.nomoreparties.site/register";
        RegisterPage regPage = open(regUrl, RegisterPage.class);
        regPage.clickInButton();
        MainPageBurger mainPage = open(url, MainPageBurger.class);
        mainPage.clickPersAcc();//переход к логину через кнопку Личный кабинет
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(responseData.get("email"),responseData.get("password"));
        MainPageBurger main = page(MainPageBurger.class);
        main.checkHasButtonAndText();

    }

    @DisplayName("Успешный логин при попадании на страницу логина из формы восстановления пароля")
    @Test
    public void successLoginMainPageFromForgotPassForm(){
        String forgotPassUrl = "https://stellarburgers.nomoreparties.site/forgot-password";
        ForgotPassPage forgotPage = open(forgotPassUrl, ForgotPassPage.class);
        forgotPage.clickInButton();//переход к логину через кнопку Войти на старнице восстановления пароля
        LoginPage loginPage = page(LoginPage.class);
        loginPage.login(responseData.get("email"),responseData.get("password"));
        MainPageBurger main = page(MainPageBurger.class);
        main.checkHasButtonAndText();

    }


}
