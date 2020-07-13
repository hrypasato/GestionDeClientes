package com.example.demo.modelo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "facturas")
public class Factura {
	@Id
	private String id;

	private Long idCliente;
	private String fecha;
	private String hora;
	private String total;
	private String estado;
	private List<Producto> items;

	public Factura() {}

	public Factura(Long idCliente, String fecha, String hora, String total, String estado, List<Producto> items) {
		setIdCliente(idCliente);
		setFecha(fecha);
		setHora(hora);
		setTotal(total);
		setEstado(estado);
		setItems(items);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Producto> getItems() {
		return items;
	}

	public void setItems(List<Producto> items) {
		this.items = items;
	}

}
