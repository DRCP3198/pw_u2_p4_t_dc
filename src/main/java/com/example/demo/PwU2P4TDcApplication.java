package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Automovil;
import com.example.demo.service.IAutomovilService;

@SpringBootApplication
public class PwU2P4TDcApplication  implements CommandLineRunner{
	
	@Autowired
	private IAutomovilService automovilService;

	public static void main(String[] args) {
		SpringApplication.run(PwU2P4TDcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Automovil auto = new Automovil();
		auto.setMarca("Mazda");
		auto.setModelo("CX3");
		auto.setPrecio(new BigDecimal(27000));
		auto.setFechaFabricación(LocalDateTime.of(2023, 9, 27, 12, 12));
		auto.setEstado("nuevo");
		//this.automovilService.agregar(auto);
		
		Automovil auto1 = new Automovil();
		auto1.setMarca("Mazda");
		auto1.setModelo("CX7");
		auto1.setPrecio(new BigDecimal(47000));
		auto1.setFechaFabricación(LocalDateTime.of(2023, 9, 27, 12, 12));
		auto1.setEstado("nuevo");
		//this.automovilService.agregar(auto1);
		
		Automovil auto2 = new Automovil();
		auto2.setMarca("Suzuki");
		auto2.setModelo("swift");
		auto2.setPrecio(new BigDecimal(19000));
		auto2.setFechaFabricación(LocalDateTime.now());
		auto2.setEstado("nuevo");
		//this.automovilService.agregar(auto2);
		
		Automovil auto3 = new Automovil();
		auto3.setMarca("Chevrolet");
		auto3.setModelo("aveo");
		auto3.setPrecio(new BigDecimal(7500));
		auto3.setFechaFabricación(LocalDateTime.of(2012, 6, 29, 13, 0));
		auto3.setEstado("nuevo");
		//this.automovilService.agregar(auto3);
		
		System.out.println("QUERY");
		Automovil a= this.automovilService.encontrarPorPrecioMayorA(new BigDecimal(46000));
		System.out.println("Auto con valor mayor a 46000: "+a);
		System.out.println();
		List<Automovil> listaAutomovil = this.automovilService.reportePorPrecioMayorA(new BigDecimal(6000));
		System.out.println("Autos con el precio mayor a 6000");
		for (Automovil automovil : listaAutomovil) {
			System.out.println(automovil);
		}
		System.out.println();
		System.out.println("TypedQuery");
		Automovil aut = this.automovilService.encontrarPorPrecioMayorAYMarca(new BigDecimal(7400),"Chevrolet");
		System.out.println("Buscar Auto por marca Chervrolet con valor mayor a 7400 :"+ aut);
		System.out.println();
		List<Automovil> listaAutoTyped = this.automovilService.reporteListaPorPrecioMenorAYEstado(new BigDecimal(30000), "nuevo");
		for (Automovil automovil1 : listaAutoTyped) {
			System.out.println(automovil1);
		}
	}

}
