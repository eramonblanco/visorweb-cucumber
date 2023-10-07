package pe.visorweb.paginas.producto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pe.visorweb.helper.VisorWebHelper;
import pe.visorweb.menu.MenuPrincipal;

public class PaginaMantenimientoProducto {
	
	private By btnNuevo = By.id("btnNuevo");
	private By txtFiltro = By.id("txtFiltro");
	private By btnFiltrar = By.id("btnFiltrar");
	private By tablaProductos_data = By.id("tablaProductos_data");
	private By btnEliminar = By.id("btnEliminar");	
	
	private MenuPrincipal menuPrincipal;
	private WebDriver driver;
		

	public PaginaMantenimientoProducto(WebDriver driver) {
		this.driver = driver;
		menuPrincipal = new MenuPrincipal(driver);
					
	}
	public void cargarPagina() {
		menuPrincipal.cargarPaginaMantenimientoProducto();
	}
	
	public PaginaRegistrarProducto cargarPaginaRegistrarProducto() {
		driver.findElement(btnNuevo).click();
		return new PaginaRegistrarProducto(driver);
	}
	
	public PaginaEliminarProducto cargarPaginaEliminarProducto() {
		driver.findElement(txtFiltro).clear();
		VisorWebHelper.pausar();
	
		return new PaginaEliminarProducto(driver);
	}
}
