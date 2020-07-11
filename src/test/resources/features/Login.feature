Feature: JIRA Functionality

  @1234
  Scenario: Verify JIRA Login Functionality
    Given User navigates to the "http://localhost:8080" website
    And I enter the username "mahendranathk" and password "jaishankar1204" and I verify statuscode as "200"
    Then I verify name as "JSESSIONID" in the response


  @12345
  Scenario Outline: Verify create issue functionality in  JIRA
    Given User navigates to the "http://localhost:8080" website
    And I enter the username "mahendranathk" and password "jaishankar1204" and I verify statuscode as "200"
    Then I create an issue as "<IssueType>" with "<Description>" and "<Summary>"
    Then I verify issue is created successfully

    Examples:
    |IssueType | Description | Summary|
    | Bug      | Creating defect| Defect   |
    | Story      | Creating a Story| Story   |

