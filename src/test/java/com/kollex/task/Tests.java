package com.kollex.task;

import com.codeborne.selenide.*;
import com.kollex.task.Pages.GooglePage;
import com.kollex.task.driver.ChromeWebDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.*;
import static com.kollex.task.utils.Constants.baseUrl;
import static com.kollex.task.Pages.GooglePage.searchWikiPage;
import static com.kollex.task.Pages.WikiPage.searchArticle;
import static java.lang.Long.*;


public class Tests {

    private GooglePage googlePage;

    @Before
    public void buildDriver() {
        ChromeWebDriver.setChromeDriver();
        initPageObjects();
        WebDriverRunner.clearBrowserCache();
        Selenide.clearBrowserCookies();
    }

    @Test
    public void checkArticleData() throws InterruptedException {
        open(baseUrl);
//        try {
//            Selenide.switchTo().alert().accept();
//        }
//        catch (NoAlertPresentException e) {
//
//        }
//        Thread.sleep(5000);
//        $(By.xpath("//*[@id=\"introAgreeButton\"]/span/span")).click();
//
//        searchWikiPage();

        open("https://www.wikipedia.org/");
        searchArticle();


    }


    private void initPageObjects() {
    }

    @Test
    public void checkArticle() throws InterruptedException {
        open("http://google.com");
        $(By.name("q")).setValue("wikipedia.com").pressEnter();
        SelenideElement wikiLink = $("#rso > div:nth-child(1) > div > div.yuRUbf > a > div > cite");
        //wikiLink.click();
        open("http://wikipedia.com");
        Selenide.screenshot("firstStep");
        $("#searchInput").setValue("Giga Berlin").pressEnter();
        Selenide.screenshot("secondStep");
        $("#content").scrollIntoView("Logistics");
        Selenide.screenshot("thirdStep");
        $(".mw-kartographer-map > img").click();
        Thread.sleep(1000);
        $(By.xpath("//span[contains(text(), 'External maps')]/..")).click();
//        Selenide.Wait().until(ExpectedConditions.elementToBeClickable(By.cssSelector(".mw-kartographer-filterservices-list-item:nth-child(3) .oo-ui-iconElement-icon")));
        Thread.sleep(parseLong("1000"));
        $(By.xpath("//span[contains(text(), 'Google')]/..")).click();
        Selenide.switchTo().window(1);
        Selenide.screenshot("finish");


        ;

    }

}