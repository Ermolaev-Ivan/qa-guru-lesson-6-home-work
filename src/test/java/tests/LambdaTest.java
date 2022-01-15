package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";

    @Test
    @Owner("Ermolaev Ivan")
    @Story("Проверка наличия вкладки Issues в репозитории")
    @DisplayName("Проверка наличия вкладки Issues в репозитории через лямда степы")
    public void issueNameValidationSelenideTest() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в " + REPOSITORY, () -> {
            $(linkText("eroshenkoam/allure-example")).click();
        });
        step("Проверяем что в " + REPOSITORY + " есть Issues", () -> {
            $(partialLinkText("Issues")).shouldBe(Condition.visible);
            $(partialLinkText("Issues")).shouldHave(text("Issues"));
        });
    }
}
