package com.cucumber.pages;

import com.cucumber.BaseTest.baseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class pdpPage extends baseTest {
    public String producttitlePDP="";
    public int productQty;

    public pdpPage() throws IOException {
        PageFactory.initElements( driver,this );
    }
    @FindBy(xpath = "//ul[@class='tabs']//a[text()='Description']")
    public WebElement productDescriptions;
    @FindBy(xpath = "//a[@title='Add to Cart']")
    public WebElement addToCartPDP;
    @FindBy(xpath = "//div[@class='small-3 columns']//input")
    public WebElement productQtyCart;
    @FindBy(xpath = "//p[@class='product-name']//a")
    public WebElement productTitleCart;
    @FindBy(xpath = "//h1[@class='product-name']")
    public WebElement productTitlePDP;
    @FindBy(xpath = "//div[@class='actions']//a[text()='View Shopping Cart']")
    public static WebElement clickCartPageButton;

    @FindBy(xpath = "//a[text()='Cart']")
    public WebElement pdpPageCart;


    public void checkProductDescription()
    {
        Assert.assertTrue(productDescriptions.isDisplayed());
    }

    public void increaseProductQty()
    {
            producttitlePDP=productTitlePDP.getText();
         Select allQty= new Select( driver.findElement( By.xpath("//select[@name='qty']") ) );
         allQty.selectByValue( "4" );
         productQty=4;
    }

    public void clickADDtoCartPDP() {
        addToCartPDP.click();
    }

    public void pdpCartProductCheck()
    {
        pdpPageCart.click();
        String addproductOnCart=productTitleCart.getText();
        try{
        Assert.assertEquals( "product title is not same. ",producttitlePDP,addproductOnCart ); }
        finally {
            Assert.assertEquals( "product qty in cart is not same.",productQty,Integer.parseInt(productQtyCart.getAttribute( "value" )) ); }

    }

    public cartPage clickCartPageButton() throws IOException {
        clickCartPageButton.click();
        return new cartPage();
    }

}
