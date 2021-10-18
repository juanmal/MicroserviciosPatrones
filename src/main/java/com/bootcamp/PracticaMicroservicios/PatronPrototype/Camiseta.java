package com.bootcamp.PracticaMicroservicios.PatronPrototype;

public abstract class Camiseta {
	private String color;
	private String talla;
	
	public Camiseta(String color, String talla) {
		this.color = color;
		this.talla = talla;
	}
	
	public abstract Camiseta clone(String color, String talla);
}
