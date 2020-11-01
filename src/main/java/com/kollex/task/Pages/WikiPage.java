package com.kollex.task.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.impl.SelenidePageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

public class WikiPage {

    private static final By search = By.id("searchInput");
    private static final By mapLink = By.cssSelector(".mw-kartographer-map > img");


    public static void searchArticle(){
       SelenideElement article = $(search).setValue("Giga Berlin").pressEnter();
        article.scrollIntoView("Logistics").scrollIntoView("Site concerns");

        $(mapLink).click();
    }
}
