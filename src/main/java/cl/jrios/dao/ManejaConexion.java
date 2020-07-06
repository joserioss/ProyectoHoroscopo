package cl.jrios.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class ManejaConexion {
	
	private static String DB_URL = "jdbc:sqlite:C:\\Users\\NI5B35\\eclipse-workspace-19-12\\horoscopo\\bdusuario.db";
	private static String DB_USER = "admin";
	private static String DB_PWD = "1234";
	
	private static final Logger LOG = Logger.getLogger(ManejaConexion.class.getName());
	
	private static ManejaConexion manejaConexion;
	
	public static ManejaConexion obtenerManejo() {
		if (manejaConexion == null) {
			manejaConexion = new ManejaConexion();
		}
		return manejaConexion;
	}
	
	public Connection obtenerConexion() throws SQLException{
		Connection conexion = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection(DB_URL,DB_USER, DB_PWD);
		}catch(ClassNotFoundException e) {
			LOG.severe("El driver no pudo ser cargado: " + e.getMessage());
		}catch(SQLException ex) {
			LOG.severe("No se pudo obtener conexion: " + ex.getMessage());
			throw new SQLException();
		}
		return conexion;
	}
	
}
