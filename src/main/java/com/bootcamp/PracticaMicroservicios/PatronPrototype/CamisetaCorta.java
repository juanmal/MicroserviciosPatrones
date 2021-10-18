package com.bootcamp.PracticaMicroservicios.PatronPrototype;

public class CamisetaCorta extends Camiseta {
	private String color;
	private String talla;
	private String manga;
	
	public CamisetaCorta(String color, String talla) {
		super(color, talla);
		this.color = color;
		this.talla = talla;
		this.manga = "Corta";
	}

	@Override
	public Camiseta clone(String color, String talla) {
		return new CamisetaCorta(color, talla);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public String getManga() {
		return manga;
	}

	public void setManga(String manga) {
		this.manga = manga;
	}

	@Override
	public String toString() {
		return "CamisetaCorta [color=" + color + ", talla=" + talla + ", manga=" + manga + "]";
	}
	
}
