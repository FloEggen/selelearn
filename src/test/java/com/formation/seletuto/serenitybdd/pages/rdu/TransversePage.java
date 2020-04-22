package com.formation.seletuto.serenitybdd.pages.rdu;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TransversePage extends PageObject {

    @FindBy(xpath=".//form/div[@class='ui-outputpanel ui-widget loginInfoUser']/a[@class='ui-commandlink ui-widget']")
    public WebElement currentContexte;

    public String getCurrentProfile() {
        return currentContexte.getText();
    }

    public void clickOnContexte(){
        currentContexte.click();
    }

    public void waitForSpinner() {
        List<WebElement> spinnerRdu = getDriver().findElements(By.xpath(".//div[@id='statusDialog']"));
        int counter = 0;
        while (spinnerRdu.size() > 0 && counter < 20){
            waitFor(500);
            spinnerRdu = getDriver().findElements(By.xpath(".//div[@id='statusDialog']"));
            counter++;
        }
    }

    public void clickOnMenu(String menuName, boolean clickOnArrow){
        WebElement menu = getDriver().findElement(By.xpath(".//span[@class='ui-button-text ui-c' and text()='"+menuName+"']"));
        if(clickOnArrow){
            menu.findElement(By.xpath("../span[1]")).click();
        }
        else{menu.click();}
    }

    public void clickOnMenuItem(String itemName){
        WebElement item = getDriver().findElement(By.xpath(".//span[@class='ui-menuitem-text' and text()='"+itemName+"']"));
        item.click();
    }

    public void clickOnTab(String tabName){
        WebElement tab = getDriver().findElement(By.xpath(".//div[@class='ui-outputpanel ui-widget content']//*[text()='"+tabName+"']"));
        tab.click();
    }



}
