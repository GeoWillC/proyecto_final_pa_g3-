package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Reserva;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class ReservaRepoImpl implements IReservaRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void ingresar(Reserva reserva) {
		// TODO Auto-generated method stub
		this.entityManager.persist(reserva);
	}

	@Override
	public Reserva buscarNumero(Integer numero) {
		// TODO Auto-generated method stub
		TypedQuery<Reserva> query = this.entityManager.createQuery("select r from Reserva r where r.numero=: dato",
				Reserva.class);
		query.setParameter("dato", numero);
		return query.getSingleResult();
	}

	@Override
	public List<Reserva> buscarReserva() {
		TypedQuery<Reserva> query = this.entityManager.createQuery("select r from Reserva r", Reserva.class);
		List<Reserva> listaTotal = query.getResultList();
		return listaTotal;
	}

	@Override
	public void eliminar(Integer numero) {
		// TODO Auto-generated method stub
		Reserva reserva = this.buscarNumero(numero);
		this.entityManager.remove(reserva);
	}

	@Override
	public List<Reserva> buscarPorRangoDeFechas(LocalDateTime fechaInicio, LocalDateTime fechaFin) {
		// TODO Auto-generated method stub
		TypedQuery<Reserva> myQuery = this.entityManager.createQuery(
				"select e from Reserva e where e.fechaInicio>= :datoFechaInicio AND e.fechafinal<= :datoFechaFin",
				Reserva.class);
		myQuery.setParameter("datoFechaInicio", fechaInicio);
		myQuery.setParameter("datoFechaFin", fechaFin);
		List<Reserva> reservas = myQuery.getResultList();
		return reservas;
	}
	@Override
	public void actualizar(Reserva reserva) {
		// TODO Auto-generated method stub
		this.entityManager.merge(Reserva.class);
	}
}
