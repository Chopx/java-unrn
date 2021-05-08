package ar.unrn.parcial.persistance;

import java.time.LocalDateTime;
import java.util.ArrayList;

import ar.unrn.parcial.modelo.Factura;
import ar.unrn.parcial.modelo.RepositorioDeFacturas;


public class RegistroDeFacturasEnMemoria implements RepositorioDeFacturas{

	private ArrayList<Factura> facturas = new ArrayList();
	
	@Override
	public void registrarFactura(Factura factura) {
		facturas.add(factura);
	}
	
	@Override
	public ArrayList<Factura> obtenerFacturas() {
		return facturas;
	}
	
	@Override
	public ArrayList<Factura> obtenerFacturasEntreFechas(LocalDateTime inicio, LocalDateTime fin) {
		ArrayList<Factura> facturasEntreFechas = new ArrayList();
		for (Factura f : facturas) {
			if(estaEnElRangoDeFechas(inicio, fin, f.fechaDeFactura())) {
				facturasEntreFechas.add(f);
			}
		}
		return facturasEntreFechas;
	}
	
	private boolean estaEnElRangoDeFechas(LocalDateTime inicio, LocalDateTime fin, LocalDateTime fechaFactura) {
		if((fechaFactura.isAfter(inicio) || fechaFactura.isEqual(inicio)) 
				&& (fechaFactura.isBefore(fin) || fechaFactura.isEqual(fin))) 
			return true;
		return false;
	}
	
}
