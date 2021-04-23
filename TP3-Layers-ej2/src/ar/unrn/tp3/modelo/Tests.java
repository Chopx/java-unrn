package ar.unrn.tp3.modelo;

import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

import ar.unrn.tp3.persistence.RegistroDeEmpleadosEnMemoria;
import ar.unrn.tp3.servicioemail.BandejaDeEnviados;
import ar.unrn.tp3.servicioemail.Email;
import ar.unrn.tp3.servicioemail.SmtpException;

public class Tests {

	@Test
	public void EnviarMailDeCumpleañosTest() throws SmtpException {
		// set up
		
		RegistroDeEnviados bandeja = new BandejaDeEnviados();
		RegistroDeEmpleados empleados = new RegistroDeEmpleadosEnMemoria();
		Servicio service = new Servicio(empleados, bandeja);
		
		LocalDate fechaNacimiento = LocalDate.of(1997, 04, 23);
		Empleado empleado = new Empleado("Magliarelli", "Juan", fechaNacimiento, "juanmaax7@gmail.com");
		empleados.registrar(empleado);
		
		// exercise
		service.enviarMailCumpleañeros();
		
		// verify
		assertTrue(service.seEnvioEmailAlEmpleado(empleado));
	}



}
