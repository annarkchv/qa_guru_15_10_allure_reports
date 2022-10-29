package qa.guru.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {
//    static и dynamic labels делают одно и то же. Второй подход используется, если нужно запрограммировать
//    одно и то же название, например, фичи, для разных тестов (для более опытных автоматизаторов)

    @Test
    @DisplayName("Name of the test")
    @Feature("Name of the feature")
    @Story("Name of the user story")
    @Owner("anna_rkchv")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Name of the link", url = "https://testurl.com") // ссылки на доп. инфу - логи и проч.
    public void testStaticLabels() {
    }

    @Test
    public void testDynamicLabels() {
        Allure.getLifecycle().updateTestCase(t -> t.setName("Name of the test"));
        Allure.feature("Name of the feature");
        Allure.story("Name of the story");
        Allure.label("owner", "anna_rkchv");
        Allure.label("severity", SeverityLevel.NORMAL.value());
        Allure.link("Name of the link", "https://testurl.com");
    }
}
