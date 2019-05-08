#language: en

  Business Need: Availability of the TestModule application

    Background:
      When user fill login form correctly
      Then user has access to the Partners

    @availability
    Scenario: Worker has access to the delivery filter
      Then user has access to the delivery filter

    @availability
    Scenario: Worker has access to the form to add new delivery
      Then user has access to the form to add new delivery

    @availability
    Scenario: Worker has access to orders
      Then user has access to orders

    @availability
    Scenario: Worker has access to analytics section
      Then user has access to analytics section