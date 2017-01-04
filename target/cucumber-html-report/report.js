$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Search.feature");
formatter.feature({
  "line": 1,
  "name": "Text Search",
  "description": "test duckduckgo text feature",
  "id": "text-search",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Text Search",
  "description": "",
  "id": "text-search;text-search",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I am in duckduckgo homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I search for \"Elon Musk\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I should see text results",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "I should see \"Elon Mush\" in page source",
  "keyword": "And "
});
formatter.match({
  "location": "SearchStepdef.i_am_in_duckduckgo_homepage()"
});
formatter.result({
  "duration": 1837200583,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Elon Musk",
      "offset": 14
    }
  ],
  "location": "SearchStepdef.i_search_for(String)"
});
formatter.result({
  "duration": 5781209,
  "status": "passed"
});
formatter.match({
  "location": "SearchStepdef.i_should_see_text_results()"
});
formatter.result({
  "duration": 24561,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Elon Mush",
      "offset": 14
    }
  ],
  "location": "SearchStepdef.i_should_see_in_page_source(String)"
});
formatter.result({
  "duration": 78347,
  "status": "passed"
});
formatter.uri("imgSearch.feature");
formatter.feature({
  "line": 1,
  "name": "Image Search",
  "description": "test duckduckgo image feature",
  "id": "image-search",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Search for breaking bad images",
  "description": "",
  "id": "image-search;search-for-breaking-bad-images",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I am in duckduckgo homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I search for \"breaking bad\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Click on Image button",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I should see image results",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I should see \"breaking bad\" in page source",
  "keyword": "And "
});
formatter.match({
  "location": "SearchStepdef.i_am_in_duckduckgo_homepage()"
});
formatter.result({
  "duration": 137418,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "breaking bad",
      "offset": 14
    }
  ],
  "location": "SearchStepdef.i_search_for(String)"
});
formatter.result({
  "duration": 86120,
  "status": "passed"
});
formatter.match({
  "location": "SearchStepdef.click_on_Image_button()"
});
formatter.result({
  "duration": 3186427,
  "status": "passed"
});
formatter.match({
  "location": "SearchStepdef.i_should_see_image_results()"
});
formatter.result({
  "duration": 32023,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "breaking bad",
      "offset": 14
    }
  ],
  "location": "SearchStepdef.i_should_see_in_page_source(String)"
});
formatter.result({
  "duration": 167265,
  "status": "passed"
});
});