package pe.visorweb.paginas.producto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pe.visorweb.helper.VisorWebHelper;
import pe.visorweb.menu.MenuPrincipal;

public class PaginaEliminarProducto {
	private By txtFiltro = By.id("txtFiltro");
	private By btnFiltrar = By.id("btnFiltrar");
	private By tablaProductos_data = By.id("tablaProductos_data");
	private By btnEliminar = By.id("btnEliminar");	
	private By btnSi = By.id("btnSi");	
	private By btnNo = By.id("btnNo");	
	private By lblMensaje = By.id("messages");
	
	private String mensajeObtenido;
	
	private MenuPrincipal menuPrincipal;
	private WebDriver driver;
	
	public PaginaEliminarProducto(WebDriver driver) {
		this.driver=driver;
		menuPrincipal = new MenuPrincipal(driver);
	}
	public void cargarPagina() {
		menuPrincipal.cargarPaginaMantenimientoProducto().cargarPaginaEliminarProducto();
	}
	public void eliminar(String nombreProducto) {
		
		driver.findElement(txtFiltro).clear();
		VisorWebHelper.pausar();
		driver.findElement(txtFiltro).sendKeys(nombreProducto);
		driver.findElement(btnFiltrar).click();
		VisorWebHelper.pausar();
		driver.findElement(tablaProductos_data).click();
		VisorWebHelper.pausar();
		driver.findElement(btnEliminar).click();
		driver.findElement(btnSi).click();
	
		VisorWebHelper.pausar();
		
		this.mensajeObtenido = driver.findElement(lblMensaje).getText();
			
	}
	
		public String getMensajeObtenido() {
		return this.mensajeObtenido;
	}
}
