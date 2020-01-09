Feature: My sample feature
  As a user
  I want to be able to access my account
  So that I can register for courses

  Scenario Outline: See listed courses
    Given I have a user account
    When I login
    Then I see the <course> course

    Examples:
    | course |
    | devops |
    | testing |
    | agile transformation |