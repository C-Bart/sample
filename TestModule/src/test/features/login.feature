#language: en

Business Need: Ability to log in to the TestModule application

  @login @prod @stag @dev
  Scenario: Successful log in to the TestModule
    When user fill login form correctly
    Then user has access to the TestModule