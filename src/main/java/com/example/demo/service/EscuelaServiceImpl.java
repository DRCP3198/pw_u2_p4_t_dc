package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Alumno;
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

	@Override
	public List<Escuela> reportePorGenero(String genero) {
		// TODO Auto-generated method stub
		return this.escuelaRepo.seleccionarGenero(genero);
	}

	@Override
	public List<Escuela> reporteEdadMayor(Integer edad) {
		// TODO Auto-generated method stub
		return this.escuelaRepo.seleccionarEdadMayor(edad);
	}

	@Override
	public List<Escuela> reporteFechayGenero(LocalDate fecha, String genero) {
		// TODO Auto-generated method stub
		return this.escuelaRepo.seleccionarFechayGenero(fecha, genero);
	}

	@Override
	public List<Escuela> reporteNombre(String nombre) {
		// TODO Auto-generated method stub
		return this.escuelaRepo.seleccionarNombre(nombre);
	}

	@Override
	public List<Escuela> encontrar() {
		// TODO Auto-generated method stub
		return this.escuelaRepo.seleccionar();
	}

	@Override
	public List<Escuela> encontrarFetch() {
		// TODO Auto-generated method stub
		return this.escuelaRepo.seleccionarFetch();
	}


}
