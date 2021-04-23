package ar.unrn.tp3.persistence;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	
	@Override
	public boolean existeUnEmpleado(Empleado emp) {
		for (Empleado e : empleados) {
			if(e.obtenerEmail().equals(emp.obtenerEmail())) {
				return true;
			}
		}
		return false;
	}
}

