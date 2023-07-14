package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Alumno;
import com.example.demo.modelo.Escuela;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class EscuelaRepoImpl implements IEscuelaRepo {

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

	// reporte de alumnos y de escuelas
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

	// JOIN
	@Override
	public List<Escuela> seleccionarGenero(String genero) {
		// TODO Auto-generated method stub
		TypedQuery<Escuela> typedQuery = this.entityManager.createQuery(
				"SELECT e from Escuela e  INNER JOIN e.alumnos al where al.genero=:datoGenero", Escuela.class);
		typedQuery.setParameter("datoGenero", genero);
		return typedQuery.getResultList();
	}

	@Override
	public List<Escuela> seleccionarEdadMayor(Integer edad) {
		// TODO Auto-generated method stub
		TypedQuery<Escuela> typedQuery = this.entityManager
				.createQuery("SELECT e from Escuela e INNER JOIN e.alumnos al where al.edad>:datoEdad", Escuela.class);
		typedQuery.setParameter("datoEdad", edad);
		return typedQuery.getResultList();
	}

	//RIGH
	@Override
	public List<Escuela> seleccionarFechayGenero(LocalDate fecha, String genero) {
		// TODO Auto-generated method stub
		TypedQuery<Escuela> typedQuery = this.entityManager.createQuery(
				"SELECT e from Escuela e RIGHT JOIN e.alumnos al where al.fechaNacimiento>=:datoFecha and al.genero=:datoGenero",
				Escuela.class);
		typedQuery.setParameter("datoFecha", fecha);
		typedQuery.setParameter("datoGenero", genero);
		return typedQuery.getResultList();
	}
	//RIGH
		@Override
		public List<Escuela> seleccionarNombre(String nombre) {
			// TODO Auto-generated method stub
			TypedQuery<Escuela> typedQuery = this.entityManager.createQuery(
					"SELECT e from Escuela e RIGHT JOIN e.alumnos al where al.nombre=:datoNombre",
					Escuela.class);
			typedQuery.setParameter("datoNombre", nombre);
			
			return typedQuery.getResultList();
		}
		
		//WHERE
		@Override
		public List<Escuela> seleccionar() {
			// TODO Auto-generated method stub
			TypedQuery<Escuela> query = this.entityManager.createQuery("SELECT es FROM Escuela es, Alumno al WHERE es=al.escuela ", Escuela.class);
			return query.getResultList();
			

		}
}
