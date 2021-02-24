package Tema3Reto2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class pruebaDatosPHP {
	private String protocolo;
	private String urlEndPoint;
	private static Integer apiKey;
	private boolean estaRegistrada;
	
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		try {
			URL urlEndPoint = new URL("https://psp2021site.000webhostapp.com/registrarAplicacion.php");
			URLConnection conexion = urlEndPoint.openConnection();
			conexion.setDoOutput(true);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
			String linea;
			while ((linea = reader.readLine()) != null) {
				apiKey = Integer.parseInt(linea.replaceAll("\\<[^>]*>",""));
			}
			reader.close();
			
			realizarOperaciones(apiKey);
		} catch (MalformedURLException me) {
			System.err.println("MalformedURLException: " + me);
		} catch (IOException ioe) {
			System.err.println("IOException: " + ioe);
		}
	}
	
	private static void realizarOperaciones(int apiKey) {
		System.out.println("Introduzca que operación desea realizar (1-3): ");
		System.out.println("1 - sumar");
		System.out.println("2 - restar");
		System.out.println("3 - multiplicar");
		System.out.print("Escriba aquí: ");
		int opcion = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Introduzca dos números para realizar la operación deseada:");
		System.out.print("Primer número: ");
		int num1 = Integer.parseInt(teclado.nextLine());
		System.out.print("Segundo número: ");
		int num2 = Integer.parseInt(teclado.nextLine());
		
		switch (opcion) {
		case 1: 
			sumar(num1, num2, apiKey);
			break;
		case 2:
			restar(num1, num2);
			break;
		case 3:
			multiplicar(num1, num2);
			break;
		}
		
	}

	public static void sumar(int a, int b, int apiKey) {
		
	}
	
	
	public static void restar(int a, int b) {
		
	}
	
	
	public static void multiplicar(int a, int b) {
		
	}
}