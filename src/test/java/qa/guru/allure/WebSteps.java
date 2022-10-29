package qa.guru.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Open main page")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Find repository {repository}")
    public void findRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repository);
        $(".header-search-input").submit();
    }

    @Step("Click repository link")
    public void clickRepositoryLink(String repository) {
        $(linkText(repository)).click();
    }

    @Step("Open tab Issues")
    public void openTabIssues() {
        $("#issues-tab").click();
    }

    @Step("Check existence of issue with number {issueNumber}")
    public void shouldExistIssueWithNumber(int issueNumber) {
        $(withText("#" + issueNumber)).should(Condition.exist);
    }

    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
