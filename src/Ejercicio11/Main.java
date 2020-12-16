package Ejercicio11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> lCommand = new ArrayList<String>();
		lCommand.add("java");
		lCommand.add("ejercicio10/main.java");
		
		ProcessBuilder pb = new ProcessBuilder(lCommand);
		
		String classpath = "C:/Users/adri-/git/ProgSerYProAdrianAMT/bin";
				
		pb.environment().put("CLASSPATH", classpath);
		pb.inheritIO();
		
		try {
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
