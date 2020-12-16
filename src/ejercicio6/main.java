package ejercicio6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ejercicio3.Cadenas;

public class main {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		
		//String comandoLinux = "ls -helpp111p";
		String comandoWindows = "CMD /C DIROCC";
		
		String comando = comandoWindows;
		Process p = null;
		try {
			p = rt.exec(comando);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int status;
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			status = p.waitFor();
			System.out.println("El comando " + comando + " ha resultado " + status);	
			
			InputStream errStream = p.getErrorStream();
			br = new BufferedReader(new InputStreamReader(errStream));
			
			bw = new BufferedWriter(
					new FileWriter(
							Cadenas.getCadenaFichero("log_ejercicio6.txt")));
			
			String linea;
			while ((linea = br.readLine())!=null) {
				bw.write(linea);
				bw.newLine();
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
