Feature: Login


  Scenario: Login with correct credeantials
    Given User is in main page
    When Decline discount alert
    And Click Daxil Ol Btn
    And Fill the username btn
    And Fill the password btn
    And Click submit btn
    Then User must be login