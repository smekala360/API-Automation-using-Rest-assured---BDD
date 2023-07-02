Feature: API Automation Test

  Scenario: 1. Verify Status code and response time
    Given Make a GET request
    When GET request to the API endpoint
    Then the HTTP status code of the response should be 200
    And the response time should be below 1000 milliseconds


  Scenario: 2. Verify the “id” is never null And “segment_type” field for every track is always “music”
    Given Make a GET request
    When GET request to the API endpoint
    Then Verify if the “id” field is never null or empty
    And  Verify that the “segment_type” field for every track is always “music”


  Scenario: 3. Verify that the “primary” field in “title_list” is never null or empty(“”) for any track
    Given Make a GET request
    When GET request to the API endpoint
    Then Verify that the “primary” field in “title_list” is never null or empty


  Scenario: 4. Verify that only one track in the list has “now_playing” field in “offset” as true
    Given Make a GET request
    When GET request to the API endpoint
    Then Verify that only one track in the list


  Scenario: 5. In the response headers, verify the “Date” value
    Given Make a GET request
    When GET request to the API endpoint
    Then In the response headers, verify the “Date” value


