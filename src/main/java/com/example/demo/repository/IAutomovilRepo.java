package com.example.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.modelo.Automovil;

public interface IAutomovilRepo {
	// CRUD
	public void insertar(Automovil automovil);

	public void modificar(Automovil automovil);

	public Automovil buscar(Integer id);

	public void eliminar(Integer id);

	// Query
	public Automovil buscarPorPrecioMayorA(BigDecimal precio);

	public List<Automovil> buscarListaPorPrecioMayorA(BigDecimal precio);

	// TypedQuery
	public Automovil buscarPorPrecioMayorAYMarca(BigDecimal precio, String marca);

	public List<Automovil> buscarListaPorPrecioMenorAYEstado(BigDecimal precio, String estado);
	//Criteria ApiQuery query dinamico
	public List<Automovil> buscarPorNombreCriterialAndOr(String marca, String modelo, String estado);
	
    //UPDATE
	 public int actualizarFechaYEstado(LocalDateTime fecha,String modelo,String estado);
	
	//DELETE
	public int borrarPorPecioYMarca(BigDecimal precio,String marca);
	

}
