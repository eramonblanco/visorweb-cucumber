package pe.visorweb.driver;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;



public class VisorDriver{

public enum NavegadorWeb { CHROME, FIREFOX }

public static WebDriver getInstancia(NavegadorWeb navegador) {
	if (navegador == NavegadorWeb.FIREFOX) {
		return getFirefoxDriver();
	}
	return getChromeDriver();
}

private static WebDriver getChromeDriver() {
	WebDriverManager.chromedriver().setup();
	return aplicarConfiguracionesEnComun(new ChromeDriver());
}

private static WebDriver getFirefoxDriver() {
	WebDriverManager.firefoxdriver().setup();
	return aplicarConfiguracionesEnComun(new FirefoxDriver());
}

private static WebDriver aplicarConfiguracionesEnComun(WebDriver driver) {
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	return driver;
}
	

}
