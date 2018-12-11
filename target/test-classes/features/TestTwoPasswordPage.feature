Feature: Test Page when User entering Password in Amazon
Background:
	Given I navigate to the login page using "chrome"
	Then enter valid username
	And click continue
	
@smoketest @sanitytest
Scenario:
	Given verify password page is opened
	Then enter password
	And click signin
	Then check with password "<criteria>"
	And close site
	
	
@realTest
Scenario Outline:
	Given verify password page is opened
	Then enter password as "<password>"
	And click signin
	Then check with password "<criteria>"
	And close site
	Examples:
	|	password	|	criteria|
	|phoneix2532|	valid		|
	|phoenix		|	invalid |
	|						|	empty		|