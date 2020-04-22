package com.formation.seletuto.serenitybdd.pages.rdu;

import com.formation.seletuto.serenitybdd.helpers.Waiting;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProfilPage extends PageObject {

    @FindBy(id="formSelection:j_idt133")
    public WebElement ajouterBtn;

    @FindBy(id="code")
    public WebElement codeBox;

    @FindBy(id="libelle")
    public WebElement libelleBox;

    @FindBy(xpath=".//*[@title='Ajouter']")
    public WebElement addArrow;

    @FindBy(id="j_idt146")
    public WebElement saveBtn;

    @FindBy(id="formSelection:j_idt129")
    public WebElement deleteBtn;

    @FindBy(id="formSelection:tableauProfils:j_idt122:filter")
    public WebElement codeFilterBox;

    public void clickAjouter(){
        ajouterBtn.click();
    }

    public void insertCodeAndLibelle(String code, String libelle){
        codeBox.clear();
        codeBox.sendKeys(code);
        libelleBox.sendKeys(libelle);
    }

    public void choixDesDroits(String rights){
        WebElement rightsLine = getDriver().findElement(By.xpath(".//*[@data-item-value='"+rights+"']"));
        rightsLine.click();
        addArrow.click();
    }

    public void clickSave(){
        saveBtn.click();
    }

    public void insertCodeInArea(String profileCode){
        codeFilterBox.clear();
        codeFilterBox.sendKeys(profileCode);
        Waiting.waitFor(1000);
    }

    public int findNumberOfFilteredResults(){
        int numOfResults = 0;
        List<WebElement> filteredResults = getDriver().findElements(By.xpath(".//*[@id='formSelection:tableauProfils_data']/tr"));
        if(!filteredResults.get(0).getText().contains("Aucun résultat")){
            numOfResults = filteredResults.size();
        }
        return numOfResults;
    }

    public void clickOnFirstResult(){
        WebElement firstResult = getDriver().findElement(By.xpath(".//*[@id='formSelection:tableauProfils_data']/tr/td[1]"));
        firstResult.click();
    }

    public void clickSupprimer(){
        deleteBtn.click();
    }

}
