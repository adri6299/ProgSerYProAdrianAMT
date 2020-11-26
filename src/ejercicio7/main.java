package ejercicio7;

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

		List<String> comandosWindows = new ArrayList<String>();

		comandosWindows.add("cmd");
		comandosWindows.add("/c");
		comandosWindows.add("start");
		comandosWindows.add("opera");
		comandosWindows.add("www.google.es");
		
		List<String> comandosLinux = new ArrayList<String>();
		
		comandosLinux.add("firefox www.google.es");

		try {
			ProcessBuilder pb = new ProcessBuilder(comandosWindows);
			pb.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
