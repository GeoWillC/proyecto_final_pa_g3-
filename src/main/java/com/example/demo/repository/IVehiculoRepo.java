package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Vehiculo;
import com.example.demo.modelo.dto.VehiculoDTO;
import com.example.demo.modelo.dto.VehiculoMyMDTO;

public interface IVehiculoRepo {

	public void insertar(Vehiculo vehiculo);

	public Vehiculo buscarId(Integer id);

	public List<VehiculoMyMDTO> buscarTodos();
	public List<Vehiculo> buscarParaValidar();
	
	public Vehiculo buscarPlaca(String placa);

	public void actualizar(Vehiculo vehiculo);

	public void borrar(Integer id);
	
	public List<Vehiculo> buscarDispo(String disponibilidad);
	
	public List<VehiculoDTO> buscarVehiculoDisponible(String marca , String modelo);
	
	public List<Vehiculo> buscarMarca(String marca);
	 
	public List<Vehiculo> buscarVehiculos(String marca, String modelo);
}
