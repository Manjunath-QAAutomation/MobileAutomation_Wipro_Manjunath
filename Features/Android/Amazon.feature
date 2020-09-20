Feature: Purchase a TV in Amazon mobile application
  Description: Login to amazon mobile application and search for an item and add to cart and purchase it


   Background: 
    Given user launches the app
    Then  User clicks on hamburger Menu
    And Login to amazon application
    
   
   Scenario: Login to the app and search the product
   
    And Validate text Amazon Logo is displayed
    And User clicks on Amazon button
    And Validate Search Bar is displayed
   	And Verify the Suggestion on the Home Page
   	And Choose the current location
    And Search for the product "65-inch TV"
    And Validate "65-inch TV" is displayed
    And User selects the product from the list
    And Verify product details are displayed
    And User Verifies the details of the selected Product
    And User Add's the product to the Cart
    Then User closes the app
    
    
    Scenario: Verify the Product in the cart
    
    And Navigate to the Cart menu
    And User clicks on Proceed to Buy button
    Then User closes the app
    
