package ar.unrn.tp3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import ar.unrn.tp3.persistence.RegistroDeEmpleadosEnMemoria;
import ar.unrn.tp3.servicioemail.BandejaDeEnviados;
import ar.unrn.tp3.servicioemail.Email;
import ar.unrn.tp3.servicioemail.SmtpException;

public class Tests {

	@Test
	public void EnviarMailDeCumpleaņosTest() throws SmtpException {
		// set up

		RegistroDeEnviados bandeja = new BandejaDeEnviados();
		RegistroDeEmpleados empleados = new RegistroDeEmpleadosEnMemoria();
		Servicio service = new Servicio(empleados, bandeja);

		LocalDate fechaNacimiento = LocalDate.of(1997, 04, 23);
		Empleado empleado = new Empleado("Magliarelli", "Juan", fechaNacimiento, "juanmaax7@gmail.com");
		empleados.registrar(empleado);

		// exercise
		service.enviarMailCumpleaņeros();

		// verify
		assertTrue(service.seEnvioEmailAlEmpleado(empleado));
	}

	@Test
	public void RegistrarEmpleadoTest() throws SmtpException {
		// set up

		RegistroDeEnviados bandeja = new BandejaDeEnviados();
		RegistroDeEmpleados empleados = new RegistroDeEmpleadosEnMemoria();
		Servicio service = new Servicio(empleados, bandeja);

		LocalDate fechaNacimiento = LocalDate.of(1997, 04, 23);
		Empleado empleado = new Empleado("Magliarelli", "Juan", fechaNacimiento, "juanmaax7@gmail.com");

		// exercise
		empleados.registrar(empleado);

		// verify
		assertTrue(empleados.existeUnEmpleado(empleado));
	}

	@Test
	public void CumpleaņosTest() {
		// set up

		RegistroDeEnviados bandeja = new BandejaDeEnviados();
		RegistroDeEmpleados empleados = new RegistroDeEmpleadosEnMemoria();
		Servicio service = new Servicio(empleados, bandeja);

		LocalDate fechaNacimiento = LocalDate.of(1997, 04, 23);
		Empleado empleado = new Empleado("Magliarelli", "Juan", fechaNacimiento, "juanmaax7@gmail.com");

		// exercise
		empleados.registrar(empleado);

		// verify
		assertTrue(empleado.esMiCumpleaņos());

	}

}
