Feature: Checkout

  Scenario Outline: Checkout paso a paso
    Given tengo un item agregado "Sauce Labs Onesie"
    And hago click en cart button
    And hago click en checkout button
    And se redirige a la pagina checkout-step-one
    When ingreso "<firstName>" como first name
    And ingreso "<lastName>" como last name
    And ingreso "<zipCode>" como Postal Code
    And hago click en boton continue
    Given se redirige a la pagina checkout-step-two
    When hago click en boton Finish
    Then se redirige a la pagina checkout-complete
    Examples:
      | firstName  | lastName   | zipCode |
      | Fatima     | Vasquez    | 14000   |

