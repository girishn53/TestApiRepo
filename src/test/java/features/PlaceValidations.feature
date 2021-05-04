@addplace
Feature: Add place API

  Scenario Outline: Validate add place API by adding a place
    Given add place payload using "<name>" "<language>" and "<address>"
    When user calls "AddPlaceAPI" using "post" method
    Then the API call get success with status code 200 in response
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify the place_id created maps to "<name>" using "getPlaceAPI"

    Examples: 
      | name           | language | address  |
      | newtestuser544 | French   | xyz03456 |

  @deleteplace
  Scenario: Validate delete place API
    Given Deleteplace payload
    When user calls "deletePlaceAPI" using "post" method
    Then the API call get success with status code 200 in response
    And "status" in response body is "OK"
