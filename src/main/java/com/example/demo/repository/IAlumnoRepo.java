package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.modelo.Alumno;
import com.example.demo.modelo.Escuela;

public interface IAlumnoRepo {

	public void insertar(Alumno alumno);

	public void actualizar(Alumno alumno);

	public Alumno buscar(Integer id);

	public void borrar(Integer id);

	// LEFT
	public List<Alumno> seleccionarPorParroquia(String parroquia);

	public List<Alumno> seleccionarPorProvincia(String provincia);

	// FULL
	public List<Alumno> seleccionarTodo();

	public List<Alumno> seleccionarPorTipo(String tipo);

	// WHERE
	public List<Alumno> seleccionarValorMatricula();

    //FETCH
	public List<Alumno> seleccionarFetch();
}
