package ar.unrn.tp3.modelo;

import java.util.ArrayList;

public interface RegistroDeEmpleados {

	void registrar(Empleado empleado);
	ArrayList<Empleado> obtenerEmpleados();
	boolean existeUnEmpleado(Empleado emp);
}