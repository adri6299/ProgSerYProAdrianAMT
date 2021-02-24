package productorConsumidorForma1;

/*
 * Hilo que recibe 10 veces una letra para mostrarla.
 */
public class Consumidor extends Thread {

	private Producto producto;
	
	public Consumidor(Producto p) {
		this.producto = p;
	}

	@Override
	public void run() {
		synchronized (producto) {
			System.out.println("Consumidor dentro.");
			char letra;
			
			for (int i = 0; i < 5; i++) {
				letra = producto.devolverLetra();
				try {
					sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println((i+1) + ") Consumo la letra " + letra);
			}
		}
	}
	
	
}
