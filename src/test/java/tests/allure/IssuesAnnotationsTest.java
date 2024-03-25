package tests.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static tests.allure.PageUrl.GITHUB_HOMEPAGE;
import static tests.allure.PageUrl.REPOSITORY;
import static tests.allure.PageUrl.ISSUE;


public class IssuesAnnotationsTest extends BaseTest{

    @Test
    @DisplayName("Check issues #" + ISSUE + " in project" + REPOSITORY)
    @Feature("Issue in user repository.")
    @Story("Creaing Issues")
    @Owner("Alex Stelmakh")
    public void annotationsGithubIssuesTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    Steps steps = new Steps();
    steps.openMainPage(GITHUB_HOMEPAGE);
    steps.searchRepository(REPOSITORY);
    steps.clickRepository(REPOSITORY);
    steps.openIssuesTab();
    steps.checkIssue(ISSUE);
    }

}
