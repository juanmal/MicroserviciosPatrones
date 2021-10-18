package com.bototcamp.PracticaMicroservicios;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class PracticaMicroserviciosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PracticaMicroserviciosApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {	
		Usuario u = new UsuarioBuilder().email("prueba@gmail.com").nombre("Nombbe").telefono("654312312").direccion("Calle falsa 123").build();
		
		System.out.println(u);
	}

}
