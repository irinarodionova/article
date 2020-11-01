package com.kollex.task.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideWait;
import com.codeborne.selenide.impl.SelenidePageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.Wait;

public class WikiPage {

    private static final By search = By.id("searchInput");
    private static final By logisticsElement = By.id("Logistics");
    private static final By siteConcernsElement = By.id("Site_concerns");
    private static final By mapLink = By.cssSelector(".mw-kartographer-map > img");
    private static final By content = By.cssSelector("#content");
    private static final By externalMapButton = new By.ByXPath("//span[contains(text(), 'External maps')]/..");
    private static final By googleMapButton = new By.ByXPath("//span[contains(text(), 'Google')]/..");


    public static void searchArticle() throws InterruptedException {
       SelenideElement article = $(search).setValue("Giga Berlin").pressEnter();
        Selenide.screenshot("secondStep");
        $(logisticsElement).scrollTo();
        $(siteConcernsElement).scrollTo();
        Selenide.screenshot("thirdStep");
        $(mapLink).click();
        Thread.sleep(1000);
        $(externalMapButton).shouldBe(Condition.visible);
        $(externalMapButton).click();
        $(googleMapButton).shouldBe(Condition.visible);
        $(googleMapButton).click();
        Selenide.switchTo().window(1);
        Selenide.screenshot("finish");
    }
}
