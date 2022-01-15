package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnnotationStepTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String TAB = "Issues";

    @Test
    @Owner("Ermolaev Ivan")
    @Story("Проверка наличия вкладки Issues в репозитории")
    @DisplayName("Проверка наличия вкладки Issues в репозитории через аннотации")
    public void issueNameValidationSelenideTest(){
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.openRepositoryPage(REPOSITORY);
        steps.shouldSeeIssueWithRepository(TAB);
    }
}
