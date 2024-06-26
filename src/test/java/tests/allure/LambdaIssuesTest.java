package tests.allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;




public class LambdaIssuesTest extends BaseTest {
    private static final String REPOSITORY = "ahtagot/ci-tests-qa-guru";
    private static final int ISSUE =1;
    @Test
    public void lambdaGithubIssuesTest() {


        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open Github home page", () -> open("/"));
        step("Search" + REPOSITORY, () -> {
            $(".search-input").click();
            $("#query-builder-test").setValue(REPOSITORY).submit()
            ;
        });
        step("Click repository " + REPOSITORY + "link", () -> $(linkText(REPOSITORY)).click());
        step("Open Issues Tab", () -> $("#issues-tab").click());
        step("Check Issue #" + ISSUE, () -> $(withText("#" + ISSUE)).should(Condition.exist));
    }
}


