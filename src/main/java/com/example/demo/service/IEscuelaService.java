package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.modelo.Alumno;
import com.example.demo.modelo.Escuela;

public interface IEscuelaService {

	public void agregar(Escuela escuela);

	public void modificar(Escuela escuela);

	public Escuela encontrarLazy(Integer id);

	public Escuela encontrarLigero(Integer id);

	public void eliminar(Integer id);

	// JOIN
	public List<Escuela> reportePorGenero(String genero);
	public List<Escuela> reporteEdadMayor(Integer edad);

	// RIGHT JOIN
	public List<Escuela> reporteFechayGenero(LocalDate fecha,String genero);
	public List<Escuela> reporteNombre(String nombre);
	
	// WHERE
	public List<Escuela> encontrar();

}
