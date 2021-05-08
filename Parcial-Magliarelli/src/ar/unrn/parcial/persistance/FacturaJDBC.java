package ar.unrn.parcial.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

import ar.unrn.parcial.modelo.Combustible;
import ar.unrn.parcial.modelo.Comun;
import ar.unrn.parcial.modelo.Factura;
import ar.unrn.parcial.modelo.Litros;
import ar.unrn.parcial.modelo.RepositorioDeFacturas;
import ar.unrn.parcial.modelo.Super;


public class FacturaJDBC implements RepositorioDeFacturas {

		private Connection dbConn;

		@Override
		public void registrarFactura(Factura f) {
			// TODO Auto-generated method stub
			conectarConBaseDeDatos();
			try {
				PreparedStatement st = dbConn.prepareStatement("insert into facturas(fecha, combustible, litros, monto) values (?,?,?,?)");
				
				Date fecha = new Date(f.fechaDeFactura().getYear(), f.fechaDeFactura().getMonthValue(), f.fechaDeFactura().getDayOfMonth());
				Time hora = new Time(f.fechaDeFactura().getHour(), f.fechaDeFactura().getMinute(), f.fechaDeFactura().getSecond());
				st.setTimestamp(1, Timestamp.valueOf(f.fechaDeFactura()));
				st.setString(2, f.verTipoDeCombustible());
				st.setInt(3, f.cantidadDeLitros());
				st.setDouble(4, f.calcularMontoTotal());
				st.executeUpdate();
				st.close();
			} catch(SQLException e) {
				throw new RuntimeException("Error en cargar factura");
			}
		}

		@Override
		public ArrayList<Factura> obtenerFacturas() throws Exception {
			conectarConBaseDeDatos();
			try {
			ArrayList<Factura> list = new ArrayList<Factura>();
			Statement st = dbConn.createStatement();
			ResultSet resul = st.executeQuery("select * from facturas F;");
			Combustible tipoCombustible = null;
			RepositorioDeFacturas repo = new RegistroDeFacturasEnMemoria();
			while (resul.next()) {
				LocalDateTime f = resul.getTimestamp("F.fecha").toLocalDateTime();
				Litros litros = new Litros(resul.getInt("F.litros"));
				if(resul.getString("F.combustible").equals("Super"))
					tipoCombustible = new Super(90);
				else
					tipoCombustible = new Comun(70);
				
				list.add(new Factura(f, tipoCombustible, litros, repo));
			}
			return list;
			} catch(SQLException e) {
				throw new RuntimeException("Error en cargar factura");
			}
			
		}
		
		@Override
		public ArrayList<Factura> obtenerFacturasEntreFechas(LocalDateTime inicio, LocalDateTime fin) throws Exception {
			conectarConBaseDeDatos();
			try {
				ArrayList<Factura> list = new ArrayList<Factura>();
				Statement st = dbConn.createStatement();
				ResultSet resul = st.executeQuery("select * from facturas F;");
				Combustible tipoCombustible = null;
				RepositorioDeFacturas repo = new RegistroDeFacturasEnMemoria();
				
				while (resul.next()) {
					LocalDateTime f = resul.getTimestamp("F.fecha").toLocalDateTime();
					if(estaEnElRangoDeFechas(inicio, fin, f)) {
						Litros litros = new Litros(resul.getInt("F.litros"));
						if(resul.getString("F.combustible").equals("Super"))
							tipoCombustible = new Super(90);
						else
							tipoCombustible = new Comun(70);
						
						list.add(new Factura(f, tipoCombustible, litros, repo));
					}
					
					
				}
				
				return list;
				
				} catch(SQLException e) {
					throw new RuntimeException("Error en cargar factura");
				}
		}
		
		
		private void conectarConBaseDeDatos() {
			// TODO Auto-generated method stub
			String url = "jdbc:mysql://localhost:3306/parcialoo2";
			String user = "root";
			String password = "";
			try {
				this.dbConn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

	
		private boolean estaEnElRangoDeFechas(LocalDateTime inicio, LocalDateTime fin, LocalDateTime fechaFactura) {
			if((fechaFactura.isAfter(inicio) || fechaFactura.isEqual(inicio)) 
					&& (fechaFactura.isBefore(fin) || fechaFactura.isEqual(fin))) 
				return true;
			return false;
		}
	
}
