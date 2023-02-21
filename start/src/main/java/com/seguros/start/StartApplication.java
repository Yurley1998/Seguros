package com.seguros.start;

import com.seguros.start.bd.MgConexion;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartApplication {

	public static void main(String[] args) {

		SpringApplication.run(StartApplication.class, args);
		MgConexion mg = MgConexion.getInstance();
		mg.open();
	}

}
