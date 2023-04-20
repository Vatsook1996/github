package github;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import org.junit.jupiter.api.Test;
public class SearchSoftAssertions {
    @Test
    void searchSoftAssertions() {
        // Открыть страницу Selenide в Github
        open("https://github.com");
        $(".header-search-input").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        // Переход в раздел Wiki проекта
        $("#wiki-tab").click();
        // Проверка, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        // Открыть страницу SoftAssertions, проверить что внутри есть пример кода для JUnit5
        $(byText("SoftAssertions")).click();
        $(".Layout-main").shouldHave(text("3. Using JUnit5 extend test class:"));
    }
}
