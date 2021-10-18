package com.bototcamp.PracticaMicroservicios.PatronSingleton;

public class UsuarioSingleton {
	private String nombre;
	private String email;
	private String direccion;
	private String telefono;
	
	private static UsuarioSingleton instancia;
	
	private UsuarioSingleton(String nombre, String email, String direccion, String telefono) {
		this.nombre = nombre;
		this.email = email;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	public static UsuarioSingleton getSingletonInstance(String nombre, String email, String direccion, String telefono) {
		if (instancia == null) {
			instancia = new UsuarioSingleton(nombre, email, direccion, telefono);
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
