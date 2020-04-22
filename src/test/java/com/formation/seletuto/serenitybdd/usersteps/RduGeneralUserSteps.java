package com.formation.seletuto.serenitybdd.usersteps;

import com.formation.seletuto.serenitybdd.pages.iam.IamPage;
import com.formation.seletuto.serenitybdd.pages.rdu.ContextPage;
import com.formation.seletuto.serenitybdd.pages.rdu.ProfilPage;
import com.formation.seletuto.serenitybdd.pages.rdu.TransversePage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

public class RduGeneralUserSteps {

    TransversePage transversePage;
    ContextPage contextPage;

    @Step("Choix du contexte {0}")
    public void choixDuProfil(String context){
        String contextActuel = transversePage.getCurrentProfile();
        if (!contextActuel.equals(context)) {
            transversePage.clickOnContexte();
            transversePage.waitForSpinner();
            contextPage.choixContext(context);
            transversePage.waitForSpinner();
        }
    }
}
