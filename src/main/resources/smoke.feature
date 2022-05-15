Feature: Smoke
  As a user
  I want to test all main site functionality
  So that I can be sure that site works correctly

  Scenario Outline: Check product search by search field
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User checks that result title contains '<keyword>'

    Examples:
      | homePage              | keyword |
      | https://www.ebay.com/ | laptop  |
      | https://www.ebay.com/ | short   |

  Scenario Outline: Check add product in the cart
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks first product of list search result page
    And User clicks add to cart button
    Then User checks that amount of products in the icon cart and in the cart title

    Examples:
      | homePage              | keyword |
      | https://www.ebay.com/ | pen     |

  Scenario Outline: Check go to checkout page by Buy It Now button
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks first product of list search result page
    And User clicks Buy It Now button
    And User checks visibility Check out as guest button on a popup
    And User clicks Check out as guest button on a popup
    Then User checks that title current page is '<checkout>'

    Examples:
      | homePage              | checkout | keyword  |
      | https://www.ebay.com/ | Checkout | pen      |

  Scenario Outline: Check remove buy from the cart
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks first product of list search result page
    And User clicks add to cart button
    And User clicks remove item from cart
    Then User checks massage '<text>' cart

    Examples:
      | homePage              | keyword   | text                        |
      | https://www.ebay.com/ | pen       |was removed from your cart.  |

  Scenario Outline: Check match amount of products on the page and item per page selector
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User checks that number of products on the page is equals item per page selector

    Examples:
      | homePage              | keyword |
      | https://www.ebay.com/ | pen     |

  Scenario Outline: Check go to next page with right arrow
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks search button
    And User clicks next page arrow
    Then User checks that url contains new number page

    Examples:
      | homePage              | keyword |
      | https://www.ebay.com/ | pen     |

  Scenario Outline: Check all dropdown visibility for homepage elements
    Given User opens '<homePage>' page
    When User checks dropdown visibility for Categories of search field
    And User checks dropdown visibility for My eBay
    And User checks dropdown visibility for all items of main menu
    And User checks dropdown visibility for Shop by category
    And User clicks Collectibles category of Shop by category
    Then User checks that current category matches Collectibles

    Examples:
      | homePage              |
      | https://www.ebay.com/ |

  Scenario Outline: Check all items of filters for search results page
    Given User opens '<homePage>' page
    When User makes search by keyword '<keyword>'
    And User clicks search button
    Then User checks visibility all items of filters by toggle of filters

    Examples:
      | homePage              | keyword |
      | https://www.ebay.com/ | pen     |

  Scenario Outline: Check valid email by registration
    Given User opens '<homePage>' page
    When User clicks registration button
    And User enters incorrect '<value>' email
    And User clicks password field
    Then User checks massage '<text>' hint for email

    Examples:
      | homePage              | value   | text                                                          |
      | https://www.ebay.com/ | 1       | Email address should be at least 6 characters.                |
      | https://www.ebay.com/ | 111111  | Email address is invalid. Please enter a valid email address. |

  Scenario Outline: Check valid password by registration
    Given User opens '<homePage>' page
    When User clicks registration button
    And User enters incorrect '<value>' password
    And User clicks email field
    Then User checks massage '<text>' hint for password

    Examples:
      | homePage              | value   | text                                                          |
      | https://www.ebay.com/ | 1       | At least 1 letter, a number or symbol, at least 8 characters. |
