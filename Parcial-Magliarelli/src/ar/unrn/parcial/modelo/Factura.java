package ar.unrn.parcial.modelo;

import java.time.LocalDateTime;

public class Factura {

	private LocalDateTime fecha;
	private Combustible combustible;
	private Litros litros;
	private double monto;
	private RepositorioDeFacturas repositorio;
	
	public Factura (LocalDateTime fecha, Combustible combustible, Litros litros, RepositorioDeFacturas repositorio) {
		this.fecha = fecha;
		this.combustible = combustible;
		this.litros = litros;
		this.repositorio = repositorio;
		//this.monto = calcularMontoTotal();
		
	}
	
	public LocalDateTime fechaDeFactura() {
		return fecha;
	}
	
	public double obtenerPrecioCombustiblePorLitro() {
		return combustible.obtenerPrecio();
	}
	
	public int cantidadDeLitros() {
		return litros.verCantidadDeLitros();
	}
	
	public double obtenerMonto() {
		return monto;
	}
	
	public double calcularMontoConLitros() {
		return obtenerPrecioCombustiblePorLitro()*litros.verCantidadDeLitros();
	}
	
	public double calcularMontoTotal() {
		double montoTotal = calcularMontoConLitros() - combustible.aplicarDescuento(this);
		return montoTotal;
	}
	
	public void realizarFactura() {
		this.monto = calcularMontoTotal();
		this.repositorio.registrarFactura(this);
	}
	
	public String verTipoDeCombustible() {
		return combustible.verTipoDeCombustible();
	}
	
	@Override
	public String toString() {
		return fecha.toLocalDate() + "," + combustible.verTipoDeCombustible() + "," + litros.verCantidadDeLitros() + "," + calcularMontoTotal() + "\n";
	}
}
