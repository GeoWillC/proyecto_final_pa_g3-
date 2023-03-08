package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Reserva;
import com.example.demo.modelo.Vehiculo;
import com.example.demo.repository.IReservaRepo;
import com.example.demo.repository.IVehiculoRepo;
import com.example.demo.service.IClienteService;
import com.example.demo.service.IReservaService;
import com.example.demo.service.IVehiculoService;

@SpringBootApplication
public class ProyectoFinalPaG3Application {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalPaG3Application.class, args);
	}

}
