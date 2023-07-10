package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Alumno;
import com.example.demo.repository.IAlumnoRepo;

@Service
public class AlumnoServiceImpl implements IAlumnoService{
	
	@Autowired
	private IAlumnoRepo alumnoRepo;

	@Override
	public void agregar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.alumnoRepo.insertar(alumno);
	}

	@Override
	public void modificar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.alumnoRepo.actualizar(alumno);
	}

	@Override
	public Alumno encontrar(Integer id) {
		// TODO Auto-generated method stub
		return this.alumnoRepo.buscar(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.alumnoRepo.borrar(id);
	}

}
