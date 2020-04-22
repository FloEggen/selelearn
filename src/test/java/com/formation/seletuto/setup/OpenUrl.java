package com.formation.seletuto.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class OpenUrl {
    public static void main(String[] args) {
        // The goal of this little program is to check if everything is correctly installed on the current machine
        // If yes, a chrome browser should be opened with the desired url

        // Define where the chromedriver executable is located (the version of this .exe file should be compatible
        // with the current version of Chrome installed on your machine)
        // Check the compatibility on https://chromedriver.chromium.org/downloads
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        // Create a Webdriver object called driver. In this case, it is a driver made to automate chrome
        WebDriver driver = new ChromeDriver();
        // Ask the browser to open into full screen mode
        driver.manage().window().maximize();
        // Ask for any web element search to wait for maximum 10 seconds on it
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // This is the url of the UI of interest
        String url = "https://www.admin.ch";
        // Access the UI
        driver.get(url);

        // At this point, the automated browser shows the desired page and UI actions can be automated
        // ...
        driver.close();
    }
}
