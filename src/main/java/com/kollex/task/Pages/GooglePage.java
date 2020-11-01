package com.kollex.task.Pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GooglePage {

    private static final By search = By.name("q");
    private static final By wikiLink = new By.ByCssSelector("#rso > div:nth-child(1) > div > div.yuRUbf > a > div > cite");

    public static void searchWikiPage(){

        $(search).setValue("wikipedia.com").pressEnter();
        //$(wikiLink).click();
        open("http://wikipedia.com");
        Selenide.screenshot("firstStep");
    }

}
