package ar.unrn.tp3.modelo;

import java.util.ArrayList;

import ar.unrn.tp3.servicioemail.Email;

public interface RegistroDeEnviados {

	void enviarEmail(Email email);
	boolean seEnvioEmail(Empleado emp);
	void leerEnviados();
	ArrayList<Email> obtenerEnviados();
	void enviarEmailACumpleañeros(Empleado emp);
}
