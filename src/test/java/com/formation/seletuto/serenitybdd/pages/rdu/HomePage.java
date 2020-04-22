package com.formation.seletuto.serenitybdd.pages.rdu;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class HomePage extends PageObject {

    @FindBy(xpath=".//*[@class='rts-nav-link' and @href='//www.rts.ch/info/culture/']")
    public WebElement cultureLink;

    public void accessPage(String url) {
        getDriver().get(url);
    }

    public void clickOnCultureLink() {
        cultureLink.click();
    }



}
