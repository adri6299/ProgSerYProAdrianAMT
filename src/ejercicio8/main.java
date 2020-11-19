package ejercicio8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class main {

	public static void main(String[] args) {
		ProcessBuilder nuevoProceso = new ProcessBuilder();
		Map<String, String> env = nuevoProceso.environment();

		List<String> comandos = new ArrayList<String>();

		comandos.add("cmd");
		comandos.add("/c");
		comandos.add("start");
		comandos.add("firefox");

		ProcessBuilder pb = new ProcessBuilder(comandos);
		System.out.println(pb.command());

		try {
			pb.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
