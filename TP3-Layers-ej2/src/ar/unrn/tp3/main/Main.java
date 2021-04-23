package ar.unrn.tp3.main;

import java.time.LocalDate;

import ar.unrn.tp3.modelo.Empleado;
import ar.unrn.tp3.modelo.RegistroDeEmpleados;
import ar.unrn.tp3.modelo.RegistroDeEnviados;
import ar.unrn.tp3.modelo.Servicio;
import ar.unrn.tp3.persistence.RegistroDeEmpleadosEnDisco;
import ar.unrn.tp3.persistence.RegistroDeEmpleadosEnMemoria;
import ar.unrn.tp3.servicioemail.BandejaDeEnviados;

public class Main {

	public static void main(String[] args) {

		RegistroDeEnviados bandeja = new BandejaDeEnviados();
		RegistroDeEmpleados empleados = new RegistroDeEmpleadosEnDisco();

/*
		LocalDate fechaemp1 = LocalDate.of(1997, 03, 29);
		Empleado emp1 = new Empleado("Magliarelli", "Juan", fechaemp1, "juanmaax7@gmail.com");
		LocalDate fechaemp2 = LocalDate.of(1990, 04, 23);
		Empleado emp2 = new Empleado("Sanchez", "Miguel", fechaemp2, "sanmi07@gmail.com");
		LocalDate fechaemp3 = LocalDate.of(1987, 10, 06);
		Empleado emp3 = new Empleado("Gomez", "Florencia", fechaemp3, "gomezflorr@hotmail.com");

		empleados.registrar(emp1);
		empleados.registrar(emp2);
		empleados.registrar(emp3);
*/
		Servicio service = new Servicio(empleados, bandeja);

		service.enviarMailCumpleañeros();

		bandeja.leerEnviados();

	}

}
