package com.cucumber.pages;

import com.cucumber.BaseTest.baseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.cucumber.pages.homePage.checkAccountTab;

public class searchPage extends baseTest {
    public searchPage() throws IOException {
        PageFactory.initElements( driver,this );
    }
    HashMap<String,String> productDetails=new HashMap<String, String>();

    @FindBy(xpath = "//a[@id='unbxd-results-top']")
    public WebElement searchResultMessage;
    @FindBy(xpath = "//div[@unbxdattr='product']")
    public WebElement productClickOnSRP;
    public String addToCartList="//div[@unbxdattr]//a[@title='Add to Cart']";
    public String products="//div[@unbxdattr]";
    public String productPriceSRP="//div[@unbxdattr]//span[@class='price']";

    public String checkSearchMessage()
    {
        return searchResultMessage.getText();
    }

    public pdpPage clickProductOnSRP() throws IOException {
        productClickOnSRP.click();
        return new pdpPage();
    }

    public void addedMoreThanOneProduct() throws InterruptedException {
            List<WebElement> addToCartButtons=driver.findElements( By.xpath(addToCartList) );
            List<WebElement> productSKU=driver.findElements( By.xpath( products ) );
            List<WebElement> productPrice=driver.findElements( By.xpath( productPriceSRP ) );
            for(int i=0;i<3;i++)
            {
                addToCartButtons.get( i ).click();
                Thread.sleep( 3000 );
                productDetails.put( productSKU.get( i ).getAttribute( "unbxdparam_sku" ),productPrice.get( i ).getText() );
            }

    }

    public cartPage clickAndGoToCart() throws IOException, InterruptedException {
        homePage.homePageCart.click();
        Thread.sleep( 2000 );
        pdpPage.clickCartPageButton.click();
        return new cartPage();
    }





}
