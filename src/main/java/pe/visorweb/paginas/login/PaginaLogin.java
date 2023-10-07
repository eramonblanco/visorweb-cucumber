package pe.visorweb.paginas.login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaLogin {

	private By txtUsuario = By.id("txtUsuario");
	private By txtClave = By.id("txtClave");
	private By btnIniciarSesion = By.id("btnIniciarSesion");
	private By lblMensajeBienvenida = By.xpath("//div[@class='title-main']");
	
	private WebDriver driver;
	public PaginaLogin(WebDriver driver) {
		this.driver = driver;
	}
	
	public void cargarPagina() {
		driver.get("http://localhost:8080/VisorWeb/index.xhtml");
	}
	
	public void iniciarSesion(String usuario, String clave) {
		driver.findElement(txtUsuario).clear();
		driver.findElement(txtUsuario).sendKeys(usuario);
		
		driver.findElement(txtClave).clear();
		driver.findElement(txtClave).sendKeys(clave);
		
		driver.findElement(btnIniciarSesion).click();
	}
	
	public String getMensajeBienvenida() {
		return driver.findElement(lblMensajeBienvenida).getText();
	}
	}