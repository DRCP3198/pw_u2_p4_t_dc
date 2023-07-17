package com.example.demo.modelo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;

public class AutomovilDTO {
	
	
	private String marca;
	
	private String modelo;

	private Double cilindraje;
	
	private String color;
	
	public AutomovilDTO() {
		// TODO Auto-generated constructor stub
	}

	public AutomovilDTO(String marca, String modelo, Double cilindraje, String color) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.cilindraje = cilindraje;
		this.color = color;
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

	@Override
	public String toString() {
		return "AutomovilDTO [marca=" + marca + ", modelo=" + modelo + ", cilindraje=" + cilindraje + ", color=" + color
				+ "]";
	}
	
	

}
