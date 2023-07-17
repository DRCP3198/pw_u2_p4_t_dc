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
	
	@Column(name = "auto_numero_chasis")
	private String numeroChasis;
	
	@Column(name = "auto_numero_motor")
	private String numeroMotor;
	
	@Column(name = "auto_fecha_fabricación")
	private LocalDateTime fechaFabricación;
	
	@Column(name = "auto_precio")
	private BigDecimal precio;
	
	@Column(name = "auto_estado")
	private String estado;
	
	@Column(name = "auto_cilidraje")
	private Double cilindraje;
	
	@Column(name = "auto_color")
	private String color;
	
	
	

	

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

	public String getNumeroChasis() {
		return numeroChasis;
	}

	public void setNumeroChasis(String numeroChasis) {
		this.numeroChasis = numeroChasis;
	}

	public String getNumeroMotor() {
		return numeroMotor;
	}

	public void setNumeroMotor(String numeroMotor) {
		this.numeroMotor = numeroMotor;
	}

	public Double getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(Double cilindraje) {
		this.cilindraje = cilindraje;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
	

}
