package com.cucumberMainAssignment.pageObjects;


import com.cucumberMainAssignment.helper.WaitHelper;
import com.cucumberMainAssignment.testBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.util.List;


    public class LoginLogoutPage extends TestBase {

        private WebDriver driver;

        @FindBy(xpath="//input[@type='email']")
        public WebElement userName;

        @FindBy(xpath="//input[@id='continue']")
        WebElement Continue;

        @FindBy(xpath="//input[@type='password']")
        public WebElement password;

        @FindBy(xpath="//input[@id='signInSubmit']")
        WebElement loginButton;

        @FindBy(xpath="//div[@id='nav-tools']/a[@data-nav-role='signin']")
        WebElement SignInfromNav;

        @FindBy(xpath="//span[contains(text(),'Sign')]/parent::a")
        public WebElement logoutBtn;

        @FindBy(xpath="//a[@id='nav-cart']")
        public WebElement cartButton;

        @FindBy(xpath="//form[@id='activeCartViewForm']/div[@data-name='Active Items' or contains(@class,'sc-list-body')]//input[@value='Delete']")
        public List<WebElement> itemList;

        //form[@id='activeCartViewForm']/div[@data-name='Active Items' or contains(@class,'sc-list-body')]//input[@value='Delete']

        @FindBy(xpath="//div[contains(@class,'nav-search-field')]/input")
        public WebElement itemSearchField;

        WaitHelper waitHelper;

        public LoginLogoutPage(WebDriver driver){
            this.driver = driver;
            PageFactory.initElements(driver, this);
            waitHelper = new WaitHelper(driver);
            //waitHelper.WaitForElement(userName, 60);
        }

        public void enterUserName() throws FileNotFoundException {
            String str=TestBase.logindetails();
            this.userName.sendKeys(str);
        }

        public void enterPassword() throws FileNotFoundException {
            String str1=TestBase.loginpassword();
            this.password.sendKeys(str1);
        }

        public void clickLoginButton(){
            loginButton.click();
        }



        public void clickSignInButton(){
            Actions builder = new Actions(driver);
            builder.moveToElement(SignInfromNav).build().perform();
            SignInfromNav.click();
        }

        public void clearCartItemifExist(){
            cartButton.click();
            int i = itemList.size();
            if(i>=1){
                itemList.get(0).click();
                i = itemList.size();
            }
        }

        public void clickContinueButton(){
            Continue.click();
        }

        public void clickLogoutButton(){
            Actions builder = new Actions(driver);
            builder.moveToElement(SignInfromNav).build().perform();
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click();", logoutBtn);;
        }
    }


