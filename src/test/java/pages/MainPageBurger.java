package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPageBurger {

    //кнопка Войти в аккаунт(для перехода с главной страницы к странице логина
    @FindBy(how = How.CSS,using = ".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_large__G21Vg")
    private SelenideElement inAccount;

    //Надпись Соберите бургер
    @FindBy(how = How.CSS,using = ".text.text_type_main-large.mb-5.mt-10")
    private SelenideElement inscriptionBurger;

    //кнопка Оформить заказ
    @FindBy(how = How.XPATH, using = ".//button[text()='Оформить заказ']")
    public SelenideElement makeOrder;

    //Кнопка личный кабинет
    @FindBy(how = How.XPATH, using = "//*[text()='Личный Кабинет']")
    public SelenideElement personalAccount;

    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Лента Заказов')]")
    public SelenideElement goOrderfeed;

    //Переход на булки
    @FindBy(how = How.XPATH,using = "//span[contains(text(),'Булки')]")
    private SelenideElement bunsTab;

    //Подзаголовок Н2 Булки
    @FindBy(how = How.XPATH,using = "/html/body/div[1]/div/main/section[1]/div[2]/h2[contains(text(),'Булки')]")
    private SelenideElement fluorBun;

    //Переход на соусы
    @FindBy(how = How.XPATH,using = "//span[contains(text(),'Соусы')]")
    private SelenideElement sauceTab;

    //Подзаголовок Н2 Соусы
    @FindBy(how = How.XPATH,using = "/html/body/div[1]/div/main/section[1]/div[2]/h2[contains(text(),'Соусы')]")
    private SelenideElement sauce;

    //Переход на начинки
    @FindBy(how = How.XPATH,using = "//span[contains(text(),'Начинки')]")
    private SelenideElement toppingsTab;

    //Первая начинка в списке для проверки, что перешли на начинки
    @FindBy(how = How.XPATH,using = "/html/body/div[1]/div/main/section[1]/div[2]/h2[contains(text(),'Начинки')]")
    private SelenideElement toppings;

    //Модалка заказа
    @FindBy(how = How.XPATH,using = "//div[@class='Modal_modal__contentBox__sCy8X pt-30 pb-30']")
    private SelenideElement modale;

    //Закрытие модалки
    @FindBy(how = How.XPATH,using = "//div[@class='Modal_modal__contentBox__sCy8X pt-30 pb-30']")
    private SelenideElement close;

    @FindBy(how = How.CSS,using = ".tab_tab_type_current__2BEPc")
    public SelenideElement activeTab;


    //Проверка, что после логина есть кнопка Оформить заказ
    @Step
    public void checkHasButtonAndText() {
        makeOrder.scrollTo();
        makeOrder.shouldHave(Condition.exactText("Оформить заказ"));
        inscriptionBurger.shouldHave(Condition.exist);
        inscriptionBurger.shouldHave(Condition.exactText("Соберите бургер"));
    }

    @Step
    public void clickInAcc() {
        inAccount.shouldBe(Condition.exist).click();
    }

    @Step
    public void clickPersAcc() {
        personalAccount.shouldBe(Condition.exist).click();
    }

    @Step
    public void clickFeed() {
        goOrderfeed.shouldBe(Condition.exist).click();
    }

    @Step
    public void clickBuns() {
        bunsTab.shouldBe(Condition.exist).click();
    }

    @Step
    public boolean checkTopBun() {
        return activeTab.getText().contentEquals("Булки");
    }

    @Step
    public void clickSauce() {
        sauceTab.shouldBe(Condition.exist).click();
    }

    @Step
    public boolean checkTopSauce() {
        return activeTab.getText().contentEquals("Соусы");
    }

    @Step
    public void clickToppings() {
        toppingsTab.shouldBe(Condition.exist).click();
    }

    @Step
    public boolean checkTopTopping() {
        return activeTab.getText().contentEquals("Начинки");
    }
}
