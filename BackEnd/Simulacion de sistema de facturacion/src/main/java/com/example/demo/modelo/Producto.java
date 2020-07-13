package com.example.demo.modelo;

public class Producto {
	private Long id;
	private String nombre;
	private int unidades;
	private String precioUnitario;
	
	public Producto() {}

	public Producto(Long id, String nombre, int unidades, String precioUnitario) {
		this.id = id;
		this.nombre = nombre;
		this.unidades = unidades;
		this.precioUnitario = precioUnitario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public String getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(String precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
}
