package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Reserva;
import com.example.demo.modelo.Vehiculo;
import com.example.demo.modelo.dto.VehiculoDTO;
import com.example.demo.service.IClienteService;
import com.example.demo.service.IReservaService;
import com.example.demo.service.IVehiculoService;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {
	private String marca;
	private String apellido;
	private Reserva reserva = new Reserva();

	@Autowired
	private IClienteService iClienteService;

	@Autowired
	private IVehiculoService iVehiculoService;

	@Autowired
	private IReservaService iReservaService;

	// Funcionando
	@GetMapping("/funciones")
	public String paginaNuevaPersona() {
		return "vistaEmplFunciones";
	}

	// 2a
	@PostMapping("/insertar")
	public String pruebaInsertar(Cliente cliente) {
		cliente.setRegistro("E");
		cliente.setVip("V");
		this.iClienteService.crear(cliente);
		return "vistaEmplConfirmacion";
	}

	@GetMapping("/nuevoCliente")
	public String paginaNuevoCliente(Cliente cliente) {
		return "vistaEmplNuevoCliente";
	}

	// 2b
	@GetMapping("/ingresarApellido")
	public String ingresoApellido(Cliente cliente) {
		return "vistaEmplIngresarApellido";
	}

	@GetMapping("/buscarPorApellido")
	public String buscarApellido(Cliente cliente, Model modelo) {
		if (cliente.getApellido() != null) {
			this.apellido = cliente.getApellido();
		}
		List<Cliente> lista = this.iClienteService.buscarApellido(this.apellido);
		modelo.addAttribute("clientes", lista);
		return "vistaEmplListaClientes";
	}

	@GetMapping("/buscarPorIdApellido/{id}")
	public String buscarPorIdApellido(@PathVariable("id") Integer id, Model modelo) {
		Cliente cliente = this.iClienteService.buscarId(id);
		modelo.addAttribute("cliente", cliente);
		return "vistaEmplCliente";
	}

	@PutMapping("/actualizarCliente/{id}")
	public String actualizarEmpleadoCliente(@PathVariable("id") Integer id, Cliente cliente) {
		cliente.setId(id);
		this.iClienteService.actualizar(cliente);
		return "redirect:/empleado/buscarPorApellido";
	}

	@DeleteMapping("/borrarClienteApellido/{id}")
	public String borrarEmpleadoCliente(@PathVariable("id") Integer id) {
		this.iClienteService.borrar(id);
		return "redirect:/empleado/buscarPorApellido";
	}

	// 2c
	@GetMapping("/nuevoVehiculo")
	public String paginaNuevoVehiculo(Vehiculo vehiculo) {
		return "vistaEmplNuevoVehiculo";
	}

	@PostMapping("/insertarVehiculo")
	public String pruebaInsertarVehiculo(Vehiculo vehiculo) {
		this.iVehiculoService.crear(vehiculo);
		return "vistaEmplConfirmacion";
	}

	// 2d
	@GetMapping("/ingresarMarca")
	public String ingresoMarca(Vehiculo vehiculo) {
		return "vistaEmplIngresarMarca";
	}

	@GetMapping("/buscarPorMarca")
	public String buscarMarca(Vehiculo vehiculo, Model modelo) {
		if (vehiculo.getMarca() != null) {
			this.marca = vehiculo.getMarca();
		}
		List<Vehiculo> lista = this.iVehiculoService.buscarMarca(this.marca);
		modelo.addAttribute("vehiculos", lista);
		return "vistaEmplListaVehiculo";
	}

	@GetMapping("/buscarPorId/{id}")
	public String buscarPorId(@PathVariable("id") Integer id, Model modelo) {
		Vehiculo vehiculo = this.iVehiculoService.buscarId(id);
		modelo.addAttribute("vehiculo", vehiculo);
		return "vistaEmplVehiculo";
	}

	@PutMapping("/actualizar/{id}")
	public String actualizarEmpleadoVehiculo(@PathVariable("id") Integer id, Vehiculo vehiculo) {
		vehiculo.setId(id);
		this.iVehiculoService.actualizar(vehiculo);
		return "redirect:/empleado/buscarPorMarca";
	}

	@DeleteMapping("/borrar/{id}")
	public String borrarEmpleadoVehiculo(@PathVariable("id") Integer id) {
		this.iVehiculoService.borrar(id);
		return "redirect:/empleado/buscarPorMarca";
	}

	// 2e
	// 1 el sistema permitirá ingresar un número de reserva 
	@GetMapping("/ingresarNumero")
	public String ingresarNumero(Reserva reserva) {

		return "vistaEmplBuscaRe";
	}

	@GetMapping("/buscarReserva")
	public String buscarReserva(Reserva reserva, Model model) {
		Reserva reservaDato=this.iReservaService.buscarNumero(reserva.getNumero());
		if(reservaDato.equals(null)) {
			return "vistaNoReserva";
		}
		Cliente cliente = this.iClienteService.buscarCedulaUna(reservaDato.getCliente().getCedula());
		System.out.println(cliente);
		Vehiculo vehiculo = this.iVehiculoService.buscarPlaca(reservaDato.getVehiculo().getPlaca());
		model.addAttribute("reserva", reservaDato);
		model.addAttribute("cliente", cliente);
		model.addAttribute("vehiculo", vehiculo);
		vehiculo.setDisponibilidad("ND");
		reservaDato.setEstado("E");
		this.iVehiculoService.actualizar(vehiculo);
		//this.iReservaService.modificar(reservaDato);
		return "vistaEmplReserva";
	}
	// 2f
	@GetMapping("/sinReserva")
	public String sinReserva(Cliente cliente, Vehiculo vehiculo,Reserva reserva, Model modelo) {
		return "vistaEmplSinReserva";
		
	}
//	@GetMapping("/sinReserva")
//	public String sinReserva(Cliente cliente, Vehiculo vehiculo,Reserva reserva, Model modelo) {
//		return "vistaEmplSinReserva";
//		
//	}
}

