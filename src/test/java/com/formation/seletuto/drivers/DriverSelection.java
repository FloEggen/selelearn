package com.formation.seletuto.drivers;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSelection implements DriverSource {

    @Override
    public WebDriver newDriver() {
        String driverName = System.getProperty("driverx");
        WebDriver driver = null;
        System.out.println("The custome driver way is used!");
        if (driverName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }

}
