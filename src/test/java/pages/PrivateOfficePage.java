package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PrivateOfficePage {

    //Кнопка Лого Бургера
    @FindBy(how = How.XPATH,using = "//div[@class='AppHeader_header__logo__2D0X2']//a//*[name()='svg']")
    private SelenideElement logoBurger;

    //Надпись В этом разделе вы можете изменить свои персональные данные
    @FindBy(how = How.CLASS_NAME,using = "Account_list__3KQQf mb-20")
    private SelenideElement text;

    //Кнопка Выход
    @FindBy(how = How.XPATH,using = "//button[contains(text(),'Выход')]")
    private SelenideElement buttonExit;

    //Кнопка Конструктор
    @FindBy(how = How.XPATH,using = "//p[contains(text(),'Конструктор')]")
    private SelenideElement buttonCostr;

    //Поле имя
    @FindBy(how = How.XPATH,using = "//input[@name='Name']")
    private SelenideElement nameField;

    @Step
    public String getNameValue() {
        return nameField.getAttribute("value");
    }

    @Step
    public void goConstr() {
        buttonCostr.shouldBe(Condition.exist).click();
    }

    @Step
    public void goBurger() {
        logoBurger.shouldBe(Condition.exist).click();
    }

    @Step
    public void goExit() {
        buttonExit.shouldBe(Condition.exist).click();
    }

    @Step
    public void getText() {
        text.shouldBe(Condition.exactText("В этом разделе вы можете изменить свои персональные данные"));
    }

}
