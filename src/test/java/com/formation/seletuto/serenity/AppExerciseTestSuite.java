package com.formation.seletuto.serenity;

import com.formation.seletuto.serenity.steps.AppSteps;
import com.formation.seletuto.serenity.usersteps.AppUserSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTagValuesOf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

// SerenityRunner comes from serenity junit maven dependency
@RunWith(SerenityRunner.class)
public class AppExerciseTestSuite {

    @Managed
    WebDriver driver;

    @Steps
    AppSteps appSteps;

    @Test
    @WithTagValuesOf("AppTag")
    @Title("Test de l'application n°1")
    public void testTheApp(){
        System.out.println("TEST START!");
        appSteps.loginStep();
        appSteps.clickOnCultureLink();
    }

}
