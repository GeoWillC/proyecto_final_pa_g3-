package com.example.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reserva")
public class Reserva {

	// DATOS
	@Id
	@Column(name = "rese_numero")
	private Integer numero;
	@Column(name = "rese_valor_subtotal")
	private BigDecimal valorSubtotal;
	@Column(name = "rese_valor_iva")
	private BigDecimal valorIva;
	@Column(name = "rese_valor_total_pagar")
	private BigDecimal valorTotalPagar;
	@Column(name = "rese_estado")
	private String estado;
	@Column(name = "rese_tarjeta")
	private String tarjeta;
	@Column(name = "rese_fecha_inicio")
	private LocalDateTime fechaInicio;
	@Column(name = "rese_fecha_final")
	private LocalDateTime fechafinal;

	// RELACION

	@ManyToOne
	@JoinColumn(name = "rese_id_vehiculo")
	private Vehiculo vehiculo;

	@ManyToOne
	@JoinColumn(name = "rese_id_cliente")
	private Cliente cliente;

	// METODOS GET Y SET

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getValorSubtotal() {
		return valorSubtotal;
	}

	public void setValorSubtotal(BigDecimal valorSubtotal) {
		this.valorSubtotal = valorSubtotal;
	}

	public BigDecimal getValorIva() {
		return valorIva;
	}

	public void setValorIva(BigDecimal valorIva) {
		this.valorIva = valorIva;
	}

	public BigDecimal getValorTotalPagar() {
		return valorTotalPagar;
	}

	public void setValorTotalPagar(BigDecimal valorTotalPagar) {
		this.valorTotalPagar = valorTotalPagar;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDateTime fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechafinal() {
		return fechafinal;
	}

	public void setFechafinal(LocalDateTime fechafinal) {
		this.fechafinal = fechafinal;
	}

	// TO STRING

	@Override
	public String toString() {
		return "Reserva [numero=" + numero + ", valorSubtotal=" + valorSubtotal + ", valorIva=" + valorIva
				+ ", valorTotalPagar=" + valorTotalPagar + ", estado=" + estado + ", tarjeta=" + tarjeta
				+ ", fechaInicio=" + fechaInicio + ", fechafinal=" + fechafinal + "]";
	}

}
