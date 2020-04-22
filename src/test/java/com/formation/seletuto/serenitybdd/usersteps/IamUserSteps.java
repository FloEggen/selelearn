package com.formation.seletuto.serenitybdd.usersteps;

import com.formation.seletuto.serenitybdd.pages.iam.IamPage;
import net.thucydides.core.annotations.Step;

public class IamUserSteps {

    IamPage iamPage;

    @Step("Accès à la page de Login IAM")
    public void accesPageLoginIam(String iamUrl){
        iamPage.accesLoginPage(iamUrl);
    }

    @Step("Sélection de l'application {2} par l'utilisateur {0}")
    public void connexionAppViaIam(String username, String password, String appLink){
        iamPage.insertCredentials(username, password);
        iamPage.clickOnConnexionBtn();
        iamPage.clickOnAppLink(appLink);
    }

}
