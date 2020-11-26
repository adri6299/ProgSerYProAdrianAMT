package ejercicio8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		ProcessBuilder pEnv = new ProcessBuilder();
		Map<String, String> vbles = pEnv.environment();
		System.out.println(vbles);
		
		List<String> lCommand = new ArrayList<String>();
		lCommand.add("powershell.exe");
		lCommand.add("ls -help");
		
		ProcessBuilder pb = new ProcessBuilder(lCommand);
		System.out.println(pb.command());
		
		try {
			pb.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());		
		}
		
		

	}

}
 