package productorConsumidorForma1;

/*
 * Clase recorre 10 posiciones de una palabra y las envia 
 * una a una a la clase Producto.
 */
public class Productor extends Thread {

	private String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private Producto producto;
	
	public Productor(Producto p) {
		this.producto = p;
	}

	@Override
	public void run() {
		synchronized (producto) {
			char letra;
			
			for (int i = 0; i < 5; i++) {
				letra = alfabeto.charAt(i);
				producto.recogerLetra(letra);
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Producción " + (i+1));
			}
		}
	}
	
	
}
