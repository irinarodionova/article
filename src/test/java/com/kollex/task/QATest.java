package com.kollex.task;

import com.codeborne.selenide.*;
import com.kollex.task.Pages.GooglePage;
import com.kollex.task.driver.ChromeWebDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.kollex.task.utils.Constants.baseUrl;
import static com.kollex.task.Pages.GooglePage.searchWikiPage;
import static com.kollex.task.Pages.WikiPage.searchArticle;


public class QATest {

    private GooglePage googlePage;


    @Before
    public void buildDriver() {
        ChromeWebDriver.setDriver();
        initPageObjects();
        WebDriverRunner.clearBrowserCache();
        Selenide.clearBrowserCookies();
    }

    @Test
    public void checkArticleMapData() throws InterruptedException {
        open(baseUrl);
        try {
            Selenide.switchTo().alert().accept();
        }
        catch (NoAlertPresentException e) {
        }
        searchWikiPage();
        searchArticle();
    }


    private void initPageObjects() {
    }

}