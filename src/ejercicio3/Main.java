package ejercicio3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
	
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		String comandoLinux = "ls -help";
		String comandoWindows = "CMD /C DIR";
		String comando = comandoWindows;
		
		if (isWindows()) {
			comando = comandoWindows;
		} else if (isUnix()) {
			comando = comandoLinux;
		}
		
		Process p = null;
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			p = rt.exec(comando);		
		
			InputStream is = p.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			
			bw = new BufferedWriter(
					new FileWriter(Cadenas.getCadenaFichero("salida_comando_" + comando.replace('/',  '_'))));
			
			String linea;
			while ((linea = br.readLine())!=null) {
				bw.write(linea);
				bw.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
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