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
		LocalDateTime FechaDomingo = LocalDateTime.of(2021, 5, 9, 9, 0);
		Combustible naftaSuper = new Super(90);
		Litros veinteLts = new Litros(20);
		Factura facturaConDtoDomingo = new Factura(FechaDomingo, naftaSuper, veinteLts);

		double montoTotal = facturaConDtoDomingo.calcularMontoTotal();

		// verify
		assertEquals(montoTotal, 1620.0, 0.1);

	}

	@Test
	void facturaDescuentoNaftaSuperSabadoTest() throws Exception {
		// set up
		LocalDateTime FechaSabado = LocalDateTime.of(2021, 5, 8, 9, 0);
		Combustible naftaSuper = new Super(90);
		Litros veinteLts = new Litros(20);
		Factura facturaConDtoSabadoYllevaMasDe20lts = new Factura(FechaSabado, naftaSuper, veinteLts);

		// exercise
		double montoTotal = facturaConDtoSabadoYllevaMasDe20lts.calcularMontoTotal();

		// verify
		assertEquals(montoTotal, 1584.0, 0.1);

	}

	@Test
	void facturaDescuentoNaftaComunEnHorarioTest() throws Exception {
		// set up
		LocalDateTime Fecha = LocalDateTime.of(2021, 5, 8, 9, 0);
		Combustible naftaComun = new Comun(70);
		Litros veinteLts = new Litros(20);
		Factura facturaComunDtoEnHorario = new Factura(Fecha, naftaComun, veinteLts);

		// exercise
		double montoTotal = facturaComunDtoEnHorario.calcularMontoTotal();

		// verify
		assertEquals(montoTotal, 1330.0, 0.1);

	}

	@Test
	void facturaSinDescuento() throws Exception {
		// set up
		LocalDateTime Fecha = LocalDateTime.of(2021, 5, 8, 16, 0);
		Combustible naftaComun = new Comun(70);
		Litros veinteLts = new Litros(20);
		Factura facturaComunSinDtoEnHorario = new Factura(Fecha, naftaComun, veinteLts);

		// exercise
		double montoTotal = facturaComunSinDtoEnHorario.calcularMontoTotal();

		// verify
		assertEquals(montoTotal, 1400.0, 0.1);

	}

	@Test
	void facturaSinDescuentoPorLlevarMenosDe20Lts() throws Exception {
		// set up
		LocalDateTime FechaSabado = LocalDateTime.of(2021, 5, 8, 9, 0);
		Combustible naftaSuper = new Super(90);
		Litros veinteLts = new Litros(10);
		Factura facturaConDtoSabadoYllevaMenosDe20lts = new Factura(FechaSabado, naftaSuper, veinteLts);

		// exercise
		double montoTotal = facturaConDtoSabadoYllevaMenosDe20lts.calcularMontoTotal();

		// verify
		assertEquals(montoTotal, 900.0, 0.1);

	}
}
