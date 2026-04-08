Feature: Login to account
    As a registred user
    I want to login using my credentials
    In order to access my account

    Background:
        Given the user is on the home page
    
    Scenario Outline: User trying to login
        Given the user click on the user login icon

        When the user enters the email "<email>"
        And the user enters the password "<password>"
        And both email and password are "<valid_state>"
        And the user click the login button 

        Then the user must see the following results: "<result>"

        Examples:
            | email                | password  | valid_state | result                                        |
            | tkharbi9a@unvalid.ma | Wr0nGp4ss | invalid     | a red alert with "Incorect email or password" |
            | cigi******@*****.com | ********* | valid       | a green alert with "Succssefully logged in"   |