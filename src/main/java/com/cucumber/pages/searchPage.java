package com.cucumber.pages;

import com.cucumber.BaseTest.baseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static com.cucumber.pages.homePage.checkAccountTab;

public class searchPage extends baseTest {
    public searchPage() throws IOException {
        PageFactory.initElements( driver,this );
    }
    @FindBy(xpath = "//a[@id='unbxd-results-top']")
    public WebElement searchResultMessage;
    @FindBy(xpath = "//div[@unbxdattr='product']")
    public WebElement productClickOnSRP;

    public String checkSearchMessage()
    {
        return searchResultMessage.getText();
    }

    public pdpPage clickProductOnSRP() throws IOException {
        productClickOnSRP.click();
        return new pdpPage();
    }





}
