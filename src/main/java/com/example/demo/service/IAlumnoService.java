package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.modelo.Alumno;

public interface IAlumnoService {

	public void agregar(Alumno alumno);

	public void modificar(Alumno alumno);

	public Alumno encontrar(Integer id);

	public void eliminar(Integer id);

	// LEFT JOIN
	public List<Alumno> reportePorParroquia(String parroquia);

	public List<Alumno> reportePorProvincia(String provincia);

	// FULL
	public List<Alumno> reporte();

	public List<Alumno> reportePorTipo(String tipo);

	// WHERE
	public List<Alumno> reporteValorMatricula();

	// FETCH
	public List<Alumno> encontrarFetch();
}
