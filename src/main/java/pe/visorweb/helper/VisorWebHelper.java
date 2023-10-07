package pe.visorweb.helper;

public class VisorWebHelper {
	public static void pausar() {
		try {
			Thread.sleep(2000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
