Feature: Gestión Producto

  Scenario Outline: Eliminar Producto
    Given cargo la página VisorWeb
    And inicio sesión con el usuario <usuario> y la clave <clave>
    And cargo la pagina producto
    When selecciono producto <nombreProducto> y hago clic en el botón Si
    Then el aplicativo me muestra el mensaje <mensajeEsperado>

    Examples: 
      | usuario | clave   | nombreProducto | mensajeEsperado                             |
      | "admin" | "clave" | "GALLETA"      | "Se eliminó de manera correcta el Producto" |
      | "admin" | "clave" | ""             | "Se eliminó de manera correcta el Producto" |
      | "admin" | "clave" | "FIDEO"        | "No ha seleccionado un Producto"            |