package com.example.demo.repository;

import com.example.demo.modelo.Escuela;

public interface IEscuelaRepo {

	public void insertar(Escuela escuela);
	public void actualizar(Escuela escuela);
	public Escuela buscar(Integer id);
	public Escuela buscarLigero(Integer id);
	public void borrar(Integer id);

}
