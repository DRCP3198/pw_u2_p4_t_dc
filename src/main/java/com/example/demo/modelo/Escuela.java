package com.example.demo.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "escuela")
public class Escuela {

	@Id
	@SequenceGenerator(name = "seq_escuela", sequenceName = "seq_escuela", allocationSize = 1)
	@GeneratedValue(generator = "seq_escuela", strategy = GenerationType.SEQUENCE)
	@Column(name = "escu_id")
	private Integer id;

	@Column(name = "escu_nombre")
	private String nombre;

	@Column(name = "escu_parroquia")
	private String parroquia;
	
	@Column(name = "escu_provincia")
	private String provincia;
	
	@Column(name = "escu_dirección")
	private String direccion;
	
	@Column(name = "escu_valorMatricula")
	private BigDecimal valorMatricula;
	
	@Column(name = "escu_tipo")
	private String tipo;
	
	//La escuela tiene muchos alumnos
	@OneToMany(mappedBy = "escuela", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Alumno> alumnos;

	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getParroquia() {
		return parroquia;
	}

	public void setParroquia(String parroquia) {
		this.parroquia = parroquia;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public BigDecimal getValorMatricula() {
		return valorMatricula;
	}

	public void setValorMatricula(BigDecimal valorMatricula) {
		this.valorMatricula = valorMatricula;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	@Override
	public String toString() {
		return "Escuela [id=" + id + ", nombre=" + nombre + ", parroquia=" + parroquia + ", provincia=" + provincia
				+ ", direccion=" + direccion + ", valorMatricula=" + valorMatricula + ", tipo=" + tipo + "]";
	}
	
	
	
	

}
