Feature: Administrar carrito

  @cart @agregarItem
  Scenario Outline: Agregar un item al carrito
    Given estoy logueada con usuario "standard_user" y clave "secret_sauce"
    And se redirige a la pagina Inventory Page
    When hago click en el boton Add to Cart de "<item>"
    Then aparece el boton "remove" en "<item>"
    Examples:
      | item                              |
      | Sauce Labs Backpack               |
      | Sauce Labs Onesie                 |