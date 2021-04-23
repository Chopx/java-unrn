package ar.unrn.tp3.persistence;

import java.util.ArrayList;

import ar.unrn.tp3.modelo.Empleado;
import ar.unrn.tp3.modelo.RegistroDeEmpleados;


public class RegistroDeEmpleadosEnMemoria implements RegistroDeEmpleados {

	private ArrayList<Empleado> empleados = new ArrayList();
	
	@Override
	public void registrar(Empleado empleado) {
		empleados.add(empleado);
	}
	
	@Override
	public ArrayList<Empleado> obtenerEmpleados() {
		return empleados;
	}
}

