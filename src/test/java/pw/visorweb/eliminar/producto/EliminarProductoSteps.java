package pw.visorweb.eliminar.producto;
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
import pe.visorweb.paginas.producto.PaginaEliminarProducto;

public class EliminarProductoSteps {
	
	private WebDriver driver;
	private PaginaLogin paginaLogin;
	private PaginaEliminarProducto paginaEliminarProducto;
	
	
	@Before
	public void configuracionInicial() {
		driver = VisorDriver.getInstancia(NavegadorWeb.CHROME);
		paginaLogin = new PaginaLogin(driver);
		paginaEliminarProducto= new PaginaEliminarProducto(driver);
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
	
	@And("cargo la pagina producto")
	public void paginaEliminarProducto() {
		paginaEliminarProducto.cargarPagina();
	}
	
	@When("selecciono producto {string} y hago clic en el botón Si")
	public void eliminarProducto(String nombreProducto) {
		paginaEliminarProducto.eliminar(nombreProducto);
	}
	
	@Then("el aplicativo me muestra el mensaje {string}")
	public void obtenerRespuesta(String mensajeEsperado) {
		assertEquals(mensajeEsperado,paginaEliminarProducto.getMensajeObtenido());
	}
	
}