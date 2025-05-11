package models;

import org.json.simple.JSONObject;

public class Producto{
	

	private int ID;
	private String nombre;
	private double precio;
	private int stock;
	
	public Producto(int ID, String nombre, double precio, int stock ) {
		this.ID=ID;
		this.nombre=nombre;
		this.precio=precio;
		this.stock=stock;
	}

	public int getID() {
		return ID;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public int getStock() {
		return stock;
	}
	
}
