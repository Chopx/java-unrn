package ar.unrn.parcial.persistance;

import java.time.LocalDateTime;
import java.util.ArrayList;

import ar.unrn.parcial.modelo.Combustible;
import ar.unrn.parcial.modelo.Factura;
import ar.unrn.parcial.modelo.Litros;
import ar.unrn.parcial.modelo.RepositorioDeFacturas;
import ar.unrn.parcial.modelo.ValidarLitrosException;

public class RegistroDeFacturasEnMemoria implements RepositorioDeFacturas {

	private ArrayList<Factura> facturas = new ArrayList();

	@Override
	public void registrarFactura(LocalDateTime fecha, Combustible tipoDeCombustible, int litros)
			throws ValidarLitrosException {
		Litros litrosTotal = new Litros(litros);
		Factura factura = new Factura(fecha, tipoDeCombustible, litrosTotal);
		facturas.add(factura);
	}

	@Override
	public double calcularMontoDeFactura(LocalDateTime fecha, Combustible tipoDeCombustible, int litros)
			throws ValidarLitrosException {
		Litros litrosTotal = new Litros(litros);
		Factura factura = new Factura(fecha, tipoDeCombustible, litrosTotal);
		return factura.calcularMontoTotal();
	}

	@Override
	public ArrayList<Factura> obtenerFacturas() {
		return facturas;
	}

	@Override
	public ArrayList<Factura> obtenerFacturasEntreFechas(LocalDateTime inicio, LocalDateTime fin) {
		ArrayList<Factura> facturasEntreFechas = new ArrayList();
		for (Factura f : facturas) {
			if (estaEnElRangoDeFechas(inicio, fin, f.fechaDeFactura())) {
				facturasEntreFechas.add(f);
			}
		}
		return facturasEntreFechas;
	}

	private boolean estaEnElRangoDeFechas(LocalDateTime inicio, LocalDateTime fin, LocalDateTime fechaFactura) {
		if ((fechaFactura.isAfter(inicio) || fechaFactura.isEqual(inicio))
				&& (fechaFactura.isBefore(fin) || fechaFactura.isEqual(fin)))
			return true;
		return false;
	}

}
