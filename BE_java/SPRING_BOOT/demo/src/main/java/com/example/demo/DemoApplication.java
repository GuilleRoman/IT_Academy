package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController  					// L'anotació @RestController indica a Spring que aquest codi descriu un punt final que s'hauria de fer disponible al web. 
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	// @GetMapping ("/ hello") indica a Spring que utilitzi el nostre mètode hello () 
	// per respondre a les sol·licituds que s'envien a l'adreça http: // localhost: 8080 / hello. 
	@GetMapping("/hello")
	// @RequestParam diu a Spring que esperi un valor de nom a la sol·licitud, però si no hi és, utilitzarà la paraula "Món" per defecte.
	public String hello (@RequestParam(value = "name", defaultValue = "world") String name) {
		return String.format("Hello %s!",name);
	}

}
