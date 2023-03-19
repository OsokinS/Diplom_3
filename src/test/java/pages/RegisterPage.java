package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {

    //поле ввода имени неактивное
    @FindBy(how = How.XPATH,using = "//fieldset[1]//div[1]//div[1]")
    private SelenideElement nameField;

    //поле ввода имени активное
    @FindBy(how = How.CSS,using = "fieldset:nth-child(1) input")
    private SelenideElement nameActField;

    //поле ввода мейла неактивное
    @FindBy(how = How.XPATH,using = "//fieldset[2]//div[1]//div[1]")
    private SelenideElement mailField;

    //поле ввода мейла активное
    @FindBy(how = How.CSS,using = "fieldset:nth-child(2) input")
    private SelenideElement mailActivField;

    //поле ввода пароля неактивное
    @FindBy(how = How.XPATH,using = "//fieldset[3]//div[1]//div[1]")
    private SelenideElement passField;

    //поле ввода пароля активное
    @FindBy(how = How.CSS,using = "fieldset:nth-child(3) input")
    private SelenideElement passActiveField;

    //ошибка ввода пароля при нажатии на кнопку регистрации
    @FindBy(how = How.CSS,using = ".input__error.text_type_main-default")
    private SelenideElement error;

    //заголовок Регистрация
    @FindBy(how = How.XPATH,using = "//h2[contains(text(),'Регистрация')]")
    private SelenideElement registerHeader;

    //кнопка Зарегистрироваться
    @FindBy(how = How.CSS,using = ".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa")
    private SelenideElement regButton;

    //кнопка Войти
    @FindBy(how = How.XPATH,using = "//*[contains(@class, 'Auth_link')][contains(text(), 'Войти')]")
    public SelenideElement inRegButton;

    @Step
    public void goRegister(String customerName,String customerMail,String customerPass){
        nameField.shouldBe(Condition.visible).click();
        nameActField.click();
        nameActField.setValue(customerName);
        mailField.click();
        mailActivField.click();
        mailActivField.setValue(customerMail);
        passField.click();
        passActiveField.click();
        passActiveField.setValue(customerPass);
        regButton.click();
    }

    @Step
    public void checkErr() {
        error.shouldHave(Condition.exactText("Некорректный пароль"));
    }

    @Step
    public void checkHeader() {
        registerHeader.shouldHave(Condition.exactText("Регистрация"));
    }

    @Step
    public void clickInButton() {
        inRegButton.shouldBe(Condition.exist).click();
    }

}
