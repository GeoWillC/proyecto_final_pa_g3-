package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Reserva;
import com.example.demo.modelo.dto.ReservaDTO;
import com.example.demo.service.IReservaService;

@Controller
@RequestMapping("/reportes")
public class ReporteController {
	@Autowired
	private IReservaService iReservaService;
	@GetMapping("/buscar")
	public String buscar(ReservaDTO reservaDTO) {

		return "vistaReporte";

	}
	@GetMapping("/buscarReservas")
	public String buscarReservas(ReservaDTO reservaDTO, Model model) {
		ReservaDTO res = new ReservaDTO();
		res.setFechaInicio("1999, 03, 16");
		res.setFechaFin("1999, 07, 16");
		
//		List<Reserva> reservas = this.iReservaService.buscarPorRangoDeFechas(LocalDateTime.parse(reservaDTO.getFechaInicio())
//				,LocalDateTime.parse(reservaDTO.getFechaFin()));
		
		List<Reserva> reservas = this.iReservaService.buscarPorRangoDeFechas(LocalDateTime.parse(res.getFechaInicio()),LocalDateTime.parse(res.getFechaFin()));
		
		
		model.addAttribute("reservas",reservas);
		return "vistaReporteReservas";

	}

}
