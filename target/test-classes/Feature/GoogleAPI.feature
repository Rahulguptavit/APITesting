Feature: GoogleAPI testing
@add
Scenario Outline: Testing the add location API
Given Add the Payload "<name>" "<address>" "<language>"
When User submit the "addplace" API with "POST" method
Then Validate the status code "200"
And Validate the "status" in respose is "OK"
And Validate the "scope" in respose is "APP"
And User submit the "getplace" API with "GET" method

Examples:

	|name|address|language|
	|Rahul|Karauli|Hindi|
	|Mahi|Jaipur|English|
	@delete
	Scenario: To delete the laoction
	Given Delete payload
	When User submit the "deleteplace" API with "DELETE" method
	Then Validate the status code "200"
	And Validate the "status" in respose is "OK"

	
