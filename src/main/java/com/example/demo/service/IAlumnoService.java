package com.example.demo.service;

import com.example.demo.modelo.Alumno;

public interface IAlumnoService {
	
	
	public void agregar(Alumno alumno);
	public void modificar(Alumno alumno);
	public Alumno encontrar(Integer id);
	public void eliminar(Integer id);

}
