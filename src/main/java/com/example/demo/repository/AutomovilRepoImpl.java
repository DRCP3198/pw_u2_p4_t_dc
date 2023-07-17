package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Automovil;
import com.example.demo.modelo.dto.AutomovilDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AutomovilRepoImpl implements IAutomovilRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Automovil automovil) {
		// TODO Auto-generated method stub
		this.entityManager.persist(automovil);
	}

	@Override
	public void modificar(Automovil automovil) {
		// TODO Auto-generated method stub
		this.entityManager.merge(automovil);
	}

	@Override
	public Automovil buscar(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Automovil.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(id));
	}

	// QUERY
	@Override
	public Automovil buscarPorPrecioMayorA(BigDecimal precio) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createQuery("select a from Automovil a where a.precio > :datoPrecio");
		query.setParameter("datoPrecio", precio);
		return (Automovil) query.getSingleResult();
	}

	@Override
	public List<Automovil> buscarListaPorPrecioMayorA(BigDecimal precio) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createQuery("select a from Automovil a where a.precio > :datoPrecio");
		query.setParameter("datoPrecio", precio);
		return query.getResultList();
	}

	// TYPEDQUERY
	@Override
	public Automovil buscarPorPrecioMayorAYMarca(BigDecimal precio, String marca) {
		// TODO Auto-generated method stub
		TypedQuery<Automovil> typedQuery = this.entityManager.createQuery(
				"select a from Automovil a where a.precio > :datoPrecio and a.marca=:datoMarca", Automovil.class);
		typedQuery.setParameter("datoPrecio", precio);
		typedQuery.setParameter("datoMarca", marca);
		return typedQuery.getSingleResult();
	}

	@Override
	public List<Automovil> buscarListaPorPrecioMenorAYEstado(BigDecimal precio, String estado) {
		// TODO Auto-generated method stub
		TypedQuery<Automovil> typedQuery = this.entityManager.createQuery(
				"select a from Automovil a where a.precio < :datoPrecio and a.estado=:datoEstado", Automovil.class);
		typedQuery.setParameter("datoPrecio", precio);
		typedQuery.setParameter("datoEstado", estado);
		return typedQuery.getResultList();

	}

	@Override
	public List<AutomovilDTO> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<AutomovilDTO> query = this.entityManager.createQuery(
				"SELECT new com.example.demo.modelo.dto.AutomovilDTO (a.marca,a.modelo,a.cilindraje,a.color) from Automovil a",
				AutomovilDTO.class);
		return query.getResultList();
	}

}
