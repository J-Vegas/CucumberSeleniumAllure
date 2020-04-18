Feature: LoginFeature

  Scenario: Authorization with correct username and password
    Given User navigate to the login page
    And User enter for Login "testforlanit"
    And User enter for Password "qwe321zxc"
    And User click login button
    Then User is enter
