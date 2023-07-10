package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Escuela;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class EscuelaRepoImpl implements IEscuelaRepo{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Escuela escuela) {
		// TODO Auto-generated method stub
		this.entityManager.persist(escuela);
	}

	@Override
	public void actualizar(Escuela escuela) {
		// TODO Auto-generated method stub
		this.entityManager.merge(escuela);
	}

    //reporte de alumnos y de escuelas
	@Override
	public Escuela buscar(Integer id) {
		// TODO Auto-generated method stub
		Escuela escuela = this.entityManager.find(Escuela.class, id);
		escuela.getAlumnos().size();
		return escuela;
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarLigero(id));
	}

	@Override
	public Escuela buscarLigero(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Escuela.class, id);
	}

}
