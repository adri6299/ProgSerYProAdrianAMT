package ejercicio9;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ejercicio3.Cadenas;

public class Main {

	public static void main(String[] args) {
		List<String> lCommand = new ArrayList<String>();
		lCommand.add("CMD");
		lCommand.add("/C");
		lCommand.add("DIRICCc");
		
		ProcessBuilder pb = new ProcessBuilder(lCommand); 		
		File fOut = new File(Cadenas.getCadenaFichero("salida_ejercicio9.txt"));
		File fErr = new File(Cadenas.getCadenaFichero("log_ejercicio9.txt"));		
		
		pb.redirectOutput(fOut);
		pb.redirectError(fErr);
		try {
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
