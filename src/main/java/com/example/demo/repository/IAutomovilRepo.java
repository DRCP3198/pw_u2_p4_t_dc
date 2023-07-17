package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.modelo.Automovil;
import com.example.demo.modelo.dto.AutomovilDTO;

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
	
	//Automovil DTO
	public List<AutomovilDTO> buscarTodos();

}
