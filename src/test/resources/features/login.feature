Feature: Login

  @login
    Scenario Outline: Inicio de sesión exitoso
    Given ingreso a Login Page
    When ingreso "<username>" como username
    And ingreso "<password>" como password
    And hago click en login button
    Then obtengo "<response>"
    Examples:
      | username                | password     | response                                                                  |
      | standard_user           | secret_sauce | redirected to Inventory Page                                              |