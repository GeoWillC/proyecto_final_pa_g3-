package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Cliente;

public interface IClienteRepo {

	public void insertar(Cliente cliente);

	public Cliente buscarId(Integer id);

	public void actualizar(Cliente cliente);

	public List<Cliente> buscarTodos();

	public List<Cliente> buscarApellido(String apellido);

	public List<Cliente> buscarCedula(String cedula);

	public void eliminar(Integer id);

	public Cliente buscarCedulaUna(String cedula);

}
