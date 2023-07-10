package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Alumno;
import com.example.demo.modelo.Automovil;
import com.example.demo.modelo.Escuela;
import com.example.demo.modelo.dto.AutomovilDTO;
import com.example.demo.service.IAlumnoService;
import com.example.demo.service.IAutomovilService;
import com.example.demo.service.IEscuelaService;

@SpringBootApplication
public class PwU2P4TDcApplication implements CommandLineRunner {

	@Autowired
	private IAlumnoService alumnoService;

	@Autowired
	private IEscuelaService escuelaService;

	public static void main(String[] args) {
		SpringApplication.run(PwU2P4TDcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<Alumno> alumnos = new ArrayList<>();
		Escuela escuela = new Escuela();
		escuela.setNombre("Albert Einstain");
		escuela.setDireccion("Tumbaco, Av aurelio Davila Cajas");
		escuela.setParroquia("Tumbaco");
		escuela.setProvincia("Pichincha");
		escuela.setTipo("Privada");
		escuela.setValorMatricula(new BigDecimal(350));
		

		Alumno a = new Alumno();
		a.setNombre("Renato");
		a.setEdad(7);
		a.setFechaNacimiento(LocalDate.of(2015, 12, 2));
		a.setGenero("M");
		a.setEscuela(escuela);
		alumnos.add(a);
		//this.alumnoService.agregar(a);

		Alumno b = new Alumno();
		b.setNombre("Alfredo");
		b.setEdad(8);
		b.setFechaNacimiento(LocalDate.of(2014, 2, 2));
		b.setGenero("M");
		b.setEscuela(escuela);
		alumnos.add(b);
		

		Alumno c = new Alumno();
		c.setNombre("Margarita");
		c.setEdad(7);
		c.setFechaNacimiento(LocalDate.of(2015, 5, 2));
		c.setGenero("F");
		c.setEscuela(escuela);
		alumnos.add(c);
		escuela.setAlumnos(alumnos);
		//this.escuelaService.agregar(escuela);
		
        Escuela escuelaReporte= this.escuelaService.encontrarLigero(7);
        System.out.println(escuelaReporte);
       // escuelaReporte.getAlumnos();
//		for (Alumno alumno : escuelaReporte.getAlumnos()) {
//			System.out.println( alumno );
//		}
	}

}
