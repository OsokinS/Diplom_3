package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrderFeedPage {

    @FindBy(how = How.XPATH,using = "//p[contains(text(),'Личный Кабинет')]")
    public SelenideElement inOrderFeedButton;

    @Step
    public void clickInButton() {
        inOrderFeedButton.shouldBe(Condition.exist).click();
    }
}
