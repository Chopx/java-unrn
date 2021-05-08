package ar.unrn.parcial.persistance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.unrn.parcial.modelo.Combustible;
import ar.unrn.parcial.modelo.Comun;
import ar.unrn.parcial.modelo.Factura;
import ar.unrn.parcial.modelo.Litros;
import ar.unrn.parcial.modelo.RepositorioDeFacturas;
import ar.unrn.parcial.modelo.Super;

public class RegistroDeFacturasEnDisco implements RepositorioDeFacturas{

	@Override
	public void registrarFactura(Factura f) {
			
			String fecha = f.fechaDeFactura().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
			String hora = f.fechaDeFactura().format(DateTimeFormatter.ofPattern("h:mm"));
	        String litros = Integer.toString(f.cantidadDeLitros());
	        String monto = Double.toString(f.calcularMontoTotal());
	        String stringFactura = fecha + "," + hora + "," + f.verTipoDeCombustible() + "," + litros + "," + monto + "\n";
		try {
			Files.write(Paths.get("C:\\Users\\ELJUEEN\\Desktop\\archivoParcial.txt"), stringFactura.getBytes(),
					StandardOpenOption.APPEND);
		} catch (IOException e) {
			throw new RuntimeException("No se pudo persistir...", e);
		}
	}
	
	

	@Override
	public ArrayList<Factura> obtenerFacturas() throws Exception {
		try {
			List<String> lineaCadaFactura = Files.readAllLines(Paths.get("C:\\Users\\ELJUEEN\\Desktop\\archivoParcial.txt"));
			ArrayList<Factura> facturas = new ArrayList<Factura>();
			Combustible tipoCombustible = null;
			RepositorioDeFacturas repo = new RegistroDeFacturasEnMemoria();
			for (String s : lineaCadaFactura) {
				String[] split = s.split(",");
				String fecha = split[0];
				String[] split2 = fecha.split("-");
				String hora = split[1];
				String[] split3 = hora.split(":");
				LocalDateTime fechaDate = LocalDateTime.of(Integer.parseInt(split2[2]), Integer.parseInt(split2[1]),
						Integer.parseInt(split2[0]), Integer.parseInt(split3[0]), Integer.parseInt(split3[1]));
				if(split[2].equals("Super"))
					tipoCombustible = new Super(90);
				else
					tipoCombustible = new Comun(70);
				Litros litros = new Litros(Integer.parseInt(split[3]));
				Factura fact = new Factura(fechaDate, tipoCombustible, litros, repo);
				facturas.add(fact);

			}
			
			return facturas;
			
		} catch (IOException e) {
			System.out.println("No se pueden obtener los empleados desde el archivo.");
		}

		return null;
	}
	
	
	@Override
	public ArrayList<Factura> obtenerFacturasEntreFechas(LocalDateTime inicio, LocalDateTime fin) throws Exception {
		try {
			List<String> lineaCadaFactura = Files.readAllLines(Paths.get("C:\\Users\\ELJUEEN\\Desktop\\archivoParcial.txt"));
			ArrayList<Factura> facturas = new ArrayList<Factura>();
			Combustible tipoCombustible = null;
			RepositorioDeFacturas repo = new RegistroDeFacturasEnMemoria();
			for (String s : lineaCadaFactura) {
				String[] split = s.split(",");
				String fecha = split[0];
				String[] split2 = fecha.split("-");
				String hora = split[1];
				String[] split3 = hora.split(":");
				LocalDateTime fechaDate = LocalDateTime.of(Integer.parseInt(split2[2]), Integer.parseInt(split2[1]),
						Integer.parseInt(split2[0]), Integer.parseInt(split3[0]), Integer.parseInt(split3[1]));
				if(split[2].equals("Super"))
					tipoCombustible = new Super(90);
				else
					tipoCombustible = new Comun(70);
				Litros litros = new Litros(Integer.parseInt(split[3]));
				Factura fact = new Factura(fechaDate, tipoCombustible, litros, repo);
				if(estaEnElRangoDeFechas(inicio, fin, fechaDate)) 
					facturas.add(fact);

			}
		
			
			return facturas;
			
			
		} catch(IOException e) {
				throw new RuntimeException("Error en cargar factura");
		}
	}

	private boolean estaEnElRangoDeFechas(LocalDateTime inicio, LocalDateTime fin, LocalDateTime fechaFactura) {
		if((fechaFactura.isAfter(inicio) || fechaFactura.isEqual(inicio)) 
				&& (fechaFactura.isBefore(fin) || fechaFactura.isEqual(fin))) 
			return true;
		return false;
	}
	
}
