package com.agros.test.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private ElementsCollection
            horizontalMenu = $$(".bx-inclinkstop-container"),
            sidebar = $$(".bx-nav-1-lvl"),
            catalogItemTitle = $$(".bx_catalog_tile_title");

    private SelenideElement
            catalogPageTitle = $("#pagetitle");

    private void closeBanner(){
        executeJavaScript("$('#onesignal-slidedown-dialog').remove()");
        executeJavaScript("$('#regionsPopup').remove()");
    }

    public MainPage verifyHorizontalMenu(String items){
        this.closeBanner();
        this.horizontalMenu.filter(visible).shouldHave(CollectionCondition.texts(items));
        return this;
    }

    public MainPage verifySidebarMenu(String items, List<String> categories){
        this.closeBanner();
        this.sidebar.find(text(items)).click();
        this.closeBanner();
        this.catalogPageTitle.shouldHave(text(items));
        this.catalogItemTitle.filter(visible).shouldHave(CollectionCondition.texts(categories));
        return this;
    }

}
