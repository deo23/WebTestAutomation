Feature: User Logout
  As a logged-in user
  I want to be able to logout from my account
  So that I can securely end my session

  Scenario: Logout from the application
    Given I am logged in
    When I click the burger menu
    And I click the logout button
    Then I should be logged out successfully
