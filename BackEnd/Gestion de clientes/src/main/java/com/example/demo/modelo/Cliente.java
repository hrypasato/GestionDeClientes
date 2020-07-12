package com.example.demo.modelo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
/*
 * Tabla Cliente
 * */
@Entity
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column
	private String name;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private String phone;
	
	@Column 
	private String postalCode;
	
	@Column
	private double saldo;
	
	@Column
	private boolean state;
	
	@Column
	private long id_carrito; 
	/*
	 * Relacion uno a muchos, un cliente realiza multiples calificaciones
	 * */
	@JsonIgnore
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<Calificacion> calificaciones;
	/*
	 * Relacion uno a muchos, un cliente esta asocioado a muchas ubicaciones
	 * */
	@JsonIgnore
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Set<Ubicacion> ubicaciones;
		
	public Cliente() {}

	public Cliente(String name, String email, String password, String phone, String postalCode) {
		setName(name);
		setEmail(email);
		setPassword(password);
		setPhone(phone);
		setPostalCode(postalCode);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public long getId_carrito() {
		return id_carrito;
	}

	public void setId_carrito(long id_carrito) {
		this.id_carrito = id_carrito;
	}

	public Set<Calificacion> getCalificaciones() {
		return calificaciones;
	}

	public void setCalificaciones(Set<Calificacion> calificaciones) {
		this.calificaciones = calificaciones;
	}

	public Set<Ubicacion> getUbicaciones() {
		return ubicaciones;
	}

	public void setUbicaciones(Set<Ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}
	
}
