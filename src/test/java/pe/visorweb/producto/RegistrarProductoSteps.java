package pe.visorweb.producto;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pe.visorweb.driver.VisorDriver;
import pe.visorweb.driver.VisorDriver.NavegadorWeb;
import pe.visorweb.paginas.login.PaginaLogin;
import pe.visorweb.paginas.producto.PaginaRegistrarProducto;

public class RegistrarProductoSteps {
	
	private WebDriver driver;
	private PaginaLogin paginaLogin;
	private PaginaRegistrarProducto paginaRegistrarProducto;
	
	@Before
	public void configuracionInicial() {
		driver = VisorDriver.getInstancia(NavegadorWeb.CHROME);
		paginaLogin = new PaginaLogin(driver);
		paginaRegistrarProducto = new PaginaRegistrarProducto(driver);
	}
	
	@After
	public void cerrarDriver() {
		driver.close();
	}

	@Given("cargo la página VisorWeb")
	public void cargarPaginaVisorWeb() {
		paginaLogin.cargarPagina();
	}
	
	@And("inicio sesión con el usuario {string} y la clave {string}")
	public void iniciarSesion(String usuario, String clave) {
		paginaLogin.iniciarSesion(usuario, clave);
	}
	
	@When("cargo la página Registrar Producto")
	public void cargarPaginaRegistrarProducto() {
		paginaRegistrarProducto.cargarPagina();
	}
	
	@And("escribo el producto {string} selecciono la categoria {string} escribo la precio {string} y hago clic en el botón Guardar")
	public void registrarProducto(String nombreProducto,String nombreCategoria,String precioProducto) {
		paginaRegistrarProducto.insertar(nombreProducto,nombreCategoria,precioProducto);
	}
	
	@Then("el aplicativo me muestra el mensaje {string}")
	public void obtenerRespuesta(String mensajeEsperado) {
		assertEquals(mensajeEsperado,paginaRegistrarProducto.getMensajeObtenido());
	}
	
}