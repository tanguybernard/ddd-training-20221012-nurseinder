Feature: Create Nurse

  Scenario: A Nurse account is created

    Given user wants to create an nurse account with the following attributes
      | id  | name   | email               |
      | 100 | Rachel | rachel.green@fs.com |

    When user saves the Nurse account
    Then the save 'IS SUCCESSFUL'
    #AND The response Content to create nurse should be