package com.example.demo.modelo.dto;

public class VehiculoMyMDTO {
	
	private String modelo;

	private String marca;

	public VehiculoMyMDTO() {
		// TODO Auto-generated constructor stub
	}

	public VehiculoMyMDTO(String modelo, String marca) {
		super();
		this.modelo = modelo;
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "VehiculoMyMDTO [modelo=" + modelo + ", marca=" + marca + "]";
	}

}
