package ar.unrn.parcial.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;


public interface RepositorioDeFacturas {

	void registrarFactura(Factura factura);
	ArrayList<Factura> obtenerFacturas() throws Exception;
	ArrayList<Factura> obtenerFacturasEntreFechas(LocalDateTime inicio, LocalDateTime fin) throws Exception;
	
}
