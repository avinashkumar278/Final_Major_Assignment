package com.cucumberMainAssignment.stepdefinitions;

import com.cucumberMainAssignment.helper.LoggerHelper;
import com.cucumberMainAssignment.helper.WaitHelper;
import com.cucumberMainAssignment.pageObjects.LoginLogoutPage;
import com.cucumberMainAssignment.testBase.TestBase;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

    public class loginLogoutPageStepDefinitions extends TestBase {

        LoginLogoutPage loginPage = new LoginLogoutPage(driver);
        WaitHelper waitHelper = new WaitHelper(driver);

        Logger logger = LoggerHelper.getLogger(WaitHelper.class);

        @Given("^I am on the Login page URL \"([^\"]*)\"$")
        public void i_am_on_the_Login_page_URL(String arg1) throws Throwable {
            driver.get(arg1);
            waitHelper = new WaitHelper(driver);
            logger.info("I am on the Login page URL");
        }

        @Then("^I click on sign in button and wait for sign in page$")
        public void i_click_on_sign_in_button_and_wait_for_sign_in_page() throws Throwable {
            loginPage.clickSignInButton();
            waitHelper.WaitForElement(loginPage.userName, 60);
            logger.info("I click on sign in button and wait for sign in page");
        }

        @Then("^I should see Sign In Page$")
        public void i_should_see_Sign_In_Page() throws Throwable {
            loginPage.userName.isDisplayed();
            logger.info("I should see Sign In Page");
        }

        @When("^I enter username as$")
        public void i_enter_username_as() throws Throwable {
            loginPage.enterUserName();
            logger.info("I enter username");
        }

        @When("^I Click on Continue button$")
        public void i_Click_on_Continue_button() throws Throwable {
            loginPage.clickContinueButton();
            waitHelper.WaitForElement(loginPage.password, 60);
            logger.info("I Click on Continue button$");
        }

        @When("^I enter password as$")
        public void i_enter_password_as() throws Throwable {
            loginPage.enterPassword();
            logger.info("I enter password");
        }

        @When("^click on login button$")
        public void click_on_login_button() throws Throwable {
            loginPage.clickLoginButton();
            logger.info("click on login button");
        }

        @When("^I am logged in$")
        public void i_am_already_logged_in() throws Throwable {
            loginPage.logoutBtn.isDisplayed();
            logger.info("I am logged in");
        }

        @When("^I Click on Sign out$")
        public void i_Click_on_Sign_out() throws Throwable {
            loginPage.clickLogoutButton();
            waitHelper.WaitForElement(loginPage.userName, 60);
            logger.info("I Click on Sign out");
        }

        @Then("^I clear cart items if any$")
        public void i_clear_cart_items_if_any() throws Throwable {
            loginPage.clearCartItemifExist();
            logger.info("I clear cart items if any");
        }

        @Then("^I search different \"([^\"]*)\" from the search bar$")
        public void i_search_different_from_the_search_bar(String arg1) throws Throwable {
            loginPage.itemSearchField.sendKeys(arg1);
            loginPage.itemSearchField.submit();
            Thread.sleep(5000);
            logger.info("I search different from the search bar");
        }

	
}