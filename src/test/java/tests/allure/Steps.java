package tests.allure;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;


public class Steps {

    @Step ("Open Github home page")
    public void openMainPage(){
        open("/");
    }
    @Step ("Search {repo}")
    public void searchRepository(String repo){
        $(".search-input").click();
        $("#query-builder-test").setValue(repo).submit();
    }
    @Step ("Click repository {repo}]")
    public void clickRepository(String repo){
        $(linkText(repo)).click();
    }
    @Step ("Open Issues Tab")
    public void openIssuesTab(){
        $("#issues-tab").click();
    }
    @Step("Check Issue {issue}")
    public void checkIssue(int issue){
        $(withText("#" + issue )).should(Condition.exist);
    }
}
