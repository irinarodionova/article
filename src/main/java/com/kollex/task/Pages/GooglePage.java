package com.kollex.task.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.kollex.task.utils.Constants.wikiSearchInput;
import static com.kollex.task.utils.Constants.wikiUrl;

public class GooglePage {
    private GooglePage() {
    }

    private static final By search = By.name("q");
    private static final By googleMapButton = new By.ByXPath("//span[contains(text(), 'Google')]/..");


    /**
     * The method is doing search for a wikipedia.com
     * and making a screenshot after opening the page
     **/
    public static void searchWikiPage() {
        $(search).setValue(wikiSearchInput).pressEnter();
        open(wikiUrl);
        Selenide.screenshot("firstStep");
    }

    public static void openGoogleMap(){
        $(googleMapButton).shouldBe(Condition.visible);
        $(googleMapButton).click();
    }
}
