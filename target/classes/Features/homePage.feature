Feature: Home page

  Scenario: Home page elements test
    Given Home page check logo
    When home page all elements are plesent

  Scenario: Home page search feature test
    Given Home page check logo
    When Enter query in search box and press enter key
    Then check the search result page

  Scenario: Product click on home page
      Given Home page check logo
      When click product in Home page
      Then validate the PDP page

  Scenario: test Add to cart button in home page
    Given Home page url "https://www.miniaturemarket.com/"
    When Click add to cart button from product
    Then Click on cart
    And validate the product from cart
  @Sanity
  Scenario: test login in Home page
    Given Home page url "https://www.miniaturemarket.com/"
    When Click on account tab
    Then Enter user and pass and click on login
# Then validate logout button
  @EndToEnd
  Scenario: Test product qty in PDP page.
    Given Home page url "https://www.miniaturemarket.com/"
    When Search query and go to the SRP
    Then Click any product from SRP and go to the PDP
    Then Increase the qty of the product
    Then Click add to card
    Then Click on cart icon and validate the product


  Scenario: Test delete button in cart page.
    Given Home page url "https://www.miniaturemarket.com/"
    When Search query and go to the SRP
    Then Click any product from SRP and go to the PDP
    Then Increase the qty of the product
    Then Click add to card
    Then Click on cart icon and validate the product
    Then go to the cart page
    Then click on delete icon form cart list
    Then validate product is deleted or not

#    Scenario: Test delete all button in cart page
#      Given Home page url "https://www.miniaturemarket.com/"
#      When Search query and go to the SRP
#      Then Click add to cart button from SRP for more that one product
#      Then Click on cart icon and validate the product
#      Then go to the cart page
#      Then click on delete icon form cart list
#      Then validate product is deleted or not