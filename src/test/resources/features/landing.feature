Feature: landing page 
  Scenario: client makes call to GET /votaciones
    When the client calls /votaciones
    Then the client receives status code of 200
    And the client receives the string "Votaciones"