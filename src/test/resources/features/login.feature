Feature: User Login
  As a user
  I want to be able to login to my account
  So that I can access my personalized content

@runThis
  Scenario: Successful login
    Given I am on the login page
    When I enter my username and password
    And I click the login button
    Then I should be logged in successfully

  # Scenario: Failed login
  #   Given I am on the login page
  #   When I enter invalid username and/or password
  #   And I click the login button
  #   Then I should see an error message

  Scenario: Failed login with unregistered password
    Given I am on the login page
    When I enter my username and an unregistered password
    And I click the login button
    Then I should see an error message

  Scenario: Failed login with unregistered username
    Given I am on the login page
    When I enter an unregistered username and my password
    And I click the login button
    Then I should see an error message

  Scenario: Failed login with empty username
    Given I am on the login page
    When I leave the username field empty
    And I enter my password
    And I click the login button
    Then I should see an error message

  Scenario: Failed login with empty password
    Given I am on the login page
    When I enter my username
    And I leave the password field empty
    And I click the login button
    Then I should see an error message

  Scenario: Failed login with empty username and password
    Given I am on the login page
    When I leave the username and password fields empty
    And I click the login button
    Then I should see an error message