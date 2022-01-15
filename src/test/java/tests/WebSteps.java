package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Переходим в {repository}")
    public void openRepositoryPage(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Проверяем что репозиторий содержит вкладку {issues}")
    public void shouldSeeIssueWithRepository(String issues) {
        $(partialLinkText(issues)).shouldBe(Condition.visible);
        $(partialLinkText(issues)).shouldHave(text(issues));
    }
}
