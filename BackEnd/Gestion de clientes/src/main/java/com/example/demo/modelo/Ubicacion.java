package com.example.demo.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
/*
 * Tabla Ubicacion
 * */
@Entity
public class Ubicacion implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String callePrincipal;
	
	@Column
	private String calleSecundaria;
	
	@Column
	private String referencia;
	
	@Column
	private String numeroDomicilio;
	
	@Column
	private Long idParroquia;
    
	@JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;//Clave foranea, almacena el id del cliente 
	
    public Ubicacion() {}

	public Ubicacion(String callePrincipal, String calleSecundaria, String referencia, String numeroDomicilio, Long parroquiaId) {
		setCallePrincipal(callePrincipal);
		setCalleSecundaria(calleSecundaria);
		setReferencia(referencia);
		setNumeroDomicilio(numeroDomicilio);
		setParroquiaId(parroquiaId);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCallePrincipal() {
		return callePrincipal;
	}

	public void setCallePrincipal(String callePrincipal) {
		this.callePrincipal = callePrincipal;
	}

	public String getCalleSecundaria() {
		return calleSecundaria;
	}

	public void setCalleSecundaria(String calleSecundaria) {
		this.calleSecundaria = calleSecundaria;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getNumeroDomicilio() {
		return numeroDomicilio;
	}

	public void setNumeroDomicilio(String numeroDomicilio) {
		this.numeroDomicilio = numeroDomicilio;
	}
	
	public Long getIdParroquia() {
		return idParroquia;
	}

	public void setParroquiaId(Long idParroquia) {
		this.idParroquia = idParroquia;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
    
}
