package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Alumno;
import com.example.demo.modelo.Escuela;

import com.example.demo.service.IAlumnoService;
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
		escuela.setNombre("Spellman");
		escuela.setDireccion("Cumbaya, Josefa Tinajero");
		escuela.setParroquia("Cumbaya");
		escuela.setProvincia("Pichincha");
		escuela.setTipo("Privada");
		escuela.setValorMatricula(new BigDecimal(650));

		Alumno a = new Alumno();
		a.setNombre("Jose");
		a.setEdad(12);
		a.setFechaNacimiento(LocalDate.of(2011, 12, 2));
		a.setGenero("M");
		a.setEscuela(escuela);
		alumnos.add(a);
		// this.alumnoService.agregar(a);

		Alumno b = new Alumno();
		b.setNombre("Roberto");
		b.setEdad(13);
		b.setFechaNacimiento(LocalDate.of(2010, 2, 2));
		b.setGenero("M");
		b.setEscuela(escuela);
		alumnos.add(b);

		Alumno c = new Alumno();
		c.setNombre("Andrea");
		c.setEdad(12);
		c.setFechaNacimiento(LocalDate.of(2012, 5, 2));
		c.setGenero("F");
		c.setEscuela(escuela);
		alumnos.add(c);
		escuela.setAlumnos(alumnos);
		// this.escuelaService.agregar(escuela);
		System.out.println("1.-");
		System.out.println("INNER Join reporte de escuelas donde Tienen estudiante con genero Femenino");
		List<Escuela> reporte = this.escuelaService.reportePorGenero("F");
		for (Escuela escuela2 : reporte) {
			System.out.println(escuela2);
		}
		System.out.println("2.-");
		System.out.println("INNER Join donde en la escuela la edad es mayor a 10");
		List<Escuela> reporte1 = this.escuelaService.reporteEdadMayor(10);
		for (Escuela escuela2 : reporte1) {
			System.out.println(escuela2);
		}
		System.out.println("3.-");
		System.out.println(
				"RIGHT Join que me filtre la escuela hay un estudiante con un genero y fecha de nacimiento determinado");
		List<Escuela> reporte2 = this.escuelaService.reporteFechayGenero(LocalDate.of(2010, 2, 2), "M");
		for (Escuela escuela2 : reporte2) {
			System.out.println(escuela2);
		}
		System.out.println("4.-");
		System.out.println(
				"RIGHT Join que me filtre si un estudiate con nombre X en que escuela está");
		List<Escuela> reporte3 = this.escuelaService.reporteNombre("Alfredo");
		for (Escuela escuela2 : reporte3) {
			System.out.println(escuela2);
		}
		System.out.println("5.-");
		System.out.println(
				"LEFT Join que me filtre estudiantes por parroquia");
		List<Alumno> reporte4 = this.alumnoService.reportePorParroquia("Tumbaco");
		for (Alumno escuela2 : reporte4) {
			System.out.println(escuela2);
		}
		System.out.println("6.-");
		System.out.println(
				"LEFT Join que me filtre estudiantes por provincia");
		List<Alumno> reporte5 = this.alumnoService.reportePorProvincia("Pichincha");
		for (Alumno escuela2 : reporte5) {
			System.out.println(escuela2);
		}
		System.out.println("7..-");
		System.out.println(
				"FULL Join que me filtre todo");
		List<Alumno> reporte6 = this.alumnoService.reporte();
		for (Alumno escuela2 : reporte6) {
			System.out.println(escuela2);
		}
		System.out.println("8.-");
		System.out.println(
				"FULL Join que me filtre todo por tipo");
		List<Alumno> reporte7 = this.alumnoService.reportePorTipo("Privada");
		for (Alumno escuela2 : reporte7) {
			System.out.println(escuela2);
		}
		System.out.println("9.-");
		System.out.println(
				"WHERE Join ");
		List<Alumno> reporte8 = this.alumnoService.reporteValorMatricula();
		for (Alumno escuela2 : reporte8) {
			System.out.println(escuela2);
		}
		System.out.println("10.-");
		System.out.println(
				"WHERE Join ");
		List<Escuela> reporte9 = this.escuelaService.encontrar();
		for (Escuela escuela2 : reporte9) {
			System.out.println(escuela2);
		}
		


	}

}
