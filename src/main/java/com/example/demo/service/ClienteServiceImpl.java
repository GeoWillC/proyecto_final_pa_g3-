package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Vehiculo;
import com.example.demo.repository.IClienteRepo;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepo clienteRepo;

	@Override
	public void crear(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepo.insertar(cliente);
	}

	@Override
	public Cliente buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.clienteRepo.buscarId(id);
	}

	@Override
	public void actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepo.actualizar(cliente);
	}

	@Override
	public List<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return this.clienteRepo.buscarTodos();
	}

	@Override
	public List<Cliente> buscarApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.clienteRepo.buscarApellido(apellido);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.clienteRepo.eliminar(id);
	}

	@Override
	public List<Cliente> buscarCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.clienteRepo.buscarCedula(cedula);
	}

	@Override
	public Boolean validacionCedula(List<Cliente> clientes, String cedula) {
		Boolean val = false;
		for (Cliente cliente : clientes) {
			if (cedula.equals(cliente.getCedula())) {
				val = true;
			} else {
				val = false;
			}
		}
		return val;
	}

	@Override
	public Cliente buscarCedulaUna(String cedula) {
		// TODO Auto-generated method stub
		return this.clienteRepo.buscarCedulaUna(cedula);
	}

}
