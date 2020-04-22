package com.formation.seletuto.drivers;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class DriverSelection {

    public static WebDriver createWebDriverFor(String driverName){
        WebDriver driver;
        switch (driverName){
            case "chrome":
                driver = setChromeDriver();
                break;
            case  "firefox":
                driver = setFirefoxDriver();
                break;
            case "ie":
                driver = setIeDriver();
                break;
            default:
                throw new RuntimeException("The drivername " + driverName + " is not valid");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver setChromeDriver(){
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver setFirefoxDriver(){
        WebDriver driver;
        System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver setIeDriver(){
        WebDriver driver;
        System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");
        InternetExplorerOptions options = new InternetExplorerOptions();
        driver = new InternetExplorerDriver();
        return driver;
    }

}
