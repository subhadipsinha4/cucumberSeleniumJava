package com.cucumber.BaseTest;

import com.cucumber.Util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class baseTest {
    public static WebDriver driver;
    public static Properties prop;

    public baseTest() throws IOException {
        prop=new Properties();
        FileInputStream fis=new FileInputStream( "C:\\CucumberPOM\\src\\main\\java\\com\\cucumber\\config\\config.properties" );
        prop.load( fis );
    }

    public static void initializ(){
        String browserName=prop.getProperty( "browser" );
        if(browserName.equals( "chrome" ))
        {
            System.setProperty(prop.getProperty( "CHROME_KEY" ),prop.getProperty( "CHROME_VALUE" ) );
            driver=new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait( TestUtil.IMPLICIT_TIME, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME, TimeUnit.SECONDS);
    }

}
