package ar.unrn.tp3.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Empleado {

	private String apellido;
	private String nombre;
	private LocalDate fechaNacimiento;
	private String email;

	public Empleado(String apellido, String nombre, LocalDate fechaNacimiento, String email) {
		this.apellido = apellido;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
	}

	public String obtenerApellido () {
		return apellido;
	}
	
	public String obtenerNombre () {
		return nombre;
	}
	
	public LocalDate obtenerFechaDeNacimiento () {
		return fechaNacimiento;
	}
	
	public String obtenerEmail () {
		return email;
	}
	
	public boolean esMiCumpleaños() {
		LocalDate hoy = LocalDate.now();
		String hoyl = hoy.format(DateTimeFormatter.ofPattern("dd/MM"));
		String fechCumple = fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM"));
		return hoyl.contentEquals(fechCumple);

	}

	@Override
	public String toString() {
		return apellido + "," + nombre + "," + fechaNacimiento + "," + email + "\n";
	}
	
	
}
