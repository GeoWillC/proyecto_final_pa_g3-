package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Reserva;
import com.example.demo.modelo.Vehiculo;
import com.example.demo.modelo.dto.ReservaDTO;
import com.example.demo.modelo.dto.VehiculoDTO;
import com.example.demo.modelo.dto.VehiculoMyMDTO;
import com.example.demo.service.IClienteService;
import com.example.demo.service.IReservaService;
import com.example.demo.service.IVehiculoService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	private String datocedula;
	private Cliente cliente;
	private Vehiculo vehiculo;
	private List<Reserva> listaRs;

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IVehiculoService iVehiculoService;

	@Autowired
	private IReservaService iReservaService;

	@GetMapping("/funciones")
	public String paginaVistaCliente() {
		return "vistaCliCliente";
	}

	@GetMapping("/buscarVehiculoDisponible")
	public String paginaVistaBuscarVehiculo(Model model, Vehiculo vehiculo) {
		List<VehiculoMyMDTO> lista = this.iVehiculoService.buscarTodos();
		model.addAttribute("vehiculomymdto", lista);
		return "vistaCliListaMYMY";
	}

	@GetMapping("/registrarCliente")
	public String paginaVistaRegistrar(Cliente cliente) {
		return "vistaCliRegistrarCliente";
	}

	@GetMapping("/actualizarCliente")
	public String paginaVistaActualizar(Cliente cliente) {
		return "vistaCliActualizarCliente";
	}

	@PostMapping("/insertar")
	public String insertarCliente(Cliente cliente) {
		cliente.setRegistro("C");
		this.clienteService.crear(cliente);
		return "guardado";
	}

	@GetMapping("/buscarmm")
	public String paginaVistaBuscarVehiculoMM(Vehiculo vehiculo, Model model) {
		List<VehiculoDTO> lista = this.iVehiculoService.buscarVehiculoDisponible(vehiculo.getMarca(),
				vehiculo.getModelo());
		model.addAttribute("vehiculodto", lista);
		return "vistaCliListaMM";
	}

	@GetMapping("/buscarcedula")
	public String paginaVistaBuscarClienteCedula(Cliente cliente, Model model) {

		List<Cliente> cliente1 = this.clienteService.buscarCedula(cliente.getCedula());
		String pagina;
		datocedula = cliente.getCedula();
		model.addAttribute("cedulaCliente", cliente1);
		if (cliente1.isEmpty()) {
			pagina = "vistaNoEncontrado";
		} else {
			pagina = "vistaCliActualizarDatos";
		}

		return pagina;
	}

	@PutMapping("/actualizar")
	public String actualizarPorCedula(Cliente cliente) {
		Cliente cliente2 = this.clienteService.buscarCedula(datocedula).get(0);
		cliente.setId(cliente2.getId());
		cliente.setCedula(datocedula);
		cliente.setRegistro(cliente2.getRegistro());
		cliente.setReserva(cliente2.getReserva());
		System.out.println(cliente);
		this.clienteService.actualizar(cliente);
		return "redirect:/clientes/funciones";
	}

	// RESERVA-----------------------------
	@GetMapping("/reservaVehiculo")
	public String paginaVistaReservaVehiculo(Vehiculo vehiculo, Cliente cliente, Reserva reserva) {
		return "vistaCliReservaCliente";
	}

	@GetMapping("/buscarReserva")
	public String paginaVistaRetornoDisponibilidad(Vehiculo vehiculo, Cliente cliente, Reserva reserva, Model model) {
		String pagina;
		List<Reserva> lista;
		BigDecimal val;
System.out.println(vehiculo);
System.out.println(cliente);
System.out.println(reserva);
		// BOOLEAN PARA DEVOLUCION DE LA VALIDACION
		Boolean valplaca = this.iVehiculoService.validacionPlaca(this.iVehiculoService.buscarParaValidar(),
				vehiculo.getPlaca());
		Boolean valcliente = this.clienteService.validacionCedula(this.clienteService.buscarTodos(),
				cliente.getCedula());

		// VALIDAMOS LAS FECHAS
		Boolean valfechas = this.iReservaService.validacion(reserva.getFechaInicio(), reserva.getFechafinal(),
				this.iReservaService.buscarReserva());
		System.out.println(reserva.getFechaInicio());
		System.out.println(reserva.getFechafinal());
		if (valplaca.equals(true) && valcliente.equals(true)) {
			if (valfechas) {
				lista = this.iReservaService.Reservar(vehiculo.getPlaca(), cliente.getCedula(),
						reserva.getFechaInicio(), reserva.getFechafinal());
				// GUARDAMOS DATOS PARA MANEJAR MAS ADELANTE
				this.listaRs = lista;
				this.cliente = lista.get(lista.size() - 1).getCliente();
				this.vehiculo = lista.get(lista.size() - 1).getVehiculo();
				model.addAttribute("valor", lista.get(lista.size() - 1).getValorTotalPagar());
				pagina = "vistaCliFechaSi";
			} else {
				Vehiculo vehi = this.iVehiculoService.buscarPlaca(vehiculo.getPlaca());
				List<Reserva> inicio = this.iReservaService.ordenarFechas(vehi.getReserva());
				List<ReservaDTO> desde = new ArrayList<>();
				for (int i = 1; i <= inicio.size(); i++) {
					ReservaDTO dto2 = new ReservaDTO();
					dto2.setFechaInicio(inicio.get(i - 1).getFechafinal() + "");
					if (i != inicio.size()) {
						dto2.setFechaFin(inicio.get(i).getFechaInicio() + "");
					} else {
						dto2.setFechaFin("En adelante");
					}
					desde.add(dto2);
				}
				model.addAttribute("inicio", desde);
				pagina = "vistaCliFechaNo";
			}
		} else {
			pagina = "vistaCliFechaNo";
		}
		return pagina;
	}

	@GetMapping("/datosVerificar")
	public String paginaVistaIntegridad(Reserva reserva, Model model) {

		listaRs.get(listaRs.size() - 1).setTarjeta(reserva.getTarjeta());
		model.addAttribute("cliente", cliente);
		model.addAttribute("vehiculo", vehiculo);
		model.addAttribute("reserva", listaRs.get(listaRs.size() - 1));
		return "vistaCliDatosVerificar";

	}

	@PostMapping("/RegistrarReserva")
	public String insertarCliente(Model model) {
		if (listaRs.size() == 0) {
			listaRs.get(listaRs.size()).setEstado("G");
			this.iReservaService.crear(listaRs.get(listaRs.size()));
		} else {
			listaRs.get(listaRs.size() - 1).setEstado("G");
			this.iReservaService.crear(listaRs.get(listaRs.size() - 1));
		}
		vehiculo.setReserva(listaRs);
		cliente.setReserva(listaRs);
		this.iVehiculoService.actualizar(vehiculo);
		this.clienteService.actualizar(cliente);
		if (listaRs.size() == 0) {
			model.addAttribute("numero", listaRs.get(listaRs.size()).getNumero());
		}
		model.addAttribute("numero", listaRs.get(listaRs.size() - 1).getNumero());
		return "vistaCliRegistradoReserva";
	}
}
