package com.kollex.task.Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GooglePage {

    private static final By search = By.id("input");

    public static void searchWikiPage(){
        $(search).setValue("wikipedia").pressEnter();
    }

}
