Feature: Login to account
    As a registred user
    I want to login using my credentials
    In order to access my account

    Background:
        Given the user is on the home page
        And   the user closed the cookies baner
    
    Scenario Outline: User trying to login
        Given the user click on the user login icon

        When the user enters the email: "<email>" and password: "<password>"
        And the user click the login button 

        Then the user must see a popup displaying the message: "<result>"

        Examples:
            | email                 | password  | result                      |
            | tkharbi9a@unvalid.ma  | Wr0nGp4ss | Incorrect email or password |
            | cigib67333@kobace.com | 0NcF$1234 | Successfully logged in      |