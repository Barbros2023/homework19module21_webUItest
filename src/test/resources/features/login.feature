Feature: Login functionality

  As a user
  I want to log into the secure area
  So that I can access restricted features

  Background:
    Given I am on the login page

  Scenario: Successful login with valid credentials
    When I enter username "tomsmith" and password "SuperSecretPassword!"
    And I click the login button
    Then I should see a success message containing "You logged into a secure area!"

  Scenario: Login with invalid password
    When I enter username "tomsmith" and password "wrongpassword"
    And I click the login button
    Then I should see an error message containing "Your password is invalid!"

  Scenario: Login with empty username
    When I enter username "" and password "SuperSecretPassword!"
    And I click the login button
    Then I should see an error message containing "Your username is invalid!"

  Scenario: Login with empty password
    When I enter username "tomsmith" and password ""
    And I click the login button
    Then I should see an error message containing "Your password is invalid!"
