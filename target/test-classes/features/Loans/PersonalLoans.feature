Feature: Loans Calculate Feature
  Verify loan offers upon filling the required form fields with valid inputs.

 Scenario: Validate loan, apr, term for the customer
     	Given User is on personal loans page
     	When I enter any amount
     	And I select loan purpose
     	Then I click on Check Rate button
     	When I enter personal details information
     	And I click on Continue button
     	When I add borrower income and additional income
     	And I click Continue button
     	When I enter user credentials and submit
     	When I Sign out the application
     	When I Login to the application
     	Then I validate loans information