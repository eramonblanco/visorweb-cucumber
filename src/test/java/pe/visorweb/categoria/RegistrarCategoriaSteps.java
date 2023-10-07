package pe.visorweb.categoria;
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
import pe.visorweb.paginas.categoria.PaginaRegistrarCategoria;
import pe.visorweb.paginas.login.PaginaLogin;

public class RegistrarCategoriaSteps {
	
	private WebDriver driver;
	private PaginaLogin paginaLogin;
	private PaginaRegistrarCategoria paginaRegistrarCategoria;
	
	@Before
	public void configuracionInicial() {
		driver = VisorDriver.getInstancia(NavegadorWeb.CHROME);
		paginaLogin = new PaginaLogin(driver);
		paginaRegistrarCategoria = new PaginaRegistrarCategoria(driver);
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
	
	@When("cargo la página Registrar Categoria")
	public void cargarPaginaRegistrarCategoria() {
		paginaRegistrarCategoria.cargarPagina();
	}
	
	@And("escribo la categoría {string} y hago clic en el botón Guardar")
	public void registrarCategoria(String nombreCategoria) {
		paginaRegistrarCategoria.insertar(nombreCategoria);
	}
	
	@Then("el aplicativo me muestra el mensaje {string}")
	public void obtenerRespuesta(String mensajeEsperado) {
		assertEquals(mensajeEsperado,paginaRegistrarCategoria.getMensajeObtenido());
	}
	
}