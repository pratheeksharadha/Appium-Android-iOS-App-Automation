Feature: Login

  @Smoke
  Scenario: Successful Login

    Given User launches the application
    When User enters valid username
    And User enters valid password
    And User taps Login button
    Then Products page should be displayed

  @Smoke
  Scenario Outline: Login

    When User logs in with "<username>" and "<password>"

    Examples:
      | username | password |
      | bob      | 10203040 |
      | alice    | password |