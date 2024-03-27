package tests.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class ListenerIssuesTest extends BaseTest{
    private static final String REPOSITORY = "ahtagot/ci-tests-qa-guru";
    private static final int ISSUE =1;
    @Test
    public void githubIssuesListenerTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("/");
        $(".search-input").click();
        $("#query-builder-test").setValue(REPOSITORY).submit();
        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText("#" + ISSUE)).should(Condition.exist);

}}