package com.cucumber.pages;

import com.cucumber.BaseTest.baseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class cartPage extends baseTest {
    public cartPage() throws IOException {
        PageFactory.initElements( driver,this );
    }

    @FindBy(xpath = "//a[@title='Remove item']")
    public WebElement deleteSingleItem;
    @FindBy(xpath = "//div[@class='page-title']//h1")
    public WebElement validateMessage;



    public void clickOnDelete()
    {
        deleteSingleItem.click();
    }
    public void validateDeleteMessage()
    {

        System.out.println(">> "+validateMessage.getText());
    }


}
