package com.example.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Automovil;
import com.example.demo.modelo.dto.AutomovilDTO;
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
		auto.setCilindraje(2.0);
		auto.setColor("rojo");
		auto.setNumeroChasis("a7s8dsd98990dds");
		auto.setNumeroMotor("a2s8ds0da0d8c0c8");
		//this.automovilService.agregar(auto);
		
		Automovil auto1 = new Automovil();
		auto1.setMarca("Mazda");
		auto1.setModelo("CX7");
		auto1.setPrecio(new BigDecimal(47000));
		auto1.setFechaFabricación(LocalDateTime.of(2023, 9, 27, 12, 12));
		auto1.setEstado("nuevo");
		auto1.setCilindraje(2.5);
		auto1.setColor("negro");
		auto1.setNumeroChasis("89230scdks0asa");
		auto1.setNumeroMotor("m2312lls0sasd993");
		//this.automovilService.agregar(auto1);
		
		Automovil auto2 = new Automovil();
		auto2.setMarca("Suzuki");
		auto2.setModelo("swift");
		auto2.setPrecio(new BigDecimal(19000));
		auto2.setFechaFabricación(LocalDateTime.now());
		auto2.setEstado("nuevo");
		auto2.setCilindraje(1.3);
		auto2.setColor("verde");
		auto2.setNumeroChasis("2n3kqwxcof00dds");
		auto2.setNumeroMotor("12jk8dbc8she333");
		//this.automovilService.agregar(auto2);
		
		Automovil auto3 = new Automovil();
		auto3.setMarca("Chevrolet");
		auto3.setModelo("aveo");
		auto3.setPrecio(new BigDecimal(7500));
		auto3.setFechaFabricación(LocalDateTime.of(2012, 6, 29, 13, 0));
		auto3.setEstado("nuevo");
		auto2.setCilindraje(1.5);
		auto2.setColor("azul");
		auto3.setNumeroChasis("a7s8dsd9koko323");
		auto3.setNumeroMotor("a2s8ds0m231mpadsk3");
		//this.automovilService.agregar(auto3);
		
		System.out.println("Reporte AutomovilDTO");
		List<AutomovilDTO> reporte= this.automovilService.reporteAutosRegistrado();
		for (AutomovilDTO automovilDTO : reporte) {
			System.out.println(automovilDTO);
		}
		
	
	}

}
