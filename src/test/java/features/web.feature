Feature: test automation web

  @web
  Scenario: successfully login web
    Given open web login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    And user click login button
    And user will see icon cart

  @web
  Scenario: unsuccessfully login web user has been locked out
    Given open web login page
    And user input username "locked_out_user"
    And user input password "secret_sauce"
    And user click login button
    And user will see err message "Sorry, this user has been locked out."

  @web
  Scenario: unsuccessfully login web username and password do not match
    Given open web login page
    And user input username "locked_out_user"
    And user input password "secret_sauced"
    And user click login button
    And user will see err message "Username and password do not match any user in this service"

  @web
  Scenario: successfully login web add to cart
    Given open web login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    And user click login button
    And user will see icon cart
    And user add item to cart
    And user add item to cart
    And user add item to cart
    Then verify cart item is match "3"

  @web
  Scenario: successfully login web remove to cart
    Given open web login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    And user click login button
    And user will see icon cart
    And user add item to cart
    And user add item to cart
    And user add item to cart
    And user add item to cart
    Then verify cart item is match "4"
    And user remove item to cart
    And user remove item to cart
    Then verify cart item is match "2"

  @web
  Scenario: Successfully checkout product
    Given open web login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    And user click login button
    And user will see icon cart
    And user add item to cart
    And user open shopping cart
    And user click checkout button
    And user input checkout firstname "John"
    And user input checkout lastname "Doe"
    And user input checkout postal code "12345"
    And user click continue button
    Then user should see checkout overview page
    When user click finish button
    Then user should see checkout success message "Thank you for your order!"

  @web
  Scenario: sort by name
    Given open web login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    And user click login button
    And user will see icon cart
    When user select sort by name Z to A
    Then verify product sorted alphabetically by name from Z to A
    When user select sort by name A to Z
    Then verify product sorted alphabetically by name from A to Z

  @web
  Scenario: sort by price
    Given open web login page
    And user input username "standard_user"
    And user input password "secret_sauce"
    And user click login button
    And user will see icon cart
    When user select sort by price high to low
    Then verify product sorted alphabetically by name from high to low
    When user select sort by price low to high
    Then verify product sorted alphabetically by name from low to high
