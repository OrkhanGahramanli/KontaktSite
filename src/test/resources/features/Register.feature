Feature: Login


  @SuccesfulRegistration
  Scenario: Login with correct credeantials
    Given User is in main page
    When Decline discount alert
    And Click Daxil Ol Btn
    And Click Register Btn
    And Fill the firstName Btn with dynamic string "My First Name"
    And Fill the secondName Btn with dynamic string "My Second Name"
    And Fill the email with dynamic string "amation347@gmail.com"
    And Fill the paswords with dynamic string "12345Aa!"
    Then Click the Registerr Btn

  @UnsuccesfulRegistration
  Scenario Outline: Login with incorrect credentials
    Given User is in main page
    When Decline discount alert
    And Click Daxil Ol Btn
    And Click Register Btn
    And Fill the firstName Btn with dynamic string <username>
    And Fill the secondName Btn with dynamic string <secondname>
    And Fill the email with dynamic string <email>
    And Fill the paswords with dynamic string <password>
    And Click the Registerr Btn
    Then User shouldn't be registered
    Examples:
      | name             | username     | secondname     | email                  | password    |  |
      | emyty username   |              | theseconnname0 | randomemail0@gmail.com | 12345Aa2    |  |
      | empty secondname | theusername1 |                | randomemail1@gmail.com | 12345Aa!22  |  |
      | empty email      | theusername2 | thesecond2name |                        | 12345Aa3556 |  |
      | empty password   | theusername3 | thesecondname  | randomemail3@gmail.com |             |  |



