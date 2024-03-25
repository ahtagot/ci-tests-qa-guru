package tests.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static tests.allure.PageUrl.*;

public class ListenerIssuesTest extends BaseTest{

    @Test
    public void githubIssuesListenerTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open(GITHUB_HOMEPAGE);
        $(".search-input").click();
        $("#query-builder-test").setValue(REPOSITORY).submit();
        $(linkText(REPOSITORY)).click();
        $("#issues-tab").click();
        $(withText("#" + ISSUE)).should(Condition.exist);

}}