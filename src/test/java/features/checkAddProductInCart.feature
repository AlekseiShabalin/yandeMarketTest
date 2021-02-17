Feature: Checking if an item was added to the cart
  Checking whether the title and price match on the homepage and in the shopping cart

  Scenario: Cost and name match
    Given go to website 'https://market.yandex.ru/'
    When go to catalog
    Then save name second product on the home page
    Then save cost second product on the home page
    Then put second item in the cart
    Then go to cart
    Then compare the name of the item in the cart with the name on the main page
    Then compare the cost of an item in the cart by its status on the home page
