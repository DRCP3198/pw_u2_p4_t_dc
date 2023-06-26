package com.example.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "automovil")
@Entity
public class Automovil {
	
	@Id
	@SequenceGenerator(name = "seq_automovil",sequenceName = "seq_automovil",allocationSize = 1)
	@GeneratedValue(generator = "seq_automovil",strategy = GenerationType.SEQUENCE)
	@Column(name = "auto_id")
	private Integer id;
	
	@Column(name = "auto_marca")
	private String marca;
	
	@Column(name = "auto_modelo")
	private String modelo;
	
	@Column(name = "auto_fecha_fabricación")
	private LocalDateTime fechaFabricación;
	
	@Column(name = "auto_precio")
	private BigDecimal precio;
	
	@Column(name = "auto_estado")
	private String estado;
	
	

	@Override
	public String toString() {
		return "Automovil [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", fechaFabricación="
				+ fechaFabricación + ", precio=" + precio + ", estado=" + estado + "]";
	}

	//Set y Get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public LocalDateTime getFechaFabricación() {
		return fechaFabricación;
	}

	public void setFechaFabricación(LocalDateTime fechaFabricación) {
		this.fechaFabricación = fechaFabricación;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	

}
