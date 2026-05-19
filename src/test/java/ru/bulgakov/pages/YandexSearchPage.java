package ru.bulgakov.pages;

import static com.codeborne.selenide.Selenide.$;

public class YandexSearchPage {

    public YandexSearchPage search(String query){
        $("#text").setValue(query);

        return this;
    }
}
