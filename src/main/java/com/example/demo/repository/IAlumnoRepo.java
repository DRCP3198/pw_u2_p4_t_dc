package com.example.demo.repository;

import com.example.demo.modelo.Alumno;

public interface IAlumnoRepo {
	
	public void insertar(Alumno alumno);
	public void actualizar(Alumno alumno);
	public Alumno buscar(Integer id);
	public void borrar(Integer id);

}
