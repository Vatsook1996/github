package github;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchSoftAssertions {
    @Test
    void searchSoftAssertions() {
        open("https://github.com");
        $(".header-search-input").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        $("#wiki-tab").click();
        $("#wiki-body").shouldHave(text("Soft assertions"));
        $(byText("Soft assertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
