@logout
Feature: Logout Functionality

  User Story : As a user, I should be able to log out.

  Background:
    Given user opens a browser and goes to login page
    And user on the discuss page
 @FIX10-355
  Scenario:Verify that the user logs out and returns to the login page.
    When User clicks profile name
    And User clicks the Log out button.
    Then User lands on the login page
  @FIX10-357
  Scenario: Verify that after logging out, the user cannot return to the home page by pressing the back button.
    When User clicks profile name
    And User clicks the Log out button.
    And User lands on the login page
    And User clicks go back button on login page
    Then User can not access the home page again


