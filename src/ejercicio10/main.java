package ejercicio10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class main {

	public static void main(String[] args) {
		List<String> lCmdLinux = new ArrayList<String>();
		lCmdLinux.add("/bin/bash");
		lCmdLinux.add("-c");
		lCmdLinux.add("echo $MI_NOMBRE");

		List<String> lCmdWin = new ArrayList<String>();
		lCmdWin.add("CMD");
		lCmdWin.add("/C");
		lCmdWin.add("echo");
		lCmdWin.add("%MI NOMBRES");

		List<String> lCommand = null;

		if (System.getProperty("os.name").contains("Windows")) {
			lCommand = lCmdWin;
		} else {
			lCommand = lCmdLinux;
		}
		
		ProcessBuilder pb = new ProcessBuilder(lCommand);
		
		Map<String, String> vEnt = pb.environment();
		System.out.println("Entorno: " + vEnt);
		
		vEnt.put("MI_NOMBRE: ", "ADRIAN");
		
		pb.inheritIO();
		
		try {
			pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
