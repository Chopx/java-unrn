package ar.unrn.tp3.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.unrn.tp3.modelo.Empleado;
import ar.unrn.tp3.modelo.RegistroDeEmpleados;

public class RegistroDeEmpleadosEnDisco implements RegistroDeEmpleados {

	@Override
	public void registrar(Empleado emp) {
		try {
			if(!existeUnEmpleado(emp))
			Files.write(Paths.get("C:\\Users\\ELJUEEN\\Desktop\\archivoTP3empleados.txt"), emp.toString().getBytes(),
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("No se pudo persistir...", e);
		}
	}

	@Override
	public ArrayList<Empleado> obtenerEmpleados() {
		try {
			List<String> lineaCadaEmpleado = Files.readAllLines(Paths.get("C:\\Users\\ELJUEEN\\Desktop\\archivoTP3empleados.txt"));
			ArrayList<Empleado> empleados = new ArrayList<Empleado>();
			for (String s : lineaCadaEmpleado) {
				String[] split = s.split(",");
				String fecha = split[2];
				String[] split2 = fecha.split("-");
				LocalDate cumple = LocalDate.of(Integer.parseInt(split2[0]), Integer.parseInt(split2[1]),
						Integer.parseInt(split2[2]));
				Empleado emp = new Empleado(split[0], split[1], cumple, split[3]);
				empleados.add(emp);

			}
			
			return empleados;
			
		} catch (IOException e) {
			System.out.println("No se pueden obtener los empleados desde el archivo.");
		}

		return null;
	}

	@Override
	public boolean existeUnEmpleado(Empleado emp) {
		try {
			List<String> lineaCadaEmpleado = Files.readAllLines(Paths.get("C:\\Users\\ELJUEEN\\Desktop\\archivoTP3empleados.txt"));
			ArrayList<Empleado> empleados = new ArrayList<Empleado>();
			for (String s : lineaCadaEmpleado) {
				String[] split = s.split(",");
				String fecha = split[2];
				String[] split2 = fecha.split("-");
				LocalDate cumple = LocalDate.of(Integer.parseInt(split2[0]), Integer.parseInt(split2[1]),
						Integer.parseInt(split2[2]));
				Empleado empl = new Empleado(split[0], split[1], cumple, split[3]);
				empleados.add(empl);

			}
			
			for (Empleado e : empleados) {
				if(e.obtenerEmail().equals(emp.obtenerEmail())) {
					return true;
				}
			}
			
			
		} catch (IOException e) {
			System.out.println("No se pueden obtener los empleados desde el archivo.");
		}

		return false;
	}
}
