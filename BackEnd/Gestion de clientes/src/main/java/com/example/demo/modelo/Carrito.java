package com.example.demo.modelo;

import java.util.Random;
/*Entidad Carrito usada para simular la interaccion con 
 *el subsitema de interfaz de compra
 * genera una direccion Ip y un idcarrito  
 * */
public class Carrito {
	private Long idCarrito;
	private String ip;
	
	public Carrito() {
		Random r = new  Random();
		setId((long) r.nextInt(1000));
		setIp(""+r.nextInt(192)+"."+r.nextInt(192)+"."+r.nextInt(192)+"."+r.nextInt(192)+"");
	}

	public Long getIdCarrito() {
		return idCarrito;
	}

	public void setId(Long idCarrito) {
		this.idCarrito = idCarrito;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
}
