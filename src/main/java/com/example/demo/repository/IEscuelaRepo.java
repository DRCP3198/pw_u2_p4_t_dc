package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.modelo.Alumno;
import com.example.demo.modelo.Escuela;

public interface IEscuelaRepo {

	public void insertar(Escuela escuela);
	public void actualizar(Escuela escuela);
	public Escuela buscar(Integer id);
	public Escuela buscarLigero(Integer id);
	public void borrar(Integer id);
	//JOIN
	public List<Escuela> seleccionarGenero(String genero);
	public List<Escuela> seleccionarEdadMayor(Integer edad);
	//RIGHT JOIN
	public List<Escuela> seleccionarFechayGenero(LocalDate fecha,String genero);
	public List<Escuela> seleccionarNombre(String nombre);
	//WHERE
	public List<Escuela> seleccionar();

}
