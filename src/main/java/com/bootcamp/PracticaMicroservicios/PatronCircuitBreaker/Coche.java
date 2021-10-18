package com.bootcamp.PracticaMicroservicios.PatronCircuitBreaker;

public class Coche {
	private String marca;
	private Estado estado;
	
	public Coche(String marca, Estado estado) {
		this.marca = marca;
		this.estado = estado;
	}

	public Coche clone(String marca, Estado estado) {
		return new Coche(this.marca, estado);
	}

	public String getMarca() {
		return this.marca;
	}
	
	public Estado getEstado() {
		return this.estado;
	}

	@Override
	public String toString() {
		return "Coche: " + this.marca + "  Estado: " + this.estado.getDescripcion();
	}
	
}
