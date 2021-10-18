package com.bootcamp.PracticaMicroservicios.PatronRetry;

public class Retry {
	private int maxIntentos;
	
	public Retry(int maxIntentos) {
		this.maxIntentos = maxIntentos;
	}
	
	public void conexion() throws InterruptedException {
		for (int i = 0; i < this.maxIntentos; i++) {
			System.out.println("Intento " + (i+1));
			if (i < this.maxIntentos - 1) { //Error de conexion
				System.out.println("Error de conexion");
				Thread.sleep(1000);
			}
			else {
				System.out.println("Conexion realizada");
			}
		}
	}
}
