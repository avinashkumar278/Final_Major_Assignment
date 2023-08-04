package com.cucumberMainAssignment.testBase;

import com.cucumberMainAssignment.browsers.Browsers;
import com.cucumberMainAssignment.browsers.OS;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;


public class TestBase {

    public static WebDriver driver;


    public WebDriver selectBrowser(String browser) {
        if (System.getProperty("os.name").toLowerCase().contains(OS.WINDOW.name().toLowerCase())) {
            if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            }
        } else if (System.getProperty("os.name").toLowerCase().contains(OS.MAC.name().toLowerCase())) {
            if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            } else if (browser.equalsIgnoreCase(Browsers.FIREFOX.name())) {
                System.setProperty("webdriver.firefox.marionette", System.getProperty("user.dir") + "/src/test/resources/drivers/geckodriver");
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }

    public static String logindetails() throws FileNotFoundException {
        JsonParser jsonParser = new JsonParser();
        FileReader reader = new FileReader("/Users/avinashkumar278/Desktop/Main-Assignment/Cucumber-BDD-Framework/src/main/java/com/cucumberMainAssignment/LoginDetails/login.json");
        Object obj = jsonParser.parse(reader);
        JsonObject userdetailsJson = (JsonObject) obj;
        String username = userdetailsJson.get("username").getAsString();
        return username;
    }

    public static String loginpassword() throws FileNotFoundException {
        JsonParser jsonParser = new JsonParser();
        FileReader reader = new FileReader("/Users/avinashkumar278/Desktop/Main-Assignment/Cucumber-BDD-Framework/src/main/java/com/cucumberMainAssignment/LoginDetails/login.json");
        Object obj = jsonParser.parse(reader);
        JsonObject userdetailsJson = (JsonObject) obj;
        String pwd = userdetailsJson.get("password").getAsString();
        return pwd;
    }
}