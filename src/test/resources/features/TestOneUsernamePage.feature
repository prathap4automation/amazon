Feature: Login Amazon
@smoketest @sanitytest
Scenario: Enter username and continue
	Given I navigate to the login page using "chrome"
	Then enter valid username
	And click continue
	And close site
 
@realtest
Scenario Outline: Amazon username test
	Given I navigate to the login page using "chrome"
	Then enter username as "<username>"
	And click continue
	Then check with "<criteria>"
	And close site
	Examples:
	|	username									|	criteria				|
	|9885675068									|	valid_mobile		|
	|988567											|	invalid_mobile |
	|														|	empty						|
	|prathapmallipeddi@gmail.com|	valid_email			|
	|prathapmallipeddi					|	invalid_email		|
	
	
