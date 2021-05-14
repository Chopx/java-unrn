package ar.unrn.parcial.modelo;

import java.time.LocalDateTime;

public class Super extends Combustible {

	public Super(double precio) {
		super(precio);
	}

	public double aplicarDescuento(Factura factura) {

		if (esSabado(factura.fechaDeFactura()) && llevaMasDe20Lts(factura.cantidadDeLitros()))
			return factura.calcularMontoConLitros() * 0.12;
		if (esDomingo(factura.fechaDeFactura()))
			return factura.calcularMontoConLitros() * 0.10;

		return 0;
	}

	private boolean esDomingo(LocalDateTime fecha) {
		if (fecha.getDayOfWeek().toString().equals("SUNDAY"))
			return true;
		return false;
	}

	private boolean esSabado(LocalDateTime fecha) {
		if (fecha.getDayOfWeek().toString().equals("SATURDAY"))
			return true;
		return false;
	}

	private boolean llevaMasDe20Lts(int litros) {
		return (litros > 19);
	}

	public String verTipoDeCombustible() {
		return "Super";
	}

}
