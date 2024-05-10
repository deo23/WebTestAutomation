Feature: User Login
  As a user
  I want to be able to login to my account
  So that I can access my personalized content

  Scenario: Successful login
    Given I am on the login page
    When I enter my username and password
    And I click the login button
    Then I should be logged in successfully
