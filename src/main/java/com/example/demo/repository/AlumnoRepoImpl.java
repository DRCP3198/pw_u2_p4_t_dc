package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.modelo.Alumno;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Transactional
@Repository
public class AlumnoRepoImpl implements IAlumnoRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.entityManager.persist(alumno);
	}

	@Override
	public void actualizar(Alumno alumno) {
		// TODO Auto-generated method stub
		this.entityManager.merge(alumno);
	}

	@Override
	public Alumno buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Alumno.class, id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	@Override
	public List<Alumno> seleccionarPorParroquia(String parroquia) {
		// TODO Auto-generated method stub
		TypedQuery<Alumno> typedQuery = this.entityManager.createQuery(
				"SELECT al FROM Alumno al LEFT JOIN al.escuela es WHERE es.parroquia =:parroquia", Alumno.class);

		typedQuery.setParameter("parroquia", parroquia);
		return typedQuery.getResultList();
	}

	@Override
	public List<Alumno> seleccionarPorProvincia(String provincia) {
		// TODO Auto-generated method stub
		TypedQuery<Alumno> typedQuery = this.entityManager.createQuery(
				"SELECT al FROM Alumno al LEFT JOIN al.escuela es WHERE es.provincia =:datoProvincia", Alumno.class);

		typedQuery.setParameter("datoProvincia", provincia);
		return typedQuery.getResultList();
	}

	@Override
	public List<Alumno> seleccionarTodo() {
		// TODO Auto-generated method stub
		TypedQuery<Alumno> typedQuery = this.entityManager
				.createQuery("SELECT al FROM Alumno al FULL JOIN al.escuela es ", Alumno.class);

		return typedQuery.getResultList();

	}

	@Override
	public List<Alumno> seleccionarPorTipo(String tipo) {
		// TODO Auto-generated method stub
		TypedQuery<Alumno> typedQuery = this.entityManager
				.createQuery("SELECT al FROM Alumno al FULL JOIN al.escuela es where es.tipo=: datoTipo  ", Alumno.class);
        typedQuery.setParameter("datoTipo", tipo);
		return typedQuery.getResultList();

	}

	@Override
	public List<Alumno> seleccionarValorMatricula() {
		// TODO Auto-generated method stub
		TypedQuery<Alumno> query = this.entityManager.createQuery("SELECT al FROM Alumno al, Escuela esc WHERE esc=al.escuela", Alumno.class);
		return query.getResultList();
		
	}

}
