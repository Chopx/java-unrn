package ar.unrn.tp3.modelo;

public class TelefonoParticipante {
	private String telefono;

	public TelefonoParticipante(String telefono) {
		if (telefono.equals("")) 
			new RuntimeException("Debe cargar un telefono");
		if (!validarTelefono(telefono)) 
			new RuntimeException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
			
		this.telefono = telefono;
		
	
	}

	public String obtenerTelefono () {
		return this.telefono;
	}
	
	private boolean validarTelefono(String telefono) {
		String regex = "\\d{4}-\\d{6}";
		return telefono.matches(regex);
	}

}
