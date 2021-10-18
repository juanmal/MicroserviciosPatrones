package com.bootcamp.PracticaMicroservicios;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bootcamp.PracticaMicroservicios.PatronBuilder.Usuario;
import com.bootcamp.PracticaMicroservicios.PatronBuilder.UsuarioBuilder;
import com.bootcamp.PracticaMicroservicios.PatronPrototype.Camiseta;
import com.bootcamp.PracticaMicroservicios.PatronPrototype.CamisetaCorta;
import com.bootcamp.PracticaMicroservicios.PatronPrototype.CamisetaLarga;
import com.bootcamp.PracticaMicroservicios.PatronSingleton.UsuarioSingleton;


public class PracticaMicroserviciosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PracticaMicroserviciosApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("---------- Patron Builder ----------");
		Usuario u = new UsuarioBuilder().email("prueba@gmail.com").nombre("Nombbe").telefono("654312312").direccion("Calle falsa 123").build();		
		System.out.println(u);

		System.out.println("\n---------- Patron Singleton ----------");
		UsuarioSingleton s = UsuarioSingleton.getSingletonInstance("Nombre1", "Email1", "Direccion1", "Telefono1");
		System.out.println(s);
		UsuarioSingleton s2 = UsuarioSingleton.getSingletonInstance("Nombre1", "Email1", "Direccion1", "Telefono1");
		
		System.out.println(s.hashCode());
		System.out.println(s2.hashCode());

		UsuarioSingleton.deleteInstance();
		UsuarioSingleton s3 = UsuarioSingleton.getSingletonInstance("Nombre1", "Email1", "Direccion1", "Telefono1");
		UsuarioSingleton s4 = UsuarioSingleton.getSingletonInstance("Nombre1", "Email1", "Direccion1", "Telefono1");
		
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());

		System.out.println("\n---------- Patron Prototype ----------");
		Camiseta c1 = new CamisetaLarga("Azul", "S");
		Camiseta c2 = new CamisetaCorta("Azul", "S");
		System.out.println(c1);
		System.out.println(c2);
		Camiseta c3 = c1.clone("Roja", "M");
		Camiseta c4 = c2.clone("Roja", "M");
		System.out.println(c3);
		System.out.println(c4);
	}

}
