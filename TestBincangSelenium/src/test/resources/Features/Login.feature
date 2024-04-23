Feature: Bincang QA Login Test
  Scenario: Login success on saucedemo
    Given Open web url "https://www.saucedemo.com/"
    And Input username "standard_user" and password "secret_sauce"
    When Click login button
    Then Successfully login and redirect to homepage