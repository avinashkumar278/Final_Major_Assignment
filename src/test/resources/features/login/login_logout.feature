Feature: As a Amazon user I should be able to login and logout with valid credentials

  Scenario: Login into the application with valid credentials
  	Given I am on the Login page URL "https://www.amazon.in/"
    Then I click on sign in button and wait for sign in page
    Then I should see Sign In Page
    When I enter username as "avinashkumar.aot@gmail.com"
    And I Click on Continue button
    And I enter password as "test1234"
    And click on login button
    Then I am logged in
    And I clear cart items if any
   
