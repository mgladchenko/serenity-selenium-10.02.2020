Login

Meta:
@login

Narrative:
  In order to access application
  As a regular user
  I want to be able to login via email

Scenario: Successful login
Given I open Landing page
When I login with username 'user' and password 'pass'
Then I should see Home page