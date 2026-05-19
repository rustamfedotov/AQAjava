package ru.bulgakov.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SearchTest {
    private static final String YANDEX_BASE_URL = "https://ya.ru";
    private static final String UNMATCHED_DB_BASE_URL = "https://unmatched.cards/umdb/decks";
    private static final String START_HEALTH_LABEL = "Start health";
    private static final int BEOWULF_START_HEALTH = 17;
    private static final String expectedText = START_HEALTH_LABEL + " " + BEOWULF_START_HEALTH;

    @Test
    void mentoringPriceShouldBe47000Test() {

        Configuration.holdBrowserOpen = true;
        open(YANDEX_BASE_URL);
        $("#text").setValue("bulgakov qa");
        $("[type=submit]").click();                     //поиск по атрибуты
        $(".DistributionButtonClose").click();           //поиск по классу
        $(byText("ivanbulgakovqa.ru")).click();         //поиск по тексту

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
    void beowulfStartHealthShouldBe17Test(){
        Configuration.holdBrowserOpen=true;

        // шаг 1. открыть сайт
        open(UNMATCHED_DB_BASE_URL);

        // шаг 2. найти
        $("a[href=\"/umdb/decks/beowulf\"]").shouldBe(interactable).click();

        // шаг 3. ОР: Beowulf Start Health=17
        $("span.text-nowrap").shouldHave(exactText(expectedText));
    }
}
