package tema3Reto1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class pruebaDatosPHP {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://psp2021site.000webhostapp.com/suma_parametros.php");
			URLConnection conexion = url.openConnection();
			conexion.setDoOutput(true);
			
			String cadena = "PARAM_A=5&PARAM_B=6";
			
			PrintWriter output = new PrintWriter(conexion.getOutputStream());
			output.write(cadena);
			output.close(); 
			BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			String linea;
			while ((linea = reader.readLine()) != null) {
				//eliminamos la etiqueta HTML con replaceALL
				System.out.println(linea.replaceAll("\\<[^>]*>",""));

			}
			reader.close();
		} catch (MalformedURLException me) {
			System.err.println("MalformedURLException: " + me);
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe);
		}
	}
}