package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    //поле мейла неактивное
    @FindBy(how = How.CSS,using = ".input.pr-6.pl-6.input_type_text.input_size_default")
    private SelenideElement emailField;

    //поле мейла активное
    @FindBy(how = How.CSS,using = "fieldset:nth-child(1) input")
    private SelenideElement emailActField;

    //поле мейла для ввода
    @FindBy(how = How.XPATH,using = "//input[@name='name']")
    private SelenideElement emailInput;

    //поле пароля для ввода
    @FindBy(how = How.CSS,using = "fieldset:nth-child(2) input")
    private SelenideElement passwordInput;

    //кнопка Войти
    @FindBy(how = How.XPATH,using = ".//button[text()='Войти']")
    private SelenideElement entranceButton;

    //Ссылка на регистрацию
    @FindBy(how = How.LINK_TEXT,using = "Зарегистрироваться")
    private SelenideElement registerLink;

    //Ссылка на восстановление пароля
    @FindBy(how = How.LINK_TEXT,using = "Восстановить пароль")
    private SelenideElement restorePassword;

    //Переход в личный кабинет
    @FindBy(how = How.XPATH,using = "//p[contains(text(),'Личный Кабинет')]")
    private SelenideElement cabinet;

    //Переход к конструктору бургеров
    @FindBy(how = How.XPATH,using = "/p[contains(text(),'Конструктор')]")
    private SelenideElement constructor;

    //Переход к ленте заказов
    @FindBy(how = How.XPATH,using = "/p[contains(text(),'Лента Заказов')]")
    private SelenideElement orderTape;

    //Переход к конструктору через бургер
    @FindBy(how = How.XPATH,using = "//div[@class='//*[name()='svg']")
    private SelenideElement logoBurger;



    //кликнуть на ссылку Зарегистрироваться
    @Step
    public void clickRegister() {
        registerLink.click();
    }

    @Step
    public void login(String customerMail, String customerPass){
        emailInput.shouldBe(Condition.exist).click();
        emailActField.click();
        emailActField.setValue(customerMail);
        passwordInput.click();
        passwordInput.setValue(customerPass);
        entranceButton.shouldBe(Condition.exist).click();
    }

    @Step
    public boolean checkEntrance() {
        return entranceButton.shouldBe(Condition.exist).isDisplayed();
    }
}
