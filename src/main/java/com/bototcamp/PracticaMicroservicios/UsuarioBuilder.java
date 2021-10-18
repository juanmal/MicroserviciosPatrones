package com.bototcamp.PracticaMicroservicios;

public class UsuarioBuilder {
	
	private Usuario u;
	
	public UsuarioBuilder() {
		u = new Usuario();
	}
	
	public Usuario build() {	
		
		
		return u;
	}
	
	public UsuarioBuilder nombre(String nombre) {
		u.setEmail(nombre);
		
		return this;
	}
	
	public UsuarioBuilder email(String email) {
		u.setEmail(email);
		
		return this;
	}
	
	public UsuarioBuilder telefono(String telefono) {
		u.setEmail(telefono);
		
		return this;
	}
	
	public UsuarioBuilder direccion(String direccion) {
		u.setEmail(direccion);
		
		return this;
	}
}
