$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/feature/cucumberFeature.feature");
formatter.feature({
  "name": "test site",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "test several features on the site",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "open the page",
  "keyword": "Given "
});
formatter.match({
  "location": "Steps.openThePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click the Women category",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.clickTheWomenCategory()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click the Tops checkbox",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.clickTheTopsCheckbox()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I see count of Tops",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.iSeeCountOfTops()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click Tops checkbox",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.iClickTopsCheckbox()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click Dresses checkbox",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.clickDressesCheckbox()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I see count of Dresses",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.iSeeCountOfDresses()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I make first order",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.iMakeFirstOrder()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I make second order",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.iMakeSecondOrder()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I make third order",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.iMakeThirdOrder()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I see orders in the cart",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.iSeeOrdersInTheCart()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I delete one order",
  "keyword": "When "
});
formatter.match({
  "location": "Steps.iDeleteOneOrder()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I can find deleted order in search",
  "keyword": "Then "
});
formatter.match({
  "location": "Steps.iCanFindDeletedOrderInSearch()"
});
formatter.result({
  "status": "passed"
});
});