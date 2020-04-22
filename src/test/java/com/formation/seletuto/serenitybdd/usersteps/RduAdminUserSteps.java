package com.formation.seletuto.serenitybdd.usersteps;

import com.formation.seletuto.serenitybdd.pages.rdu.ProfilPage;
import com.formation.seletuto.serenitybdd.pages.rdu.TransversePage;
import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;

public class RduAdminUserSteps {

    TransversePage transversePage;
    ProfilPage profilPage;

    @Step("Accès à la section {0} via le menu {1}")
    public void accesALaSectionViaMenu(String sectionLink, String menu){
        transversePage.clickOnMenu("Administration", true);
        transversePage.clickOnMenuItem("Habilitations");
        transversePage.waitForSpinner();
    }

    @Step("Accès à l'onglet {0}")
    public void accesALOnglet(String tabName){
        transversePage.clickOnTab(tabName);
        transversePage.waitForSpinner();
    }

    @Step("Création d'un profile avec code: {0}, libellé: {1} et droits: {2}")
    public void createProfileWithCodeLibelleAndRights(String code, String libelle, String rights){
        profilPage.clickAjouter();
        profilPage.insertCodeAndLibelle(code, libelle);
        profilPage.choixDesDroits(rights);
        profilPage.clickSave();
        transversePage.waitForSpinner();
    }

    @Step("Vérification de l'existance du profil avec code {0}")
    public void verifiesProfilExists(String profilcode){
        profilPage.insertCodeInArea(profilcode);
        int numOfResults = profilPage.findNumberOfFilteredResults();
        Assertions.assertThat(numOfResults).isEqualTo(1);
    }

    @Step("Vérification de l'inexistance du profil avec code {0} (s'il existe, le supprimmer)")
    public void ensureProfileWithCodeIsEmpty(String profilcode){
        profilPage.insertCodeInArea(profilcode);
        int numOfResults = profilPage.findNumberOfFilteredResults();
        if(numOfResults>0) {
            profilPage.clickOnFirstResult();
            transversePage.waitForSpinner();
            profilPage.clickSupprimer();
            transversePage.waitForSpinner();
            profilPage.insertCodeInArea(profilcode);
            numOfResults = profilPage.findNumberOfFilteredResults();
        }
        Assertions.assertThat(numOfResults).isEqualTo(0);
    }



}
