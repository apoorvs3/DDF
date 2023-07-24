Feature: Get the stock data history of all the stocks for pre-open market data

  Background: 
    Given I am on the home page of NSE Stock exchange
    Then I hover over Market data to get Market watch

  Scenario: Get data from companies for Pre-open market
    Given Market watch - Pre open market page is opened
    When Table with Stock data is visible
    And Change history range for 1 year
    And Get historical stock data for wach company from the table
    Then Store data in a excel file with average monthly values upto 12 months
