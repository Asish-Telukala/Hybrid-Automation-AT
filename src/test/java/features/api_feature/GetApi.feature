
Feature: Verify the api
  @Smoke1
  Scenario: Verify the get API for the products
    Given I hit the product "docs"
    When send "GET" request
    Then validate the response code "200"


  Scenario: Verify the get API for the products
    Given I hit the product "donate"
    When send "GET" request
    Then validate the response code "200"