package pe.visorweb.paginas.producto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pe.visorweb.helper.VisorWebHelper;
import pe.visorweb.menu.MenuPrincipal;

public class PaginaRegistrarProducto {
		
	private By txtNombre = By.id("txtNombre");
	private By cboCategoria = By.id("cboCategoria");
	private By txtPrecio = By.id("txtPrecio");
	private By btnGuardar = By.id("btnGuardar");
	private By lblMensaje = By.id("messages");
	
	private String mensajeObtenido;
	
	private MenuPrincipal menuPrincipal;
	private WebDriver driver;
	
	public PaginaRegistrarProducto(WebDriver driver) {
		this.driver=driver;
		menuPrincipal = new MenuPrincipal(driver);
	}
	public void cargarPagina() {
		menuPrincipal.cargarPaginaMantenimientoProducto().cargarPaginaRegistrarProducto();
	}
	public void insertar(String nombreProducto,String nombreCategoria,String precioProducto) {
		driver.findElement(txtNombre).clear();
		driver.findElement(txtPrecio).clear();
		driver.findElement(txtNombre).sendKeys(nombreProducto);
		driver.findElement(cboCategoria).sendKeys(nombreCategoria);
		driver.findElement(txtPrecio).sendKeys(precioProducto);
		
		driver.findElement(btnGuardar).click();
		
		VisorWebHelper.pausar();
		
		this.mensajeObtenido = driver.findElement(lblMensaje).getText();
			
	}
	
	public String getMensajeObtenido() {
		return this.mensajeObtenido;
	}
}
