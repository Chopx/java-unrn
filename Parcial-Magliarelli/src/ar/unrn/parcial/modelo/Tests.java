package ar.unrn.parcial.modelo;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import ar.unrn.parcial.persistance.RegistroDeFacturasEnMemoria;



class Tests {

	@Test
	void facturaDescuentoNaftaSuperDomingoTest() throws Exception {
		// set up
		RepositorioDeFacturas repo = new RegistroDeFacturasEnMemoria();
		LocalDateTime FechaDomingo = LocalDateTime.of(2021, 5, 9, 9, 0);
		Combustible naftaSuper = new Super(90);
		Litros veinteLts = new Litros(20);
		Factura facturaConDtoDomingo = new Factura(FechaDomingo, naftaSuper, veinteLts, repo);
				
		// exercise
		facturaConDtoDomingo.realizarFactura();
				
		// verify
		assertEquals(facturaConDtoDomingo.obtenerMonto(), 1620.0, 0.1);
				
	}
	
	@Test
	void facturaDescuentoNaftaSuperSabadoTest() throws Exception {
		// set up
		RepositorioDeFacturas repo = new RegistroDeFacturasEnMemoria();
		LocalDateTime FechaSabado = LocalDateTime.of(2021, 5, 8, 9, 0);
		Combustible naftaSuper = new Super(90);
		Litros veinteLts = new Litros(20);
		Factura facturaConDtoSabadoYllevaMasDe20lts = new Factura(FechaSabado, naftaSuper, veinteLts, repo);
		
		// exercise
		facturaConDtoSabadoYllevaMasDe20lts.realizarFactura();
		
		// verify
		assertEquals(facturaConDtoSabadoYllevaMasDe20lts.obtenerMonto(), 1584.0, 0.1);
		
		
	}
	
	@Test
	void facturaDescuentoNaftaComunEnHorarioTest() throws Exception {
		// set up
		RepositorioDeFacturas repo = new RegistroDeFacturasEnMemoria();
		LocalDateTime Fecha = LocalDateTime.of(2021, 5, 8, 9, 0);
		Combustible naftaComun = new Comun(70);
		Litros veinteLts = new Litros(20);
		Factura facturaComunDtoEnHorario = new Factura(Fecha, naftaComun, veinteLts, repo);
				
		// exercise
		facturaComunDtoEnHorario.realizarFactura();
				
		// verify
		assertEquals(facturaComunDtoEnHorario.obtenerMonto(), 1330.0, 0.1);
				
	}
	
	@Test
	void facturaSinDescuento() throws Exception {
		// set up
		RepositorioDeFacturas repo = new RegistroDeFacturasEnMemoria();
		LocalDateTime Fecha = LocalDateTime.of(2021, 5, 8, 16, 0);
		Combustible naftaComun = new Comun(70);
		Litros veinteLts = new Litros(20);
		Factura facturaComunDtoEnHorario = new Factura(Fecha, naftaComun, veinteLts, repo);
				
		// exercise
		facturaComunDtoEnHorario.realizarFactura();
				
		// verify
		assertEquals(facturaComunDtoEnHorario.obtenerMonto(), 1400.0, 0.1);
				
	}

	@Test
	void facturaSinDescuentoPorLlevarMenosDe20Lts() throws Exception {
		// set up
		RepositorioDeFacturas repo = new RegistroDeFacturasEnMemoria();
		LocalDateTime FechaSabado = LocalDateTime.of(2021, 5, 8, 9, 0);
		Combustible naftaSuper = new Super(90);
		Litros veinteLts = new Litros(10);
		Factura facturaConDtoSabadoYllevaMenosDe20lts = new Factura(FechaSabado, naftaSuper, veinteLts, repo);
				
		// exercise
		facturaConDtoSabadoYllevaMenosDe20lts.realizarFactura();
				
		// verify
		assertEquals(facturaConDtoSabadoYllevaMenosDe20lts.obtenerMonto(), 900.0, 0.1);
				
				
	}
}
