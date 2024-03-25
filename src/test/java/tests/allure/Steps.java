package tests.allure;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static tests.allure.PageUrl.*;

public class Steps {
    @Step ("Open Github home page")
    public void openMainPage(String githubHomepage){
        open(GITHUB_HOMEPAGE);
    }
    @Step ("Search" + REPOSITORY)
    public void searchRepository(String repository){
        $(".search-input").click();
        $("#query-builder-test").setValue(REPOSITORY).submit();
    }
    @Step ("Click repository " + REPOSITORY + "link")
    public void clickRepository(String repository){
        $(linkText(REPOSITORY)).click();
    }
    @Step ("Open Issues Tab")
    public void openIssuesTab(){
        $("#issues-tab").click();
    }
    @Step("Check Issue #" + ISSUE)
    public void checkIssue(int issue){
        $(withText("#" + ISSUE)).should(Condition.exist);
    }
}
