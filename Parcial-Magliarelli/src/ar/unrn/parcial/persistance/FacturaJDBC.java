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
import ar.unrn.parcial.modelo.ValidarLitrosException;

public class FacturaJDBC implements RepositorioDeFacturas {

	private Connection dbConn;

	@Override
	public void registrarFactura(LocalDateTime fecha, Combustible tipoDeCombustible, int litros)
			throws ValidarLitrosException {
		// TODO Auto-generated method stub
		conectarConBaseDeDatos();
		try {
			PreparedStatement st = dbConn
					.prepareStatement("insert into facturas(fecha, combustible, litros, monto) values (?,?,?,?)");

			st.setTimestamp(1, Timestamp.valueOf(fecha));
			st.setString(2, tipoDeCombustible.verTipoDeCombustible());
			st.setInt(3, litros);
			st.setDouble(4, calcularMontoDeFactura(fecha, tipoDeCombustible, litros));
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			throw new RuntimeException("Error en cargar factura");
		}
	}

	@Override
	public double calcularMontoDeFactura(LocalDateTime fecha, Combustible tipoDeCombustible, int litros)
			throws ValidarLitrosException {
		Litros litrosTotal = new Litros(litros);
		Factura factura = new Factura(fecha, tipoDeCombustible, litrosTotal);
		return factura.calcularMontoTotal();
	}

	@Override
	public ArrayList<Factura> obtenerFacturas() throws Exception {
		conectarConBaseDeDatos();
		try {
			ArrayList<Factura> list = new ArrayList<Factura>();
			Statement st = dbConn.createStatement();
			ResultSet resul = st.executeQuery("select * from facturas F;");
			Combustible tipoCombustible = null;
			while (resul.next()) {
				LocalDateTime f = resul.getTimestamp("F.fecha").toLocalDateTime();
				Litros litros = new Litros(resul.getInt("F.litros"));
				if (resul.getString("F.combustible").equals("Super"))
					tipoCombustible = new Super(90);
				else
					tipoCombustible = new Comun(70);

				list.add(new Factura(f, tipoCombustible, litros));
			}
			return list;
		} catch (SQLException e) {
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

			while (resul.next()) {
				LocalDateTime f = resul.getTimestamp("F.fecha").toLocalDateTime();
				if (estaEnElRangoDeFechas(inicio, fin, f)) {
					Litros litros = new Litros(resul.getInt("F.litros"));
					if (resul.getString("F.combustible").equals("Super"))
						tipoCombustible = new Super(90);
					else
						tipoCombustible = new Comun(70);

					list.add(new Factura(f, tipoCombustible, litros));
				}

			}

			return list;

		} catch (SQLException e) {
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
		if ((fechaFactura.isAfter(inicio) || fechaFactura.isEqual(inicio))
				&& (fechaFactura.isBefore(fin) || fechaFactura.isEqual(fin)))
			return true;
		return false;
	}

}
