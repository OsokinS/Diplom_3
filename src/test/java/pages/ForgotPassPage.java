package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPassPage {

    @FindBy(how = How.XPATH,using = "//*[contains(@class, 'Auth_link')][contains(text(), 'Войти')]")
    private SelenideElement inForgotPassButton;
    @Step
    public void clickInButton() {
        inForgotPassButton.shouldBe(Condition.exist).click();
    }
}
