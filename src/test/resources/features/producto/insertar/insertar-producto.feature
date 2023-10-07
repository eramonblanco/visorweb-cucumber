Feature: Gestión Producto

  Scenario Outline: Registrar Producto
    Given cargo la página VisorWeb
    And inicio sesión con el usuario <usuario> y la clave <clave>
    When cargo la página Registrar Producto
    And escribo el producto <nombreProducto> selecciono la categoria <nombreCategoria> escribo la precio <precioProducto> y hago clic en el botón Guardar
    Then el aplicativo me muestra el mensaje <mensajeEsperado>

    Examples: 
      | usuario | clave   | nombreProducto        | nombreCategoria | precioProducto | mensajeEsperado                                      |
      | "admin" | "clave" | "GALLETA CHIPS"       | "GALLETAS"      | "1.88"         | "Se guardó de manera correcta el Producto"           |
      | "admin" | "clave" | "GALLETA CHOCOLATE"   | "GALLETAS"      | "1.90"         | "Se guardó de manera correcta el Producto"           |
      | "admin" | "clave" | "GALLETAS RELLENITAS" | "GALLETAS"      | "1.90"         | "Se guardó de manera correcta el Producto"           |
      | "admin" | "clave" | ""                    | "GALLETAS"      | "1.88"         | "Nombre: Error de validación: se necesita un valor." |
      | "admin" | "clave" | "GALLETA CHOCOLATE"   | "GALLETAS"      | "1.90"         | "Se guardó de manera correcta el Producto"           |
      | "admin" | "clave" | "GALLETA CHIPS"       | "GALLETAS"      | ""             | "Precio: Error de validación: se necesita un valor." |
