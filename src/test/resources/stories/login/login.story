Login

Meta:
@login
@smoke

Narrative:
  In order to access application
  As a regular user
  I want to be able to login via email

Lifecycle:
Before:
Scope: SCENARIO
Given I open Landing page

Scenario: Successful login
When I login with username userEmail and password userPassword
Then I should see Home page

Examples:
| userEmail                     | userPassword |
| linkedin.tst.yanina@gmail.com | Test123!     |
| linkedin.TST.yanina@gmail.com | Test123!     |
