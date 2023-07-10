package com.example.demo.service;

import com.example.demo.modelo.Escuela;

public interface IEscuelaService {

	public void agregar(Escuela escuela);
	public void modificar(Escuela escuela);
	public Escuela encontrarLazy(Integer id);
	public Escuela encontrarLigero(Integer id);
	public void eliminar(Integer id);

}
