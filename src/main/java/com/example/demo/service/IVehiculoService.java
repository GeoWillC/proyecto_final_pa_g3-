package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Vehiculo;
import com.example.demo.modelo.dto.VehiculoDTO;
import com.example.demo.modelo.dto.VehiculoMyMDTO;

public interface IVehiculoService {

	public void crear(Vehiculo vehiculo);

	public Vehiculo buscarId(Integer id);

	public List<VehiculoMyMDTO> buscarTodos();

	public List<Vehiculo> buscarParaValidar();

	public void actualizar(Vehiculo vehiculo);

	public void borrar(Integer id);

	public Vehiculo buscarPlaca(String placa);

	public List<Vehiculo> buscarDispo(String disponibilidad);

	public List<VehiculoDTO> buscarVehiculoDisponible(String marca, String modelo);

	public List<Vehiculo> buscarMarca(String marca);

	public Boolean validacionPlaca(List<Vehiculo> vehiculos, String Placa);

	public List<Vehiculo> buscarVehiculos(String marca, String modelo);
}
