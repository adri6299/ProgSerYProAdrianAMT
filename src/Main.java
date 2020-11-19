import java.io.IOException;
import java.util.Scanner;

public class Main {
	private static String OS = System.getProperty("os.name").toLowerCase();
	private static final String NAVEGADOR = "firefox";
	
	
	private static Scanner teclado = new Scanner (System.in);
	
	public static void main(String[] args) {
        String cmd = null;
        
        if (isUnix()) {
            cmd = NAVEGADOR;

        } else if (isWindows()) {
            cmd = "cmd /c start " + NAVEGADOR;
        }
        
        try {
            if (cmd != null ) {
                Runtime.getRuntime().exec(cmd);

            }
        } catch (IOException ex) {
        	System.out.println("El navegador no se ha podido abrir");
        }catch (Error err) {
        	err.printStackTrace();
        }

	}

    public static boolean isUnix() {

        return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);

    }

    public static boolean isWindows() {

        return (OS.indexOf("win") >= 0);

    }
}
