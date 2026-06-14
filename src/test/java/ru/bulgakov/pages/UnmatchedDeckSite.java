package ru.bulgakov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class UnmatchedDeckSite {

    private final SelenideElement startHearthLevel = $("span.text-nowrap");

    public static UnmatchedDeckSite openBeowulfDeck() {
        open("https://unmatched.cards/umdb/decks/beowulf");
        return new UnmatchedDeckSite();
    }

    public UnmatchedDeckSite checkStartHealth(int exetectedHealth){
        String expectedText = "Start health " + exetectedHealth;
        startHearthLevel.shouldHave(exactText(expectedText));
    }
}
