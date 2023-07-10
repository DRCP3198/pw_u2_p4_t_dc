package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Escuela;
import com.example.demo.repository.IEscuelaRepo;

@Service 
public class EscuelaServiceImpl  implements IEscuelaService{

	@Autowired
	private IEscuelaRepo escuelaRepo;
	@Override
	public void agregar(Escuela escuela) {
		// TODO Auto-generated method stub
		this.escuelaRepo.insertar(escuela);
	}

	@Override
	public void modificar(Escuela escuela) {
		// TODO Auto-generated method stub
		this.escuelaRepo.actualizar(escuela);
	}

	@Override
	public Escuela encontrarLazy(Integer id) {
		// TODO Auto-generated method stub
		return this.escuelaRepo.buscar(id);
	}

	@Override
	public Escuela encontrarLigero(Integer id) {
		// TODO Auto-generated method stub
		return this.escuelaRepo.buscarLigero(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.escuelaRepo.borrar(id);
	}


}
