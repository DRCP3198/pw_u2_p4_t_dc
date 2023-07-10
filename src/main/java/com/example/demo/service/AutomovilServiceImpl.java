package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Automovil;
import com.example.demo.modelo.dto.AutomovilDTO;
import com.example.demo.repository.IAutomovilRepo;

@Service
public class AutomovilServiceImpl implements IAutomovilService{
	
	@Autowired
	private IAutomovilRepo automovilRepo;

	@Override
	public void agregar(Automovil automovil) {
		// TODO Auto-generated method stub
		this.automovilRepo.insertar(automovil);
	}

	@Override
	public void actualizar(Automovil automovil) {
		// TODO Auto-generated method stub
		this.automovilRepo.modificar(automovil);
	}

	@Override
	public Automovil encontrar(Integer id) {
		// TODO Auto-generated method stub
		return this.automovilRepo.buscar(id);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.automovilRepo.eliminar(id);
	}

	@Override
	public Automovil encontrarPorPrecioMayorA(BigDecimal precio) {
		// TODO Auto-generated method stub
		return this.automovilRepo.buscarPorPrecioMayorA(precio);
	}

	@Override
	public List<Automovil> reportePorPrecioMayorA(BigDecimal precio) {
		// TODO Auto-generated method stub
		return this.automovilRepo.buscarListaPorPrecioMayorA(precio);
	}

	@Override
	public Automovil encontrarPorPrecioMayorAYMarca(BigDecimal precio, String marca) {
		// TODO Auto-generated method stub
		return this.automovilRepo.buscarPorPrecioMayorAYMarca(precio, marca);
	}

	@Override
	public List<Automovil> reporteListaPorPrecioMenorAYEstado(BigDecimal precio, String estado) {
		// TODO Auto-generated method stub
		return this.automovilRepo.buscarListaPorPrecioMenorAYEstado(precio, estado);
	}

	@Override
	public List<AutomovilDTO> reporteAutosRegistrado() {
		// TODO Auto-generated method stub
		return this.automovilRepo.buscarTodos();
	}

}
