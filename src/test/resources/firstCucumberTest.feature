Feature: Try first Cucumber scenario

  Scenario: Our first Cucumber scenario
    Given Koke home page
    When we are pressing Registration button
    Then we are on Registration page
    When we are filling in registration form:
      | iin      | 760524415972 |
      | email    | test@test.lv |
      | phone    | 496123456    |
      | password | Qwerty!2345  |
    And we are pressing submit button
    Then we are on the step2 page


  Scenario: New user creation check
    Given client:
      | name  | Vasja        |
      | iin   | 123456789    |
      | age   | 30           |
      | mail  | test@test.lv |
      | phone | +3712345678  |

    And income data is:
      | amount   | 3000.00      |
      | employer | SomeEmployer |
      | expenses | 1000.00      |

    When we are registering this client
    And checking it in ERP

    Then client data is correct
















