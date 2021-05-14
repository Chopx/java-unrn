package ar.unrn.parcial.modelo;

public abstract class Combustible {

	private double precio;

	public Combustible(double precio) {
		this.precio = precio;
	}

	public double obtenerPrecio() {
		return precio;
	}

	public abstract double aplicarDescuento(Factura factura);

	public abstract String verTipoDeCombustible();
}
