package com.kollex.task.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static com.codeborne.selenide.Selenide.$;
import static com.kollex.task.utils.Constants.articleName;

public class WikiPage {
    private WikiPage() {
    }

    private static final By search = By.id("searchInput");
    private static final By logisticsElement = By.id("Logistics");
    private static final By siteConcernsElement = By.id("Site_concerns");
    private static final By mapLink = By.cssSelector(".mw-kartographer-map > img");
    private static final By textButton = new Selectors.ByText("External maps");
    private static final By externalMapButton = new By.ByXPath("//span[contains(text(), 'External maps')]/..");

    /**
     * The method is doing search "Giga Berlin" article on a wikipedia.com
     * and making a screenshot after opening the article
     **/

    public static void searchArticle() {
        $(search).setValue(articleName).pressEnter();
        Selenide.screenshot("secondStep");
    }

    /**
     * The method is doing follow data: Logistics and Site concerns on "Giga Berlin" article
     * and making a screenshot after finding these positions.
     **/

    public static void openWikiMap() {
        $(logisticsElement).scrollTo();
        $(siteConcernsElement).scrollTo();
        Selenide.screenshot("thirdStep");
        $(mapLink).click();
    }

    /**
     * The method is opening various of maps for the  Giga location
     **/


    public static void checkMapLink(){
        Selenide.Wait().until(ExpectedConditions.visibilityOf($(textButton)));
        $(externalMapButton).shouldBe(Condition.visible);
        $(externalMapButton).doubleClick();
    }
}
