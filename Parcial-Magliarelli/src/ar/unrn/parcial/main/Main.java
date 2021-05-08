package ar.unrn.parcial.main;

import java.time.LocalDateTime;
import java.util.ArrayList;

import ar.unrn.parcial.modelo.*;
import ar.unrn.parcial.persistance.RegistroDeFacturasEnMemoria;

public class Main {
	public static void main(String[] args) throws Exception {
		
		RepositorioDeFacturas repo = new RegistroDeFacturasEnMemoria();
		
		LocalDateTime FechaCualquiera = LocalDateTime.of(2021, 05, 04, 9, 0);
		LocalDateTime FechaSabado = LocalDateTime.of(2021, 5, 8, 9, 0);
		LocalDateTime FechaDomingo = LocalDateTime.of(2021, 5, 9, 9, 0);
		
		LocalDateTime FechaDiaEntre8Y10 = LocalDateTime.of(2021, 5, 9, 9, 0);
		LocalDateTime FechaDiaFuera8Y10 = LocalDateTime.of(2021, 5, 9, 11, 0);
		
		Combustible naftaSuper = new Super(90);
		Combustible naftaComun = new Comun(70);
		
		Litros veinteLts = new Litros(20);
		Litros diezLts = new Litros(10);
		
		Factura facturaNormal = new Factura(FechaCualquiera, naftaSuper, veinteLts, repo);
		Factura facturaConDtoSabadoYllevaMasDe20lts = new Factura(FechaSabado, naftaSuper, veinteLts, repo);
		Factura facturaConDtoSabadoPeroNoLleva20lts = new Factura(FechaSabado, naftaSuper, diezLts, repo);
		Factura facturaConDtoDomingo = new Factura(FechaDomingo, naftaSuper, veinteLts, repo);
		
		Factura facturaComunEnHorario = new Factura(FechaDiaEntre8Y10, naftaComun, veinteLts, repo);
		Factura facturaComunFueraHorario = new Factura(FechaDiaFuera8Y10, naftaComun, veinteLts, repo);
		
		facturaNormal.realizarFactura();
		facturaConDtoSabadoYllevaMasDe20lts.realizarFactura();
		facturaConDtoSabadoPeroNoLleva20lts.realizarFactura();
		facturaConDtoDomingo.realizarFactura();
		facturaComunEnHorario.realizarFactura();
		facturaComunFueraHorario.realizarFactura();
		
		ArrayList<Factura> facturas = repo.obtenerFacturas();
		
		for (Factura f : facturas) {
			System.out.println(f.obtenerMonto());
		}
		
		System.out.println("FacturaNormal: " + facturaNormal.obtenerMonto());
		System.out.println("Factura Sabado y lleva 20 lts: " + facturaConDtoSabadoYllevaMasDe20lts.obtenerMonto());
		System.out.println("Factura Sabado pero no 20 lts: " + facturaConDtoSabadoPeroNoLleva20lts.obtenerMonto());
		System.out.println("FacturaDomingo: " + facturaConDtoDomingo.obtenerMonto());
		
		System.out.println("FacturaComun en Horario: " + facturaComunEnHorario.obtenerMonto());
		System.out.println("FacturaComun fuera Horario: " + facturaComunFueraHorario.obtenerMonto());
		
	}
}
