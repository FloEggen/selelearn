package com.formation.seletuto.serenitybdd.bddsteps;

import com.formation.seletuto.serenitybdd.RduConfig;
import com.formation.seletuto.serenitybdd.properties.RduProperties;
import com.formation.seletuto.serenitybdd.usersteps.IamUserSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.junit.spring.integration.SpringIntegrationSerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@RunWith(SpringIntegrationSerenityRunner.class)
@ContextConfiguration(classes = {RduConfig.class})
public class IamSteps {

    //@Value("${spring.profiles.active}")
    //String environment;

    @Autowired
    private RduProperties rduProperties;

    @Steps
    IamUserSteps iamUserSteps;

    @Given("Un utilisateur accède à l'application rdu via le portail iam")
    public void accesRduViaIam() {
        String iamUrl = rduProperties.getIamUrl();
        iamUserSteps.accesPageLoginIam(iamUrl);
        String username = rduProperties.getUsername();
        String password = rduProperties.getPassword();
        String rduLink = rduProperties.getAppLink();
        iamUserSteps.connexionAppViaIam(username, password, rduLink);
    }

}
