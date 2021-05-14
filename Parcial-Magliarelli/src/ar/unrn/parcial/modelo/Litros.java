package ar.unrn.parcial.modelo;

public class Litros {

	private int litros;

	public Litros(int litros) throws ValidarLitrosException {

		if (litros < 1)
			throw new ValidarLitrosException("Debe cargar un valor mayor a 0");
		this.litros = litros;
	}

	public int verCantidadDeLitros() {
		return litros;
	}
}
