Feature: 00 Register Login Android

  @test
  Scenario: (+) User can access screen register
    Given user on screen login
    When user click Create one
    Then user success on screen register

  @test
  Scenario: (-) User verify message error in field email with username
    When user fill full name
    And user fill username
    And user fill password
    And user fill confirm password
    Then user click button register
    And user verify message error

  @test
  Scenario: (+) User success register account and success login after register
    When user fill full name
    And user fill email
    And user fill password
    And user fill confirm password
    Then user click button register
    And collect data account after registeter
    And user click member Login
    Given user on screen login
    When user input email correct
    And user input password correct
    And user click button login
    Then user success on screen dashboard

