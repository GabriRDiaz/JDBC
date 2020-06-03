package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	private static Connection conexion;

	public DbConnection(Connection conexion, String user, String pass) throws SQLException {
		super();
		this.conexion = DriverManager.getConnection("jdbc:mysql://localhost/acme?serverTimezone=Europe/Madrid", user, pass);
	}

	public static Connection getConexion() {
		return conexion;
	}
	
}
