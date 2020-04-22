package com.formation.seletuto.serenitybdd.pages.iam;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class IamPage extends PageObject {

    @FindBy(xpath=".//*[@name='IDToken1']")
    public WebElement userId;

    @FindBy(xpath=".//*[@name='IDToken2']")
    public WebElement passwordId;

    @FindBy(xpath=".//button[contains(text(), 'Connexion')]")
    public WebElement connexionButton;

    public void accesLoginPage(String iamUrl) {
        getDriver().get(iamUrl);
    }

    public void insertCredentials(String username, String password) {
        userId.sendKeys(username);
        passwordId.sendKeys(password);
    }

    public void clickOnConnexionBtn() {
        connexionButton.click();
    }

    public void clickOnAppLink(String appLink){
        // Wait for iam spinner to disappear
        List<WebElement> spinnerIAM = getDriver().findElements(By.id("spinner"));
        int counter = 0;
        while (spinnerIAM.size() > 0 && counter < 20){
            waitFor(500);
            spinnerIAM = getDriver().findElements(By.id("spinner"));
            counter++;
        }
        WebElement applicationLinkElement = getDriver().findElement(By.xpath(".//*[@class='vd-link-invisible app-link' and contains(text(), '"+ appLink + "')]"));
        applicationLinkElement.click();
    }



}
