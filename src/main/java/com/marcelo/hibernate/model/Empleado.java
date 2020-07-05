package com.marcelo.hibernate.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLEADO")
public class Empleado implements Serializable {

	private static final long serialVersionUID = -5402896387363898179L;
	@Id
	@Column(name="COD_EMPLEADO")
	private Long codigo;
	@Column(name="APELLIDOS")
	private String apellido;
	@Column (name= "NOMBRE")
	private String nombre;
	@Column(name="FECHA_NACIMIENTO")
	private LocalDate FechaNac;
	
	public Empleado () {
		
	}

	public Empleado(Long codigo, String apellido, String nombre, LocalDate fechaNac) {
		this.codigo = codigo;
		this.apellido = apellido;
		this.nombre = nombre;
		FechaNac = fechaNac;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNac() {
		return FechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		FechaNac = fechaNac;
	}

	@Override
	public String toString() {
		return "Empleado [codigo=" + codigo + ", apellido=" + apellido + ", nombre=" + nombre + ", FechaNac=" + FechaNac
				+ "]";
	}
	
	
	
}
