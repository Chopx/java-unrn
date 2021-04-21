package ar.unrn.tp3.modelo;


public class Participante {
	private NombreParticipante nombre;
	private TelefonoParticipante telefono;
	private RegionParticipante region;
	
	public Participante (String nombre, String telefono, String region) {
		this.nombre = new NombreParticipante(nombre);
		this.telefono = new TelefonoParticipante(telefono);
		this.region = new RegionParticipante(region);
	}
	
	public String obtenerNombre () {
		return nombre.obtenerNombre();
	}
	
	public String obtenerTelefono () {
		return telefono.obtenerTelefono();
	}
	
	public String obtenerRegion () {
		return region.obtenerRegion();
	}
}
