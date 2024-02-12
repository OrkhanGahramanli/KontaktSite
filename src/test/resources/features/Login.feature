Feature: Login

@SuccesfulLogin
  Scenario: Login with correct credeantials
    Given User is in main page
    When Decline discount alert
    And Click Daxil Ol Btn
    And Fill the username btn with dynamic string "wemaxek635@cubene.com"
    And Fill the password btn with dynamic string "12345Aa!"
    And Click submit btn
    Then User must be login

  @UnsuccesfulLogin
  Scenario Outline: Login with incorrect credeantials
    Given User is in main page
    When Decline discount alert
    And Click Daxil Ol Btn
    And Fill the username btn with dynamic string "username"
    And Fill the password btn with dynamic string <password>
    And Click submit btn
    Then User must not be login
    Examples:
      | nane                            | username                    | password | error |
      | empty username                  |                             | 12345Aa! |       |
      | empty password                  | wemaxek635@cubene.com       |          |       |
      | incorrect username and password | wemaxek635546546@cubene.com | 12345Aad |       |
      | empty data                      |                             |          |       |
