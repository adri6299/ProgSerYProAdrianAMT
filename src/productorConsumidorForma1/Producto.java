package productorConsumidorForma1;

/*
 * Clase que almacena caracteres en un array y los muestra uno por uno.
 */
public class Producto {

	private static final int MAX_LONG_COLA = 5;
	private char[] cola;
	private int posicionArray;
	private boolean estaVacia;
	
	public Producto() {
		cola = new char[MAX_LONG_COLA];
		posicionArray = 0;
		estaVacia = true;
	}
	
	// Forma 1 para sincronizar el método.
	public void recogerLetra(char letra) {
		while(!estaVacia) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			
		if(posicionArray >= MAX_LONG_COLA) {
			estaVacia = false;
			posicionArray--; // Hace las 5 posiciones + 1 que sobra.
			System.out.println("Por fin voy a dormir");
		} else {
			cola[posicionArray] = letra;
			posicionArray++;
			System.out.println("Guardo la letra " + letra);
		}

		System.out.println("Voy a despertar al consumidor que est� dormido");
		notify();	
		System.out.println("Ya le he despertado");
	}
	
	// Forma 2 para sincronizar el método.
	public char devolverLetra() {
		char letra = 0;
		
		while(estaVacia) {
			try {
				System.out.println("ZzZzZzZz (-_-)");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if(posicionArray <= 0) {
			estaVacia = false;
			posicionArray++;
		} else {
			letra = cola[posicionArray];
			posicionArray--;
			System.out.println("Devuelvo la letra " + letra);
		}

		notify();
		return letra;
	}
}
