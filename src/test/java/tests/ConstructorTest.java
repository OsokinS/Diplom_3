package tests;

import com.UserOperations;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPageBurger;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertTrue;

public class ConstructorTest {

    public static final String url = "https://stellarburgers.nomoreparties.site/";

    public UserOperations userOperations = new UserOperations();
    public Map<String, String> responseData = new HashMap<>();


    @Before
    public void setUp (){
        responseData = userOperations.register();
        String loginUrl = "https://stellarburgers.nomoreparties.site/login";
        LoginPage loginPage = open(loginUrl, LoginPage.class);
        Configuration.browserSize = "1920x1080";
        loginPage.login(responseData.get("email"),responseData.get("password"));
    }

    @After
    public void tearDown (){
        userOperations.delete();
    }

    @DisplayName("При попадании на главную страницу по дефолту открыта вкладка Булки")
    @Test
    public  void  BunsTabTest(){
        MainPageBurger mainPage = page(MainPageBurger.class);
        boolean isBun = mainPage.checkTopBun();
        assertTrue("Булки нет!", isBun);

    }

    @DisplayName("Успешный переход на вкладку Соусы")
    @Test
    public  void  GoSauceTabTest(){
        MainPageBurger mainPage = page(MainPageBurger.class);
        mainPage.clickSauce();
        boolean isSauce = mainPage.checkTopSauce();
        assertTrue("Соусов нет!", isSauce);

    }

    @DisplayName("Успешный переход на вкладку начинки")
    @Test
    public  void  GoToppingTabTest(){
        MainPageBurger mainPage = page(MainPageBurger.class);
        mainPage.clickToppings();
        boolean isTopping = mainPage.checkTopTopping();
        assertTrue("Начинок нет!", isTopping);

    }

    @DisplayName("Успешный переход на вкладку Булки из других вкладок")
    @Test
    public  void  GoBunTabTest(){
        MainPageBurger mainPage = page(MainPageBurger.class);
        mainPage.clickToppings();
        boolean isTopping = mainPage.checkTopTopping();
        assertTrue("Вкладка начинок не активна", isTopping);
        mainPage.clickBuns();
        boolean isBun = mainPage.checkTopBun();
        assertTrue("Вкладка булок не активна", isBun);

    }
}
