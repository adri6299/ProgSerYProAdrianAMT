package ejercicio5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class main {
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		String comandoLinux = "lsss -help";
		String comandoWindows = "CMD /C DIRRRR";
		String comando = comandoWindows;
		int status;
		String linea;
		
		if (isWindows()) {
			comando = comandoWindows;
		} else if (isUnix()) {
			comando = comandoLinux;
		}
		
		Process p = null;
		try {
			p = rt.exec(comando);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (InputStream errStream = p.getErrorStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(errStream));){
			status = p.waitFor();
			System.out.println("El comando " + comando + " ha resultado " + status);	
			System.out.println("La salida ha sido: ");
			
			
			
			linea = "";
			while ((linea = br.readLine()) !=null){
				System.out.println(linea);
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isWindows() {
        return OS.contains("win");
    }
	
	public static boolean isUnix() {
        return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));
    }

}
