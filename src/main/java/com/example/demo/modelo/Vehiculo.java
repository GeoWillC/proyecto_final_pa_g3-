package com.example.demo.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculo")
public class Vehiculo {

	// DATOS
	@Id
	@GeneratedValue(generator = "seq_vehi", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_vehi", sequenceName = "seq_vehi", allocationSize = 1)
	@Column(name = "vehi_id")
	private Integer id;
	@Column(name = "vehi_placa")
	private String placa;
	@Column(name = "vehi_modelo")
	private String modelo;
	@Column(name = "vehi_marca")
	private String marca;
	@Column(name = "vehi_anio_fabricacion")
	private Integer anioFabricion;
	@Column(name = "vehi_pais_fabricacion")
	private String paisFabricion;
	@Column(name = "vehi_cilindraje")
	private String cilindraje;
	@Column(name = "vehi_precio")
	private BigDecimal precio;
	@Column(name = "vehi_valor_dia")
	private BigDecimal valorDia;
	@Column(name = "vehi_disponibilidad")
	private String disponibilidad;

	// RELACION

	@OneToMany(mappedBy = "vehiculo")
	private List<Reserva> reserva;

	// METODOS GET Y SET

	public Integer getId() {
		return id;
	}

	public Integer getAnioFabricion() {
		return anioFabricion;
	}

	public void setAnioFabricion(Integer anioFabricion) {
		this.anioFabricion = anioFabricion;
	}

	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getPaisFabricion() {
		return paisFabricion;
	}

	public void setPaisFabricion(String paisFabricion) {
		this.paisFabricion = paisFabricion;
	}

	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public BigDecimal getValorDia() {
		return valorDia;
	}

	public void setValorDia(BigDecimal valorDia) {
		this.valorDia = valorDia;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	@Override
	public String toString() {
		return "Vehiculo [id=" + id + ", placa=" + placa + ", modelo=" + modelo + ", marca=" + marca
				+ ", anioFabricion=" + anioFabricion + ", paisFabricion=" + paisFabricion + ", cilindraje=" + cilindraje
				+ ", precio=" + precio + ", valorDia=" + valorDia + ", disponibilidad=" + disponibilidad + "]";
	}


	// TO STRING

}