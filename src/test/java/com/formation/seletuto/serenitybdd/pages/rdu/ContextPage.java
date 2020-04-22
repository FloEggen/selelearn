package com.formation.seletuto.serenitybdd.pages.rdu;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ContextPage extends PageObject {

    public void choixContext(String context) {
        List<WebElement> availableContexts = getDriver().findElements(By.xpath(".//*[@id='tableauChoixContexte_data']/tr"));
        int indexOfInterest = 0;
        String contextLoopName = "";
        for(int i=0; i<availableContexts.size(); i++){
            contextLoopName = availableContexts.get(i).findElement(By.xpath("/td")).getText();
            if(contextLoopName.equals(context)){
                indexOfInterest = i;
            }
        }
        Assertions.assertThat(availableContexts.get(indexOfInterest).getText()).isEqualTo(context);
        availableContexts.get(indexOfInterest).click();
    }

}
