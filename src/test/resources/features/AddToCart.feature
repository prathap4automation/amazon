Feature: Add item to cart



@smoketest
Scenario:
Given open "amazon.in" site in "chrome"
And search for product
|product name|
|dell laptop|
And click enter
Then click on first product
And add to cart
Then verify whether the product added to cart