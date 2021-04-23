package ar.unrn.tp3.servicioemail;

import java.util.ArrayList;

import ar.unrn.tp3.modelo.Empleado;
import ar.unrn.tp3.modelo.RegistroDeEnviados;

public class BandejaDeEnviados implements RegistroDeEnviados {

	private ArrayList<Email> bandejaEnviados = new ArrayList();


	@Override
	public void enviarEmail(Email email) {
		
		try {
			email.enviar();
			bandejaEnviados.add(email);
		} catch (SmtpException se) {
			System.out.println("Error en la bandeja de enviados");
		}
		
	}

	@Override
	public boolean seEnvioEmail(Empleado emp) {
		for (Email e : bandejaEnviados) {
			if(e.destinatarioEmail.contentEquals(emp.obtenerEmail())) 
				return true;
		}
		return false;
	}
	
	@Override
	public void leerEnviados() {
		for (Email e : bandejaEnviados) {
			System.out.println("Destinatario: " + e.destinatarioEmail + ", T�tulo: " + e.tituloEmail  + ", Cuerpo:" + e.cuerpoEmail );
		}
	}
	
	@Override
	public ArrayList<Email> obtenerEnviados() {
		return bandejaEnviados;
	}

	
	@Override
	public void enviarEmailACumplea�eros(Empleado emp) {
		Email email = new Email(emp.obtenerEmail(), "Feliz Cumplea�os", "�" + emp.obtenerApellido() + " " + emp.obtenerNombre() + " le deseamos un feliz cumplea�os!");
		enviarEmail(email);			
	}
	
	
}

