package com.example.demo.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*
 * Tabla de clientes no registrados
 * */
@Entity
public class NoRegistrado implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column
	private String fecha;
	@Column
	private String direccionIp;
	@Column
	private Long idCarrito;
	
	public NoRegistrado() {}

	public NoRegistrado(String fecha, String direccionIp, Long idCarrito) {
		setFecha(fecha);
		setDireccionIp(direccionIp);
		setIdCarrito(idCarrito);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDireccionIp() {
		return direccionIp;
	}

	public void setDireccionIp(String direccionIp) {
		this.direccionIp = direccionIp;
	}

	public Long getIdCarrito() {
		return idCarrito;
	}

	public void setIdCarrito(Long idCarrito) {
		this.idCarrito = idCarrito;
	}
	
}
