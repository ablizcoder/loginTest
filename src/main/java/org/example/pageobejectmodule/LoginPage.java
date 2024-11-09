package org.example.pageobejectmodule;

import org.example.utility.ApplicationConfig;
import org.example.utility.TestBase;
import org.example.utility.TestUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    TestUtility utility = new TestUtility();

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//button[@id='submit']")
    WebElement submit;

    public LoginPage() {
        PageFactory.initElements(driver,this);
    }
    public void setUsername(){
        utility.waitForElementPresent(username);
        username.sendKeys(ApplicationConfig.readFromConfigProperties("username"));;
    }

    public void setPassword(){
        utility.waitForElementPresent(password);
        password.sendKeys(ApplicationConfig.readFromConfigProperties("password"));
    }

    public void clickSubmitButton(){
        utility.waitForElementPresent(submit);
        submit.click();
    }
}
