package ejercicio4;

public class main {
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		String comandoLinux = "ls --help";
		String comandoWindows = "CMD /C DIRRRR";
		String comando = comandoWindows;	
		Process p = null;
		
		if (isWindows()) {
			comando = comandoWindows;
		} else if (isUnix()) {
			comando = comandoLinux;
		}
		
		try {
			p = rt.exec(comando);
		} catch (Exception e) {
			e.printStackTrace();
		}

		int status;
		try {
			status = p.waitFor();
			System.out.println("El comando " + comando + " ha resultado " + status);
		} catch (InterruptedException e) {
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
