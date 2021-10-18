package com.bootcamp.PracticaMicroservicios.PatronCircuitBreaker;

import java.util.HashMap;


public class Estado {
	private String descripcion;
		
	public HashMap<String, Estado> transiciones;
	
	public Estado(String descripcion) {
		this.descripcion = descripcion;
		this.transiciones = new HashMap<>();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setEstado(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void addTransicion(String descripcion, Estado estado) {
		transiciones.put(descripcion, estado);
	}
	
	public Coche transicion(String descripcion, Coche c) {
		System.out.println("Coche: " + c.getMarca() + "    Estado: " + c.getEstado().getDescripcion() + 
				"    Cambio a estado: " + transiciones.get(descripcion).getDescripcion());
		
		return c.clone(c.getMarca(), transiciones.get(descripcion));
	}
	
}
