package org.example;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager extends Utils{
    //protected static WebDriver driver;
    LoadProp loadProp = new LoadProp();
    MutableCapabilities sauceOptions = new MutableCapabilities();
    //public String USERNAME = loadProp.getProperty("SAUCE_USERNAME");
    //public String ACCESS_KEY = loadProp.getProperty("SAUCE_ACCESS_KEY");
   //public String URL = "https://"+ USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com/wd/hub";
   public String URL = "https://oauth-suhagiyahetal23-329b9:b5161281-26ee-46e6-99dc-11dc3cb9368f@ondemand.eu-central-1.saucelabs.com/wd/hub";
    public boolean SAUCE_LAB =false;
     public String browserName = System.getProperty("browserName");
    //public String browserName = loadProp.getProperty("browserName");
    public void openBrowser() {
        if(SAUCE_LAB) {
            //running in sauce lab
            System.out.println("running in SauceLab with browser name :" + browserName);
            if (browserName.equalsIgnoreCase("Chrome")) {
                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setExperimentalOption("w3c", true);
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "112");
                browserOptions.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "112");
                browserOptions.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }else if (browserName.equalsIgnoreCase("Edge")) {
                EdgeOptions browserOptions = new EdgeOptions();
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "112");
                browserOptions.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        }else {
            //running locally
            System.out.println("running in local machine with browser name :" + browserName);
            //open Chrome browser
            if (browserName.equalsIgnoreCase("Chrome")) {
                driver = new ChromeDriver();
                //open Firefox browser
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                driver = new FirefoxDriver();
                //open Edge browser
            } else if (browserName.equalsIgnoreCase("Edge")) {
                driver = new EdgeDriver();

            } else {
                System.out.println("Your browser name is incorrect or not implemented" + browserName);
            }
        }
        //open URL
        driver.get(loadProp.getProperty("url"));
        //maximize the window
        driver.manage().window().maximize();
        //apply implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void closeBrowser () {
        driver.close();
    }

}


