package ar.unrn.tp3.modelo;

import java.util.ArrayList;


public class Servicio {

	private RegistroDeEnviados bandeja;
	private RegistroDeEmpleados empleados;

	public Servicio(RegistroDeEmpleados empleados, RegistroDeEnviados bandeja) {
		this.empleados = empleados;
		this.bandeja = bandeja;
	}

	public void enviarMailCumpleaņeros() {
		ArrayList<Empleado> emps = empleados.obtenerEmpleados();
		for (Empleado e : emps) {
			if (e.esMiCumpleaņos()) 
				bandeja.enviarEmailACumpleaņeros(e);
		}
	}

	public boolean seEnvioEmailAlEmpleado(Empleado emp) {
		return bandeja.seEnvioEmail(emp);
	}

	
}
