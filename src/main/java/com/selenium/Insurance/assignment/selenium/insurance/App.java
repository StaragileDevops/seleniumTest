package com.selenium.Insurance.assignment.selenium.insurance;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings({ "deprecation" })
	public static void main( String[] args ) 
    {
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        //chromeOptions.addArguments("disable-infobars"); 
        //chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--disable notifications");
        DesiredCapabilities cp = new DesiredCapabilities();
        cp.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        chromeOptions.merge(cp);
        driver = new ChromeDriver(chromeOptions);
        
        driver.get("http://54.249.86.231:8083/contactus.html");
        System.out.println("Opened the website");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        
        
        driver.findElement(By.id("name")).sendKeys("ruchin");
        driver.findElement(By.id("email")).sendKeys("ruchin@ruchin.com");
        driver.findElement(By.id("phone")).sendKeys("9998887788");
        driver.findElement(By.id("message")).sendKeys("Welcome to Insurance website");
        driver.findElement(By.className("btn")).click();
        
        String msg = driver.findElement(By.id("log")).getText();
         if(msg.equals("Submitted Successfully")) {
        	System.out.println("Script is successfull");
        }
        else{
        	System.out.println("Script failed");
        
        }
        


         driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        
       
        
        
        
        //To take the screenshot
        
        TakesScreenshot scrShot = ((TakesScreenshot)driver);
        
        
        
        File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
        
        
        //File destFile = new File("C:\\Users\\HP\\Pictures\\testReports\\screenshot.png");
        
        File destFile = new File("/home/ubuntu/screenshot.png");
        
        
        try {
			FileUtils.copyFile(screenShot, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        if(wait.until(ExpectedConditions.alertIsPresent())==null)
            System.out.println("alert was not present");
        else
            System.out.println("alert was present");*/
        
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        
        
        
        driver.quit();
        
        
        
    


	
		
	}

	
}
