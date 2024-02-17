Feature: Login

@SuccesfulLogin
  Scenario: Login with correct credeantials
    Given User is in main page
    When Decline discount alert
    And Click Daxil Ol Btn
    And Fills "wemaxek635@cubene.com" in username input
    And Fills "12345Aa!" in password input
    And Click submit btn
    Then User must be login

  @UnsuccesfulLogin
  Scenario Outline: Login with incorrect credeantials
    Given User is in main page
    When Decline discount alert
    And Click Daxil Ol Btn
    And Fills "<username>" in username input
    And Fills "<password>" in password input
    And Click submit btn
    Then User must not be login
    Examples:
      | nane                            | username                    | password | error |
      | empty username                  |                             | 12345Aa! |       |
      | empty password                  | wemaxek635@cubene.com       |          |       |
      | incorrect username and password | wemaxek635546546@cubene.com | 12345Aad |       |
      | empty data                      |                             |          |       |
