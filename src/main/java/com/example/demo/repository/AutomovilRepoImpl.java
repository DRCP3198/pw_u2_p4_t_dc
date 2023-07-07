package com.example.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Automovil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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
	public List<Automovil> buscarPorNombreCriterialAndOr(String marca, String modelo, String estado) {
		// TODO Auto-generated method stub
		// 1.Construimos mi fabrica
		CriteriaBuilder myBuilder = this.entityManager.getCriteriaBuilder();
		// 2.Tenemos que especificar el tipo de retorno de mi SQL "Query"
		CriteriaQuery<Automovil> myQuery = myBuilder.createQuery(Automovil.class);
		// Aqui empezamos a crear el SQL como tal, se define la tabla destino "from",
		// ese from va a ser tomado como mi ruta principal FROM-Root
		Root<Automovil> miTablaFrom = myQuery.from(Automovil.class);


		// Creamos los Predicados
		// Predicado del Nombre
		Predicate p1 = myBuilder.equal(miTablaFrom.get("marca"), marca);
		// Predicado del Apellido
		Predicate p2 = myBuilder.equal(miTablaFrom.get("modelo"), modelo);

		// Cuando quiero conformar un AND o un OR pasa a ser un Predicado mas

		Predicate predicadoFinal = null;
		if (estado.equals("nuevo")) {
			// Predicado de AND
			predicadoFinal = myBuilder.or(p1, p2);

		} else {
			// Predicado de OR
			System.out.println("No existe registros");
		}

		myQuery.select(miTablaFrom).where(predicadoFinal);
		TypedQuery<Automovil> myTypedQuery = this.entityManager.createQuery(myQuery);

		return myTypedQuery.getResultList();

	}
}
