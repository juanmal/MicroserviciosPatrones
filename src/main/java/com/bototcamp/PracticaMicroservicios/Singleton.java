package com.bototcamp.PracticaMicroservicios;

public class Singleton {
	private String nombre;
	private String email;
	private String direccion;
	private String telefono;
	
	private static Singleton instancia;
	
	private Singleton(String nombre, String email, String direccion, String telefono) {
		this.nombre = nombre;
		this.email = email;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	public static Singleton getSingletonInstance(String nombre, String email, String direccion, String telefono) {
		if (instancia == null) {
			instancia = new Singleton(nombre, email, direccion, telefono);
		} else {
			System.out.println("Ya existe una instancia de este objeto");
		}
		return instancia;		
	}

	@Override
	public String toString() {
		return "Singleton [nombre=" + nombre + ", email=" + email + ", direccion=" + direccion + ", telefono="
				+ telefono + "]";
	}

}
