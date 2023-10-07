package pe.visorweb.menu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pe.visorweb.helper.VisorWebHelper;
import pe.visorweb.paginas.categoria.PaginaMantenimientoCategoria;
import pe.visorweb.paginas.producto.PaginaMantenimientoProducto;

public class MenuPrincipal {

	private By menuHamburgesa = By.xpath("//div[@class='btn-show active']");
	private By menuModuloAlmacen= By.xpath("//span[contains(text(), 'Mod. de Almacén')]");
	private By menuMntCategoria=By.linkText("Mnt. de Categoría");
	private By menuMntProducto=By.linkText("Mnt. de Productos");
	
	private WebDriver driver;
	
	public MenuPrincipal(WebDriver driver) {
		this.driver = driver;
		}
	public PaginaMantenimientoCategoria cargarPaginaMantenimientoCategoria() {
		VisorWebHelper.pausar();
		this.driver.findElement(menuHamburgesa).click();
		
		VisorWebHelper.pausar();
		this.driver.findElement(menuModuloAlmacen).click();
		
		VisorWebHelper.pausar();
		this.driver.findElement(menuMntCategoria).click();
		
		return new PaginaMantenimientoCategoria(driver);
		
	}
	
	public PaginaMantenimientoProducto cargarPaginaMantenimientoProducto() {
		VisorWebHelper.pausar();
		this.driver.findElement(menuHamburgesa).click();
		
		VisorWebHelper.pausar();
		this.driver.findElement(menuModuloAlmacen).click();
		
		VisorWebHelper.pausar();
		this.driver.findElement(menuMntProducto).click();
		
		return new PaginaMantenimientoProducto(driver);
		
	}
	
}
