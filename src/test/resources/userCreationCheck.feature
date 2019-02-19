Feature: User Registration

  Scenario: User registration check
    Given user:
      | pk      | 111111-11111   |
      | name    | Evlampij       |
      | surname | Kruljianovichs |
      | phone   | 112            |
      | email   | test@test.lv   |

    And registration page

    When we are registering new user
    And requesting all users list

    Then current user is in this list