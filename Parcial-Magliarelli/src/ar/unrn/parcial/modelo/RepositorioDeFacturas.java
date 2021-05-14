package ar.unrn.parcial.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public interface RepositorioDeFacturas {

	void registrarFactura(LocalDateTime fecha, Combustible tipoDeCombustible, int litros) throws ValidarLitrosException;
	
	double calcularMontoDeFactura(LocalDateTime fecha, Combustible tipoDeCombustible, int litros) throws ValidarLitrosException;

	ArrayList<Factura> obtenerFacturas() throws Exception;

	ArrayList<Factura> obtenerFacturasEntreFechas(LocalDateTime inicio, LocalDateTime fin) throws Exception;

}
