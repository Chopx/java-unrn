package ar.unrn.tp3.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.unrn.tp3.modelo.Participante;
import ar.unrn.tp3.modelo.RepositorioDeParticipante;

public class ParticipanteJDBC implements RepositorioDeParticipante{

	private Connection dbConn;

	@Override
	public void agregarParticipante(Participante p) {
		// TODO Auto-generated method stub
		conectarConBaseDeDatos();
		try {
			PreparedStatement st = dbConn.prepareStatement("insert into participantes(nombre, telefono, region) values (?,?,?)");
			st.setString(1, p.obtenerNombre());
			st.setString(2, p.obtenerTelefono());
			st.setString(3, p.obtenerRegion());
			st.executeUpdate();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			st.close();
		}
	}

	private void conectarConBaseDeDatos() {
		// TODO Auto-generated method stub
		String url = "jdbc:derby://localhost:1527/participantes";
		String user = "app";
		String password = "app";
		try {
			this.dbConn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
