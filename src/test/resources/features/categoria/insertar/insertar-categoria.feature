Feature: Gestión Categoría

  Scenario Outline: Registrar Categoría
    Given cargo la página VisorWeb
    And inicio sesión con el usuario <usuario> y la clave <clave>
    When cargo la página Registrar Categoria
    And escribo la categoría <nombreCategoria> y hago clic en el botón Guardar
    Then el aplicativo me muestra el mensaje <mensajeEsperado>

    Examples: 
      | usuario | clave   | nombreCategoria      | mensajeEsperado                                       |
			| "admin" | "clave" | "AUDIFONOS CUCUMBER" | "Se guardó de manera correcta la Categoría"          |
      | "admin" | "clave" | ""                   | "Nombre: Error de validación: se necesita un valor." |
      | "admin" | "clave" | "LAPTOP CUCUMBER"    | "Se guardó de manera correcta la Categoría"          |