@Regression
Feature: LoggedIn user view

  Scenario: Validate user is bale to logged in
    Given User navigates to the login page
    When user enter login details
    Then user should view product category page

