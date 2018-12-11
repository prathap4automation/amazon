$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/AddToCart.feature");
formatter.feature({
  "line": 1,
  "name": "Add item to cart",
  "description": "",
  "id": "add-item-to-cart",
  "keyword": "Feature"
});
formatter.before({
  "duration": 479237,
  "status": "passed"
});
formatter.before({
  "duration": 437292,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "",
  "description": "",
  "id": "add-item-to-cart;",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 5,
      "name": "@smoketest"
    }
  ]
});
formatter.step({
  "line": 7,
  "name": "open \"amazon.in\" site in \"chrome\"",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "search for product",
  "rows": [
    {
      "cells": [
        "product name"
      ],
      "line": 9
    },
    {
      "cells": [
        "dell laptop"
      ],
      "line": 10
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "click enter",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "click on first product",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "add to cart",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "verify whether the product added to cart",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "amazon.in",
      "offset": 6
    },
    {
      "val": "chrome",
      "offset": 26
    }
  ],
  "location": "GlueCodeToAddCart.openSite(String,String)"
});
formatter.result({
  "duration": 11468033041,
  "status": "passed"
});
formatter.match({
  "location": "GlueCodeToAddCart.searchForProduct(DataTable)"
});
formatter.result({
  "duration": 375763923,
  "status": "passed"
});
formatter.match({
  "location": "GlueCodeToAddCart.clickSearchBtn()"
});
formatter.result({
  "duration": 3186459200,
  "status": "passed"
});
formatter.match({
  "location": "GlueCodeToAddCart.click_on_first_product()"
});
formatter.result({
  "duration": 6160480022,
  "status": "passed"
});
formatter.match({
  "location": "GlueCodeToAddCart.add_to_cart()"
});
formatter.result({
  "duration": 5055715053,
  "error_message": "java.lang.NullPointerException\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.elementIfVisible(ExpectedConditions.java:315)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions.access$100(ExpectedConditions.java:44)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:301)\r\n\tat org.openqa.selenium.support.ui.ExpectedConditions$10.apply(ExpectedConditions.java:298)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:260)\r\n\tat tests.GlueCodeToAddCart.add_to_cart(GlueCodeToAddCart.java:91)\r\n\tat ✽.And add to cart(src/test/resources/features/AddToCart.feature:13)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "GlueCodeToAddCart.verifyCart()"
});
formatter.result({
  "status": "skipped"
});
});