package com.formation.seletuto.setup;

import com.formation.seletuto.drivers.DriverSelection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDrivers {
    public static void main(String[] args) {
        // The goal here is to clean the code creating a WebDriver instance
        // by creating a class called DriverSelection

        WebDriver driver = DriverSelection.createWebDriverFor("ie");

        // This is the url of the UI of interest
        String url = "https://www.admin.ch";
        // Access the UI
        driver.get(url);

        // At this point, the automated browser shows the desired page and UI actions can be automated
        // ...
        driver.close();
    }
}
