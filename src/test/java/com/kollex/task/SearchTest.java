package com.kollex.task;

import com.codeborne.selenide.*;
import com.kollex.task.driver.ChromeWebDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import static com.codeborne.selenide.Selenide.*;
import static com.kollex.task.Pages.GooglePage.openGoogleMap;
import static com.kollex.task.Pages.GooglePage.searchWikiPage;
import static com.kollex.task.Pages.WikiPage.*;
import static com.kollex.task.utils.Constants.googleUrl;


public class SearchTest {

    @Before
    public void buildDriver() {
        ChromeWebDriver.setDriver();
        WebDriverRunner.clearBrowserCache();
        Selenide.clearBrowserCookies();
    }

    @Test
    public void checkArticleMapData() throws InterruptedException {
        open(googleUrl);
        searchWikiPage();
        searchArticle();
        openWikiMap();
        checkMapLink();
        openGoogleMap();
        Selenide.switchTo().window(1);
        Selenide.screenshot("finish");
    }
}