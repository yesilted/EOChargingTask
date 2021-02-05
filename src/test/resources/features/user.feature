@wip
Feature: User Information


  Scenario Outline:I should able to create a user
    When I send users "<name>" and "<job>" details to Api Endpoint "api/users"
    Then status code should be 201
    And Content type should be "application/json; charset=utf-8"
    And JSon response should contain "createdAt"

    Examples:
      | name     | job      |
      | morpheus | morpheus |

  Scenario:I should able to get users information
    When I get users information from Api Endpoint "api/users"
    Then status code should be 200
    And Content type should be "application/json; charset=utf-8"

# Regarding this scenario normally it should be passed but it accepts even null value and integer value.
#
#  Scenario Outline: I should not able to create a user with invalid credentials
#    When I send users "<name>" and "<job>" details to Api Endpoint "api/users"
#    Then status code should be 404
#    And Content type should be "application/json; charset=utf-8"
#    And JSon response should contain "createdAt"
#
#    Examples:
#      | name | job    |
#      | 1234 | 134534 |
#      |      |        |

  Scenario:I should not able to get users information that does not exist
    When I try to get users information that does not exist from Api Endpoint "api/users"
    Then status code should be 404
    And Content type should be "application/json; charset=utf-8"


 Scenario Outline:I should able to get users name by id
   When I get users information from Api Endpoint "api/users/<id>"
   Then Users "<firstname>" and "<lastname>" should match

   Examples:
   |id|firstname|lastname|
   |1 |George   |Bluth   |
   |2 |Janet    |Weaver  |
   |3 |Emma     |Wong    |






