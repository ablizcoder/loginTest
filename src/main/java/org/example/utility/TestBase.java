package org.example.utility;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

public class TestBase {
    public static WebDriver driver;
    public static String configFile="config.properties";
    public static String sysName=System.getProperty("os.name");
    public static Properties prop=new Properties();
    static {
        String workingDirectory=System.getProperty("user.dir");
        try {
            prop.load(new FileInputStream(workingDirectory+ File.separator+"config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void initialization(String urlKey){
        if (driver==null){
            ChromeOptions options=new ChromeOptions();
            options.setBinary("C:\\chrome-win64\\chrome.exe");
            options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            System.out.println("**************************");
            System.out.println(sysName);
            if (sysName.contains("Mac")){
                System.out.println("Running on Mac mode");
                System.setProperty("webdriver.chrome.driver","/Applications/chromedriver");
                driver=new ChromeDriver(options);
                driver.manage().window().maximize();
                driver.get(ApplicationConfig.readFromConfigProperties(configFile,urlKey));
            }
            else if (sysName.toLowerCase().contains("server")){
                System.out.println("Running on headless mode");
                System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver");
                driver=new ChromeDriver(options);
                options.addArguments(Arrays.asList("--headless","disable-gpu"));
                options.addArguments("window-size=1920,1080");
                driver.get(ApplicationConfig.readFromConfigProperties(configFile,urlKey));
            }
            else if (sysName.contains("Windows")){
                System.out.println("Running on Windows mode");
                System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver.exe");
                driver=new ChromeDriver(options);
                driver.manage().window().maximize();
                driver.get(ApplicationConfig.readFromConfigProperties(configFile,urlKey));
            }
        }
    }
    public static void closeBrowser(){
        driver.close();
        driver.quit();
        driver=null;
    }
}
