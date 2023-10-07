package pe.visorweb.paginas.categoria;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pe.visorweb.helper.VisorWebHelper;
import pe.visorweb.menu.MenuPrincipal;

public class PaginaRegistrarCategoria {
		
	private By txtNombre = By.id("txtNombre");
	private By btnGuardar = By.id("btnGuardar");
	private By lblMensaje = By.id("messages");
	
	private String mensajeObtenido;
	
	private MenuPrincipal menuPrincipal;
	private WebDriver driver;
	
	public PaginaRegistrarCategoria(WebDriver driver) {
		this.driver=driver;
		menuPrincipal = new MenuPrincipal(driver);
	}
	public void cargarPagina() {
		menuPrincipal.cargarPaginaMantenimientoCategoria().cargarPaginaRegistrarCateogia();
	}
	public void insertar(String nombreCategoria) {
		driver.findElement(txtNombre).clear();
		driver.findElement(txtNombre).sendKeys(nombreCategoria);
		
		driver.findElement(btnGuardar).click();
		
		VisorWebHelper.pausar();
		
		this.mensajeObtenido = driver.findElement(lblMensaje).getText();
			
	}
	
	public String getMensajeObtenido() {
		return this.mensajeObtenido;
	}
}
