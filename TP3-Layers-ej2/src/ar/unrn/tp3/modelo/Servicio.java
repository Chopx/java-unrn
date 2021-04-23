package ar.unrn.tp3.modelo;

import java.util.ArrayList;


public class Servicio {

	private RegistroDeEnviados bandeja;
	private RegistroDeEmpleados empleados;

	public Servicio(RegistroDeEmpleados empleados, RegistroDeEnviados bandeja) {
		this.empleados = empleados;
		this.bandeja = bandeja;
	}

	public void enviarMailCumplea�eros() {
		ArrayList<Empleado> emps = empleados.obtenerEmpleados();
		for (Empleado e : emps) {
			if (e.esMiCumplea�os()) 
				bandeja.enviarEmailACumplea�eros(e);
		}
	}

	public boolean seEnvioEmailAlEmpleado(Empleado emp) {
		return bandeja.seEnvioEmail(emp);
	}

	
}
