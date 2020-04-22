package com.formation.seletuto.serenitybdd.bddsteps;

import com.formation.seletuto.serenitybdd.RduConfig;
import com.formation.seletuto.serenitybdd.properties.RduProperties;
import com.formation.seletuto.serenitybdd.usersteps.RduAdminUserSteps;
import com.formation.seletuto.serenitybdd.usersteps.RduGeneralUserSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.junit.spring.integration.SpringIntegrationSerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@RunWith(SpringIntegrationSerenityRunner.class)
@ContextConfiguration(classes = {RduConfig.class})
public class RduSteps {

    //@Value("${spring.profiles.active}")
    //String environment;

    @Autowired
    private RduProperties rduProperties;

    @Steps
    RduGeneralUserSteps rduGeneralUserSteps;

    @Steps
    RduAdminUserSteps rduAdminUserSteps;


    @And("^l'utilisateur choisit le contexte '(.*)'$")
    public void andTheProfileIsSelected(String profil) {
        rduGeneralUserSteps.choixDuProfil(profil);
    }

    @When("^l'utilisateur créé un profil avec code: '(.*)', libellé: '(.*)' et droits: '(.*)'$")
    public void whenAProfileIsCreatedWithCodeLibelleAndRights(String code, String libelle, String rights) {
        rduAdminUserSteps.accesALaSectionViaMenu("Habilitations","Administration");
        rduAdminUserSteps.accesALOnglet("Profils");
        rduAdminUserSteps.ensureProfileWithCodeIsEmpty(code);
        rduAdminUserSteps.createProfileWithCodeLibelleAndRights(code, libelle, rights);
    }

    @Then("^le profil avec le code '(.*)' existe dans la liste des profils$")
    public void thenTheProfileExistsInTheList(String code) {
        rduAdminUserSteps.verifiesProfilExists(code);
        rduAdminUserSteps.ensureProfileWithCodeIsEmpty(code);
    }

}
