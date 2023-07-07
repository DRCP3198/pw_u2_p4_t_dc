package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.modelo.Automovil;

public interface IAutomovilService {

	// CRUD
	public void agregar(Automovil automovil);

	public void actualizar(Automovil automovil);

	public Automovil encontrar(Integer id);

	public void borrar(Integer id);

	// Query
	public Automovil encontrarPorPrecioMayorA(BigDecimal precio);

	public List<Automovil> reportePorPrecioMayorA(BigDecimal precio);

	// TypedQuery
	public Automovil encontrarPorPrecioMayorAYMarca(BigDecimal precio, String marca);

	public List<Automovil> reporteListaPorPrecioMenorAYEstado(BigDecimal precio, String estado);

	// Criterial Api Query Dinamico
	public List<Automovil> encontrarPorNombreCriterialAndOr(String marca, String modelo, String estado);

	// UPDATE
	public int modificarFechaYEstado(LocalDateTime fecha, String modelo, String estado);

	// DELETE
	public int eliminarPorPecioYMarca(BigDecimal precio, String marca);

}
