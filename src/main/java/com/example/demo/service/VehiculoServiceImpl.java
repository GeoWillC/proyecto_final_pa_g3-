package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Vehiculo;
import com.example.demo.modelo.dto.VehiculoDTO;
import com.example.demo.modelo.dto.VehiculoMyMDTO;
import com.example.demo.repository.IVehiculoRepo;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

	@Autowired
	private IVehiculoRepo iVehiculoRepo;

	@Override
	public void crear(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.iVehiculoRepo.insertar(vehiculo);
	}

	@Override
	public Vehiculo buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.iVehiculoRepo.buscarId(id);
	}

	@Override
	public List<VehiculoMyMDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return this.iVehiculoRepo.buscarTodos();
	}

	@Override
	public List<Vehiculo> buscarParaValidar() {
		// TODO Auto-generated method stub
		return this.iVehiculoRepo.buscarParaValidar();
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.iVehiculoRepo.actualizar(vehiculo);
	}

	@Override
	public void borrar(Integer id) {
		// TODO Auto-generated method stub
		this.iVehiculoRepo.borrar(id);
	}

	@Override
	public List<Vehiculo> buscarDispo(String disponibilidad) {
		// TODO Auto-generated method stub
		return this.iVehiculoRepo.buscarDispo(disponibilidad);
	}

	@Override
	public Vehiculo buscarPlaca(String placa) {
		// TODO Auto-generated method stub
		return this.iVehiculoRepo.buscarPlaca(placa);
	}

	@Override
	public List<VehiculoDTO> buscarVehiculoDisponible(String marca, String modelo) {
		// TODO Auto-generated method stub
		return this.iVehiculoRepo.buscarVehiculoDisponible(marca, modelo);
	}

	@Override
	public List<Vehiculo> buscarMarca(String marca) {
		// TODO Auto-generated method stub
		return this.iVehiculoRepo.buscarMarca(marca);
	}

	@Override
	public Boolean validacionPlaca(List<Vehiculo> vehiculos, String placa) {
		// TODO Auto-generated method stub
		Boolean val=false;
		for (Vehiculo vehiculo : vehiculos) {
			if(placa.equals(vehiculo.getPlaca())) {
				val=true;
			}else {
				val=false;
			}
		}
		return val;
	}

	@Override
	public List<Vehiculo> buscarVehiculos(String marca, String modelo) {
		// TODO Auto-generated method stub
		return this.iVehiculoRepo.buscarVehiculos(marca,modelo);
	}

}
