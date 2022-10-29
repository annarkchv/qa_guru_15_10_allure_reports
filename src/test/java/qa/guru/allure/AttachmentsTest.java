package qa.guru.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class AttachmentsTest {

    public static final String REPOSITORY = "eroshenkoam/allure-example";
    public static final int ISSUE_NUMBER = 80;

    @Test
    public void testLambdaAttachments() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open main page", () -> {
            open("https://github.com");
            attachment("Source", webdriver().driver().source());
        });
    }

    @Test
    public void testAnnotatedAttachments() {
        WebSteps webSteps = new WebSteps();

        webSteps.openMainPage();
        webSteps.takeScreenshot();
    }
}
