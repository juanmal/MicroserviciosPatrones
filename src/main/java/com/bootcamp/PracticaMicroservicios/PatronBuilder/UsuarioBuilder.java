package com.bootcamp.PracticaMicroservicios.PatronBuilder;

public class UsuarioBuilder {
	
	private Usuario u;
	
	public UsuarioBuilder() {
		u = new Usuario();
	}
	
	public Usuario build() {	
				
		return u;
	}
	
	public UsuarioBuilder nombre(String nombre) {
		u.setNombre(nombre);
		
		return this;
	}
	
	public UsuarioBuilder email(String email) {
		u.setEmail(email);
		
		return this;
	}
	
	public UsuarioBuilder telefono(String telefono) {
		u.setTelefono(telefono);
		
		return this;
	}
	
	public UsuarioBuilder direccion(String direccion) {
		u.setDireccion(direccion);
		
		return this;
	}
}
