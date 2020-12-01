package ejercicio3;

public class Cadenas {
	private final static String RUTA_FICHEROS = "pruebas_ficheros";
	private final static String RUTA_IMAGENES = "pruebas_ficheros";
	
	public static String getCadenaFichero(String nombreFichero) {
		String ruta = RUTA_FICHEROS + "/" + nombreFichero;
		return ruta;
	}
}
