package productorConsumidorForma1;

public class Principal {

	public static void main(String[] args) {
		
		Producto producto = new Producto();
		Productor productor = new Productor(producto);
		Consumidor consumidor = new Consumidor(producto);
		
		productor.start();
		consumidor.start();
		
		try {	
			// Para el hilo principal hasta que no terminen 
			//productor y consumidor, tras esto muestra lo de abajo.
			productor.join();
			consumidor.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Fin hilo principal");
	}

}
