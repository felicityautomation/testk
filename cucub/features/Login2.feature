#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
@tag
Feature: Login feature of Facebook

  Scenario Outline: Test login with various credentials
    Given user is on the browser
    When user navigates to the login page
    And enter user name as '<username>' and password as '<password>'
    Then error message is displayed in Login page '<validLogin>'
    And close the browser

    Examples: 
      | username    | password | validLogin |
      | bharathedu1 |   123456 | true       |
      | user2       | xyz212   | false      |

  @tag1
  Scenario: Login with negetive credentials
    Given user is on the browser
    When user navigates to the login page
    And enter user name as 'bharathedu1' and password as '123456'
    Then user will be on Home page
    And close the browser
