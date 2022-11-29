Feature: Contested E2E Journey

  Scenario Outline: contested E2E journey via solicitor
    Given <user> login to hmcts
    When <user> creates a case
    When <user> fills form A application
    Examples:
      | user        |
      | "Solicitor" |

  Scenario Outline: contested E2E journey via Case worker
    Given <user> login to hmcts
    When <user> creates a case
    When <user> fills form A application
    Examples:
      | user        |
      | "Case worker" |

