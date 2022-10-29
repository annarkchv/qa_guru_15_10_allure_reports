package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {

    public static final String REPOSITORY = "eroshenkoam/allure-example";
    public static final int ISSUE_NUMBER = 80;

//    testLambdaStep и testAnnotatedStep делают одно и то же, просто два разных подхода
    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page", () -> {
            open("https://github.com");
        });

        step("Find repository " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });

        step("Click repository link", () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Open tab Issues", () -> {
            $("#issues-tab").click();
        });

        step("Check existence of issue with number " + ISSUE_NUMBER, () -> {
            $(withText("#" + ISSUE_NUMBER)).should(Condition.exist);
        });
    }

    @Test
    public void testAnnotatedStep() {
        WebSteps webSteps = new WebSteps();

        webSteps.openMainPage();
        webSteps.findRepository(REPOSITORY);
        webSteps.clickRepositoryLink(REPOSITORY);
        webSteps.openTabIssues();
        webSteps.shouldExistIssueWithNumber(ISSUE_NUMBER);
    }
}
