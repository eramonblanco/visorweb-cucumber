package pe.visorweb.paginas.categoria;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pe.visorweb.menu.MenuPrincipal;

public class PaginaMantenimientoCategoria {
	
	private By btnNuevo = By.id("btnNuevo");
	
	private MenuPrincipal menuPrincipal;
	private WebDriver driver;
		

	public PaginaMantenimientoCategoria(WebDriver driver) {
		this.driver = driver;
		menuPrincipal = new MenuPrincipal(driver);
					
	}
	public void cargarPagina() {
		menuPrincipal.cargarPaginaMantenimientoCategoria();
	}
	public PaginaRegistrarCategoria cargarPaginaRegistrarCateogia() {
		driver.findElement(btnNuevo).click();
		return new PaginaRegistrarCategoria(driver);
	}
}
