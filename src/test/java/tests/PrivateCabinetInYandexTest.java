package tests;

import com.UserOperations;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPageBurger;
import pages.OrderFeedPage;
import pages.PrivateOfficePage;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PrivateCabinetInYandexTest {

    public UserOperations userOperations = new UserOperations();
    public Map<String, String> responseData = new HashMap<>();

    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver", "src/resources/yandexdriver.exe");
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

    @DisplayName("Успешный переход в личный кабинет с главной страницы")
    @Test
    public void successInMainPrivateCabinetTest(){
        MainPageBurger mainPage = page(MainPageBurger.class);
        mainPage.clickPersAcc();
        PrivateOfficePage privateOffice = page(PrivateOfficePage.class);
        privateOffice.getNameValue();
        assertEquals(responseData.get("name"), privateOffice.getNameValue());

    }

    @DisplayName("Успешный переход в личный кабинет со страницы Ленты заказов")
    @Test
    public void successInOrderFeedPrivateCabinetTest(){
        MainPageBurger mainPage = page(MainPageBurger.class);
        mainPage.clickFeed();
        OrderFeedPage orderFeed = page(OrderFeedPage.class);
        orderFeed.clickInButton();
        PrivateOfficePage privateOffice = page(PrivateOfficePage.class);
        privateOffice.getNameValue();
        assertEquals(responseData.get("name"), privateOffice.getNameValue());

    }

    @DisplayName("Успешный переход в конструктор из личного кабинета")
    @Test
    public void goInConstructorTest(){
        MainPageBurger mainPage = page(MainPageBurger.class);
        mainPage.clickPersAcc();
        PrivateOfficePage privateOffice = page(PrivateOfficePage.class);
        privateOffice.goConstr();
        MainPageBurger mainPage2 = page(MainPageBurger.class);
        mainPage2.checkHasButtonAndText();

    }

    @DisplayName("Успешный переход в конструктор из личного кабинета через лого бургера")
    @Test
    public void goInBurgerLogoTest(){
        MainPageBurger mainPage = page(MainPageBurger.class);
        mainPage.clickPersAcc();
        PrivateOfficePage privateOffice = page(PrivateOfficePage.class);
        privateOffice.goBurger();
        MainPageBurger mainPage2 = page(MainPageBurger.class);
        mainPage2.checkHasButtonAndText();

    }

    @DisplayName("Успешный выход из личного кабинета")
    @Test
    public void goExitTest(){
        MainPageBurger mainPage = page(MainPageBurger.class);
        mainPage.clickPersAcc();
        PrivateOfficePage privateOffice = page(PrivateOfficePage.class);
        privateOffice.goExit();
        LoginPage login = page(LoginPage.class);
        boolean isExit = login.checkEntrance();
        assertTrue("Кнопки Войти нет!",isExit);

    }

}
