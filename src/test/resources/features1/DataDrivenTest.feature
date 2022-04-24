#Author: aditya.kgec91@gmail.com
@datadriventest
Feature: User Registration in MecuryFlight site
  #DataTable for UserDetails using raw()
  @Registration1
  Scenario: Single User Registration
    When Registration page Displayed
    Then I enter valid data on page
      | FirstName       | Aditya     |	
      | LastName        | Roy        |
      | Phone           | 7501451189 |
      | Email           | a@test.com |
      | UserName        | aditya     |
      | Password        | test123    |
      | ConfirmPassword | test123    |
    Then Click on Submit Button
     And Thank you for registering: should be displayed
    Then Click on Signoff
     And Close the Browser
     
     #Using Map in DataTable
  @Registration2
  Scenario: Multiple User Registration using HASHMAP
    When Registration page Displayed
    Then I enter valid data on registration page and verify post-registration
      | firstname | lastname | salary      | gender      |
      | Aditya    | Roy      | 7501451187 | a@text.com   | 
      | Rakesh    | Sinha    | 7589866698 | b@rars.com   | 
      | Preety    | Sharma   | 8598745805 | preety@t.com |
     And Close the Browser
     
	