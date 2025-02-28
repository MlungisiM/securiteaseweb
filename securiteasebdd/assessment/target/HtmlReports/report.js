$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/sports.feature");
formatter.feature({
  "name": "Search Functionality",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Some test - some test description",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "I navigate to the search functionality",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.actionsClass.i_navigate_to_the_search_functionality()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\n\tat StepDefinitions.actionsClass.i_navigate_to_the_search_functionality(actionsClass.java:36)\n\tat ✽.I navigate to the search functionality(file:///Users/mlungisimbele/Downloads/SeleniumCucumberBDD-master/CucumberJava/src/test/resources/Features/sports.feature:4)\n",
  "status": "failed"
});
formatter.step({
  "name": "I search for Sport in 2023",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.actionsClass.i_search_for_Sport_in(java.lang.Integer)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I want four or more articles, reports, and media to display",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.actionsClass.i_want_four_or_more_articles_reports_and_media_to_display()"
});
formatter.result({
  "status": "skipped"
});
