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