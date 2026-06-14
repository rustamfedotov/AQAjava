package ru.bulgakov.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.bulgakov.pages.UnmatchedDeckSite;
import ru.bulgakov.pages.YandexSearchPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SearchTest {
    private static final int BEOWULF_START_HEALTH = 17;

    @Test
    @DisplayName("Проверить, что цена обучения - 47 000")
    @Tag("POSITIVE")
    void mentoringPriceShouldBe47000Test() {

        Configuration.holdBrowserOpen = true;


        open("https://ya.ru", YandexSearchPage.class)
                .search("bulgakov qa")
                .sumbit()
                .closeDeaultBrowserSelectWindow()
                .openLink("ivanbulgakovqa.ru")
                .clickPrice();

        sleep(3000);
        switchTo().window(1);
        $$(".t-menu__list li").last().click();                        // множественный поиск. OUTPUT: коллекция элементов

        // xpath - не очень
        $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a").click();
        $(byText("Бегу оплачивать")).click();

        sleep(3000);
        switchTo().window(2);
        $(".styles-module-scss-module__t92_WG__price h3").shouldHave(text("₽ 47 000.00"));
    }

    @Test
    @DisplayName("Beowulf start health should be 17")
    @Tag("POSITIVE")
    void beowulfStartHealthShouldBe17Test(){
        Configuration.holdBrowserOpen=true;

        UnmatchedDeckSite.openBeowulfDeck()
                .checkStartHealth(BEOWULF_START_HEALTH);
    }
}
