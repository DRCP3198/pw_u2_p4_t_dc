package com.example.demo.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "alumno")
@Entity
public class Alumno {
	
	@Id
	@SequenceGenerator(name = "seq_alum", sequenceName = "seq_alum",allocationSize = 1)
	@GeneratedValue(generator = "seq_alum",strategy = GenerationType.SEQUENCE)
	@Column(name = "alum_id")
	private Integer id;
	
	@Column(name = "alum_nombre")
	private String nombre;
	
	@Column(name = "alum_edad")
	private Integer edad;
	
	@Column(name = "alum_genero")
	private String genero;
	
	@Column(name = "alum_fecha_nacimiento")
	private LocalDate fechaNacimiento;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "alum_id_Escuela")
	private Escuela escuela;
	
	
	//SET Y GET
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

	public Escuela getEscuela() {
		return escuela;
	}

	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}
	
	

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento( LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", genero=" + genero
				+ ", fechaNacimiento=" + fechaNacimiento + ", escuela=" + escuela + "]";
	}

	
	
	

}
