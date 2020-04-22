package com.formation.seletuto.serenity.steps;

import com.formation.seletuto.serenity.AppConfig;
import com.formation.seletuto.serenity.pages.HomePage;
import com.formation.seletuto.serenity.properties.AppProperties;
import net.serenitybdd.junit.spring.integration.SpringIntegrationSerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Step;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

@RunWith(SpringIntegrationSerenityRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class AppSteps {

    //@Value("${spring.profiles.active}")
    //String environment;

    @Shared
    HomePage homePage;

    @Autowired
    private AppProperties appProperties;

    @Step("Accès à l'application")
    public void loginStep() {
        String sUrl = appProperties.getAppUrl();
        homePage.accessPage(sUrl);
    }

    @Step("Click sur le lien Culture")
    public void clickOnCultureLink() {
        homePage.clickOnCultureLink();
    }


}
