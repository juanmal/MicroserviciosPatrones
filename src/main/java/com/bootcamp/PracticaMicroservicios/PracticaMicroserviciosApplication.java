package com.bootcamp.PracticaMicroservicios;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bootcamp.PracticaMicroservicios.Coche.Coche;
import com.bootcamp.PracticaMicroservicios.Coche.Estado;
import com.bootcamp.PracticaMicroservicios.PatronBuilder.Usuario;
import com.bootcamp.PracticaMicroservicios.PatronBuilder.UsuarioBuilder;
import com.bootcamp.PracticaMicroservicios.PatronPrototype.Camiseta;
import com.bootcamp.PracticaMicroservicios.PatronPrototype.CamisetaCorta;
import com.bootcamp.PracticaMicroservicios.PatronPrototype.CamisetaLarga;
import com.bootcamp.PracticaMicroservicios.PatronSingleton.UsuarioSingleton;

@SpringBootApplication
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
		
		System.out.println("\n---------- Retry ----------");
		
		int intentos = 3;
		for (int i = 0; i < intentos; i++) {
			System.out.println("Intento " + (i+1));
			if (i < 2) { //Error de conexion
				System.out.println("Error de conexion");
				Thread.sleep(1000);
			}
			else {
				System.out.println("Conexion realizada");
			}
		}
		
		System.out.println("\n---------- CircuitBreaker ----------");
		Estado parado = new Estado("Parado");  // Estado: CLOSE. El coche se encuentra parado
		Estado arrancado = new Estado("Arrancado");  // Estado: OPEN. El coche se encuentra arrancado
		Estado ruedaPinchada = new Estado("Rueda pinchad");  // Estado: HALF_OPEN. El coche tiene una rueda pinchada, puede continuar.
		Estado falloArranque = new Estado("Fallo al arrancar"); // Estado especial 1: DISABLED. Fallo al arrancar.
		Estado ruedaReventada = new Estado("Rueda reventada"); // Estado especial 2: FORCED_OPEN. Rueda reventada, no puede continuar.
		
		// Desde el estado Parado (CLOSE), puede avanzar a: Arrancado (OPEN), Fallo en el arranque (DISABLED).
		parado.addTransicion("arrancado", arrancado);
		parado.addTransicion("falloArranque", falloArranque);
		
		// Desde el estado Arrancado (OPEN), puede avanzar a: Rueda pinchada (HALF_OPEN)
		arrancado.addTransicion("ruedaPinchada", ruedaPinchada);
		
		// Desde el estado Rueda pinchada (HALF_OPEN), puede avanzar a: Arrancado (OPEN), Rueda reventada (FORCED_OPEN)
		ruedaPinchada.addTransicion("arrancado", arrancado);
		ruedaPinchada.addTransicion("ruedaReventada", ruedaReventada);
		
		// El coche empieza en estado Parado (CLOSE)
		Coche cocheParado = new Coche("Chevrolet Lacetti", parado);
		
		// Cambio de estado Parado (CLOSE) a estado Arrancado (OPEN)
		Coche cocheArrancado = cocheParado.getEstado().transicion("arrancado", cocheParado);		
		
		// El coche desde el estado Arrancado (OPEN) pasa al estado Rueda pinchada (HALF_OPEN)
		Coche cochePinchado = cocheArrancado.getEstado().transicion("ruedaPinchada", cocheArrancado);
		
		// Del estado Rueda pinchada (HALF_OPEN) pasa a Rueda reventada (FORCED_OPEN)
		Coche cocheRuedaReventada = cochePinchado.getEstado().transicion("ruedaReventada", cochePinchado);
		
		
		
	}

}
