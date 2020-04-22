package com.formation.seletuto.exercise2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class Exercise2Corrected {
    public static void main(String[] args) {
        // Exercise 1a
        // Define where the chromedriver executable is located
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        // Create a Webdriver object called driver. In this case, it is a driver made to automate chrome
        WebDriver driver = new ChromeDriver();
        // Ask the browser to open into full screen mode
        driver.manage().window().maximize();

        // This is the url of the UI of interest
        String url = "https://www.admin.ch";
        // Access the UI
        driver.get(url);
        // End OF DRIVER PREPARATION

        // At this point, the automated browser show the desired page and UI actions can be automated

        // Exercice 1b (click on the French link)
        WebElement frenchLink = driver.findElement(By.xpath(".//a[@href='/gov/fr/accueil.html']"));
        frenchLink.click();

        // Exercise 1c (verify that the seven members of the Federal Council are displayed)
        List<WebElement> councilImages = driver.findElements(By.xpath(".//div[@class='mod mod-imagesbundesrat']//figure"));
        assertThat(councilImages.size(), equalTo(7));

        driver.close();
    }
}
