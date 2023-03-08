package com.example.demo.modelo.dto;

import java.math.BigDecimal;

public class VehiculoDTO {
	
	private String placa;
	
	private String modelo;
	
	private String marca;

	private Integer anioFabricion;
	
	private String disponibilidad;

	private BigDecimal valorDia;
	
	
	
	public VehiculoDTO() {
		
	}

	public VehiculoDTO(String placa, String modelo, String marca, Integer anioFabricion, String disponibilidad,
			BigDecimal valorDia) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.anioFabricion = anioFabricion;
		this.disponibilidad = disponibilidad;
		this.valorDia = valorDia;
		
		//get and set 
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
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

	

	public Integer getAnioFabricion() {
		return anioFabricion;
	}

	public void setAnioFabricion(Integer anioFabricion) {
		this.anioFabricion = anioFabricion;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public BigDecimal getValorDia() {
		return valorDia;
	}

	public void setValorDia(BigDecimal valorDia) {
		this.valorDia = valorDia;
	}

	@Override
	public String toString() {
		return "VehiculoDTO [placa=" + placa + ", modelo=" + modelo + ", marca=" + marca + ", añoFabricion="
				+ anioFabricion + ", disponibilidad=" + disponibilidad + ", valorDia=" + valorDia + "]";
	}
	
	
	
	
}
