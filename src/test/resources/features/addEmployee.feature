#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag@addEmp
Feature: adding employee in HRMS application
  
  Background:
  	When user enters valid admin username and password
  	And user clicks on login button
  	Then user is successfully logged in the application
  	When user clicks on PIM option
  	And user clicks on add employee button
 
  @tag1@addEmp
  Scenario: Adding one employee
    When user enters firstname and lastname
    And user clicks on save button
    Then employee added successfully

  @tag2@addEmp
  Scenario: Adding one employee from feature file
  	When user enters "adam" and "lovely" and "farwa"
  	And user clicks on save button
  	Then employee added successfully
  	
  	@tag3@addEmp
  	Scenario Outline: adding multiple employees using scenario outline
  	When user enters "<firstName>" and "<middleName>" and "<lastName>" in data driven format
  	And user clicks on save button
  	Then employee added successfuly 

    Examples: 
     |firstName|middleName|lastName|
     |jean		 |	jac			|jean		 |
		 |pastor	 | angela		| baker	 |
		 |john		 | adam 	  | smith  |
		 
		 @tag4@addEmp@smoke
		 Scenario: adding multiple employees using excel file
		 When user adds multiple employees using excel from "addEmployeeData" and verify it
		 
		 
		 
		 