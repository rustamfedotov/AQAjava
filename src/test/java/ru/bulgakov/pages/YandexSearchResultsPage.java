package ru.bulgakov.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class YandexSearchResultsPage {
    private final SelenideElement closeWindow = $(".DistributionButtonClose");

    public YandexSearchResultsPage closeDeaultBrowserSelectWindow(){
        closeWindow.click();
        return this;
    }

    public WelcomePage openLink(String webSiteURL){
        $(byText(webSiteURL)).click();
        return new WelcomePage();
    }
}
