package com.bootcamp.PracticaMicroservicios.PatronPrototype;

public class CamisetaLarga extends Camiseta {

	private String color;
	private String talla;
	private String manga;
	
	public CamisetaLarga(String color, String talla) {
		super(color, talla);
		this.color = color;
		this.talla = talla;
		this.manga = "Larga";
	}

	@Override
	public Camiseta clone(String color, String talla) {
		return new CamisetaLarga(color, talla);
	}

	@Override
	public String toString() {
		return "CamisetaLarga [color=" + color + ", talla=" + talla + ", manga=" + manga + "]";
	}
	
}
