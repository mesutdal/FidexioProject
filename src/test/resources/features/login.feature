
Feature: Login Functionality

  User Story : As a user, I should be able to log in so that I can land on homepage.

  Background: User should access the login page
    Given user is on the login page

  @FIX10-348 @wip
  Scenario Outline: User should be able to login with valid credentials
    When enter username "<username>" and password "<password>"
    And user click on login button
    Then user should see discuss page
    Examples:
      | username                | password     |
      | salesmanager20@info.com | salesmanager |
      | salesmanager21@info.com | salesmanager |
      | posmanager20@info.com   | posmanager   |
      | posmanager21@info.com   | posmanager   |
  @FIX10-350 @wip
  Scenario Outline: Verify "Wrong login/password" message is displayed using invalid credentials
    When enter username "<username>" and password "<password>"
    And user click on login button
    Then User should see“Wrong login password“ message.
    Examples:
      | username                | password        |
      | posmanager20@info.com   | invalidpassword |
      | invalidusername         | posmanager      |
      | invalidusername         | invalidpassword |
      | salesmanager20@info.com | invalidpassword |
      | invalidusername         | salesmanager    |
      | invalidusername         | invalidpassword |
  @FIX10-351 @wip
  Scenario Outline: Verify "Please fill out this field" message is displayed.
    When enter username "<username>" and password "<password>"
    And user click on login button
    Then user should see the “Please fill out this field”message
    Examples:
      | username                | password     |
      | posmanager20@info.com   |              |
      |                         | posmanager   |
      | salesmanager20@info.com |              |
      |                         | salesmanager |
  @FIX10-352 @wip
  Scenario Outline: Verify that user see the password in bullet signs by default
    When enter username "<username>" and password "<password>"
    Then user should see the password in bullet signs
    Examples:
      | username                | password     |
      | posmanager20@info.com   | posmanager   |
      | salesmanager20@info.com | salesmanager |
  @FIX10-353 @wip
  Scenario Outline: Verify if the ‘Enter’ key of the keyboard is working correctly on the login page
    When enter username "<username>" and password "<password>"
    And user uses the Enter key on keyboard to log in
    Then user should see discuss page
    Examples:
      | username                | password     |
      | salesmanager20@info.com | salesmanager |
      | salesmanager21@info.com | salesmanager |
      | posmanager20@info.com   | posmanager   |
      | posmanager21@info.com   | posmanager   |



