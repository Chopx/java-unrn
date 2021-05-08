package ar.unrn.parcial.modelo;

import java.time.LocalDateTime;

public class Comun extends Combustible {

	
	public Comun(double precio) {
		super(precio);
	}

	public double aplicarDescuento (Factura factura) {
		
		if (esHorarioDeDescuento(factura.fechaDeFactura()))
			return factura.calcularMontoConLitros()*0.05;

		return 0;
	}
	
	private boolean esHorarioDeDescuento(LocalDateTime fecha) {
		if(fecha.getHour() > 07 && fecha.getHour() < 10)
			return true;
		return false;
	}
	
	public String verTipoDeCombustible () {
		return "Comun";
	}

}
