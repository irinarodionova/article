package com.kollex.task.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
import static com.kollex.task.utils.Constants.articleName;

public class WikiPage {
    private WikiPage() {
    }

    private static final By search = By.id("searchInput");
    private static final By logisticsElement = By.id("Logistics");
    private static final By siteConcernsElement = By.id("Site_concerns");
    private static final By mapLink = By.cssSelector(".mw-kartographer-map > img");
    private static final By externalMapButton = new By.ByXPath("//span[contains(text(), 'External maps')]/..");

    public static void searchArticle() {
        $(search).setValue(articleName).pressEnter();
        Selenide.screenshot("secondStep");
    }

    public static void openWikiMap() {
        $(logisticsElement).scrollTo();
        $(siteConcernsElement).scrollTo();
        Selenide.screenshot("thirdStep");
        $(mapLink).click();
    }

    public static void checkMapLink(){
        $(externalMapButton).shouldBe(Condition.visible);
        $(externalMapButton).click();
    }
}
