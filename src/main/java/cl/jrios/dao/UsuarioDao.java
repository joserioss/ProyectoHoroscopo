package cl.jrios.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import cl.jrios.entidades.Usuario;

public class UsuarioDao {

	private static final ManejaConexion manejaConexion = ManejaConexion.obtenerManejo();
	private static final Logger LOG = Logger.getLogger(UsuarioDao.class.getName());

	public int eliminar(int id) {
		int filasAfectadas = 0;
		
		String consulta = "DELETE FROM USUARIO WHERE ID = ?";
		try( Connection conexion = manejaConexion.obtenerConexion();
	            PreparedStatement ps = conexion.prepareStatement(consulta);){
			ps.setInt(1, id);
			
            filasAfectadas = ps.executeUpdate();
            if(filasAfectadas != 1)
                throw new SQLException("No se elimina ningun registro");
		}catch(SQLException e) {
			LOG.warning("Consulta:" + consulta);
            LOG.severe("Error delete: " + e.getMessage());
		}
		return filasAfectadas;
	}
	
	public Usuario buscarPorId(int id) {
		Usuario usuario = new Usuario();
		String consulta = "SELECT ID, CORREO, CONTRASENIA, NOMBRE, ANIONACIMIENTO FROM USUARIO WHERE ID = " + id;
		try (Connection conexion = manejaConexion.obtenerConexion();
				PreparedStatement ps = conexion.prepareStatement(consulta);
				ResultSet rs = ps.executeQuery();
				) {
			if (rs.next()) {
				usuario.setId(rs.getInt("id"));
				usuario.setCorreo(rs.getString("correo"));
				usuario.setContrasenia(rs.getString("contrasenia"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setAnioNacimiento(rs.getInt("anioNacimiento"));
			}
			else {
				throw new SQLException("No se encuentra el registro en la base de datos");
			}
		} catch (SQLException e) {
			LOG.warning("Consulta: " + consulta);
			LOG.severe("Error update: " + e.getMessage());
		}
		return usuario;
	}

	public int actualizar(int id, Usuario usuario) {
		int filasAfectadas = 0;
		String consulta = "UPDATE USUARIO SET CORREO = ?, CONTRASENIA =?, NOMBRE = ?, ANIONACIMIENTO = 0 WHERE ID = ?";

		try (Connection conexion = manejaConexion.obtenerConexion();
				PreparedStatement ps = conexion.prepareStatement(consulta);) {
			ps.setString(1, usuario.getCorreo());
			ps.setString(2, usuario.getContrasenia());
			ps.setString(3, usuario.getNombre());
			ps.setInt(4, usuario.getAnioNacimiento());
			ps.setInt(5, id);

			filasAfectadas = ps.executeUpdate();
			if (filasAfectadas != 1) {
				throw new SQLException("Error al actualizar registro");
			}

		} catch (SQLException e) {
			LOG.warning("Consulta:  " + consulta);
			LOG.severe("Error ingreso: " + e.getMessage());
		}
		return filasAfectadas;
	}

	public int ingresar(Usuario usuario) {
		int filasAfectadas = 0;
		String consulta = "INSERT INTO USUARIO (CORREO, CONTRASENIA, NOMBRE, ANIONACIMIENTO) VALUES(?, ?, ?, ?)";

		try (Connection conexion = manejaConexion.obtenerConexion();
				PreparedStatement ps = conexion.prepareStatement(consulta);) {

			ps.setString(1, usuario.getCorreo());
			ps.setString(2, usuario.getContrasenia());
			ps.setString(3, usuario.getNombre());
			ps.setInt(4, usuario.getAnioNacimiento());

			filasAfectadas = ps.executeUpdate();
			if (filasAfectadas != 1) {
				throw new SQLException("Error al insertar registro");
			}

		} catch (SQLException e) {
			LOG.warning("Consulta: " + consulta);
			LOG.severe("Error ingreso: " + e.getMessage());
		}
		return filasAfectadas;
	}

	public List<Usuario> obtenerTodos() {
		List<Usuario> usuarios = new ArrayList<>();
		String consulta = "SELECT ID, CORREO, CONTRASENIA, NOMBRE, ANIONACIMIENTO FROM USUARIO";
		try (Connection conexion = manejaConexion.obtenerConexion();
				PreparedStatement ps = conexion.prepareStatement(consulta);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setCorreo(rs.getString("correo"));
				usuario.setContrasenia(rs.getString("contrasenia"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setAnioNacimiento(rs.getInt("anioNacimiento"));

				usuarios.add(usuario);
			}

		} catch (SQLException e) {
			LOG.warning("Consulta:  " + consulta);
			LOG.severe("Error al obtener todos: " + e.getMessage());
		}
		return usuarios;
	}

}
