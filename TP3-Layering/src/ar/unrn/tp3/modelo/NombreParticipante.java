package ar.unrn.tp3.modelo;

public class NombreParticipante {
	private String nombre;
	
	public NombreParticipante (String nombre){
		if (nombre.equals("")) 
			new RuntimeException("Debe cargar un nombre");
		this.nombre = nombre;
	}
	
	public String obtenerNombre () {
		return this.nombre;
	}
}
